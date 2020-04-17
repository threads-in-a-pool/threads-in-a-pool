$(document).ready(function() {

    var globalResponse;
    var animating = false;
    var cardsCounter = 0;
    var numOfCards = 0;
    var decisionVal = 80;
    var pullDeltaX = 0;
    var deg = 0;
    var eventImage;
    var eventName;
    var userName;
    var $card, $cardReject, $cardLike;

    function pullChange() {
        animating = true;
        deg = pullDeltaX / 10;
        $card.css("transform", "translateX("+ pullDeltaX +"px) rotate("+ deg +"deg)");

        var opacity = pullDeltaX / 100;
        var rejectOpacity = (opacity >= 0) ? 0 : Math.abs(opacity);
        var likeOpacity = (opacity <= 0) ? 0 : opacity;
        $cardReject.css("opacity", rejectOpacity);
        $cardLike.css("opacity", likeOpacity);

    };

    function release() {

        if (pullDeltaX >= decisionVal) {
            $card.addClass("to-right");
            //setEvent(localStorage.getItem("eventId"))
            setEvent(2);
            $('#currentEventImg').attr("src", eventImage);
            $('#currentEventName').text(eventName);

            getUser(globalResponse[cardsCounter].user);

            $('#currentTicketWe').text(userName);

            $('#nextEventImg').attr("src", eventImage);
            $('#nextEventName').text(eventName);

            getUser(globalResponse[cardsCounter].user);
            console.log(cardsCounter);
            $('#nextCardWe').text(userName);

        } else if (pullDeltaX <= -decisionVal) {
            $card.addClass("to-left");
            setEvent(localStorage.getItem("eventId"));
            $('#currentEventImg').attr("src", eventImage)
            $('#currentEventName').text(eventName);

            getUser(globalResponse[cardsCounter].user);

            $('#currentTicketWe').text(userName);

            $('#nextEventImg').attr("src", eventImage);
            $('#nextEventName').text(eventName);

            getUser(globalResponse[cardsCounter].user);
            console.log(cardsCounter);
            $('#nextCardWe').text(userName);

        }

        if (Math.abs(pullDeltaX) >= decisionVal) {
            $card.addClass("inactive");


            setTimeout(function() {
                $card.addClass("below").removeClass("inactive to-left to-right");
                cardsCounter++;
                if (cardsCounter === numOfCards) {
                    cardsCounter = 0;
                    $(".demo__card").removeClass("below");
                }
            }, 300);
        }

        if (Math.abs(pullDeltaX) < decisionVal) {
            $card.addClass("reset");
        }

        setTimeout(function() {

            $card.attr("style", "").removeClass("reset")
                .find(".demo__card__choice").attr("style", "");

            pullDeltaX = 0;
            animating = false;
        }, 300);
    };

    function setEvent(eventId){
        $.ajax({
            url: 'http://localhost:8080/threadsinapool/api/user/' + eventId + '/tickets',
            async: true,
            success: successCallback,
            error: function(error) {
                console.log(error);
            }
        });

        function successCallback(response){
            event = response;
            eventImage = event.imageUrl;
            eventName = event.name;
        };
    }

    function getUser(userId){

        $.ajax({
            url: 'http://localhost:8080/threadsinapool/api/user/' + userId,
            async: true,
            success: function(response){
                userName = response.username;
            },
            error: function(error) {
                console.log(error);
            }
        });

    }


    $(document).on("mousedown touchstart", ".demo__card:not(.inactive)", function(e) {

        $.ajax({
            url: 'http://localhost:8080/threadsinapool/api/producer/event/2/list',
            async: true,
            success: successCallback,
            error: function(error) {
                console.log(error);
            }
        });

        function successCallback(response){
            numOfCards = response.length;
            globalResponse = response;
            console.log(response);

        };

        if (animating) return;

        $card = $(this);
        $cardReject = $(".demo__card__choice.m--reject", $card);
        $cardLike = $(".demo__card__choice.m--like", $card);
        var startX =  e.pageX || e.originalEvent.touches[0].pageX;

        $(document).on("mousemove touchmove", function(e) {
            var x = e.pageX || e.originalEvent.touches[0].pageX;
            pullDeltaX = (x - startX);
            if (!pullDeltaX) return;
            pullChange();
        });

        $(document).on("mouseup touchend", function() {
            $(document).off("mousemove touchmove mouseup touchend");
            if (!pullDeltaX) return; // prevents from rapid click events
            release();
        });
    });


    function getItemByIndex(index, array) {
        var counter = 0;

        array.forEach(element => {
            if (counter == index)
            {
                return item;
            }

            counter++;
        });

    }

});