
$(document).ready(function () {

    $(document).on('onClick', '.container', function (e) {
        alert('clicked');
    });
    $(document).on('onClick', '#tap', function (e) {
        alert('clicked');
    });

<<<<<<< HEAD
=======
    $.ajax({
        url: 'http://localhost:8080/threadsinapool/api/producer/event/list',
        async: true,
        success: successCallback,
        error: function(error) {
            console.log(error);
        }
    });

    function successCallback(response){
        events = response;
    };

    function populateCarosel(events) {

        $('#1').attr("src", events[1].imageUrl);
        $('#2').attr("src", events[2].imageUrl);
        $('#3').attr("src", events[3].imageUrl);
        $('#4').attr("src", events[4].imageUrl);
        $('#5').attr("src", events[5].imageUrl);
    }

    populateCarosel(events);
>>>>>>> 5c0fa53c92f519919330a6de2b12c8a37de7a6a2
});