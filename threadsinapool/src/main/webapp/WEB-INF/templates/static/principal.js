
$(document).ready(function () {

    var events;

    $(document).on('onClick', '.container', function (e) {
        alert('clicked');
    });
    $(document).on('onClick', '#tap', function (e) {
        alert('clicked');
    });

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

        $('#1').attr("src", events[1].imageURL);
        $('#2').attr("src", events[2].imageURL);
        $('#3').attr("src", events[3].imageURL);
        $('#4').attr("src", events[4].imageURL);
        $('#5').attr("src", events[5].imageURL);
    }

    populateCarosel(events);
});