
$(document).ready(function () {
    $(document).on('onClick', '.container', function (e) {
        alert('clicked');
    });
    $(document).on('onClick', '#tap', function (e) {
        alert('clicked');
    });
});