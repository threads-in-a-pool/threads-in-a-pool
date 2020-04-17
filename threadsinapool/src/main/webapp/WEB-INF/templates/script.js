
// define a callback function to run when the dom is ready
$(document).ready(function () {
  // ...

  function gestCustomers(response) {
    // do something with the data

    $('#customerDetails').hide();
    $('#customerList').show();

    var table = $('.table-customers');

    response.forEach(customer => {


      var row = '<tr><td>' + customer.id + '</td> <td>' + customer.firstName + '</td> <td>' +
        customer.lastName + '</td> <td>' + customer.email +
        '</td> <td>' + customer.phone +
        '</td><td>' + 
        '<button id="delete-' + customer.id + '" class="btn btn-delete btn-danger">Delete</button></td><td>' + 
        '<button id="view-' + customer.id + '" class="btn btn-view btn-success">' + 'Details' + '</button></td>' +
        '</tr>';

      $(row).appendTo(table);





    });

    function onDelete(event) {
      console.log(event);
      $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/javabank/api/customer/' + event.target.id.split('-').pop(),
        async: true,
        success: function () {
          location.reload();
          alert('ok');
        },
        error: function () {
          alert('error');
        }
      })



    };

    function customerDetails(event) {
      console.log(event);
      $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/javabank/api/customer/' + event.target.id.split('-').pop(),
        async: true,
        success: function (response) {
          
          $('#customerList').hide();
          $('#customerDetails').show();
        

            var table = $('.table-customer');
      
            var row = '<tr><td>' + response.id + '</td> <td>' + response.firstName + '</td> <td>' +
              response.lastName + '</td> <td>' + response.email +
              '</td> <td>' + response.phone +
              '</td><td>' + 
              '<button id="view" class="btn btn-goBack btn-success">' + 'goBack' + '</button></td>' +
              '</tr>';
      
            $(row).appendTo(table);
    
          
          alert('ok');
        
        },
        error: function () {
          alert('error');
        }
      })



    };

    $('.btn-delete').click(onDelete);
    $('.btn-view').click(customerDetails);
    $('.btn-goBack').click(getList);

   
  }



  function errorCallback(request, status, error) {
    // do something with the error
  }

  // perform an ajax http get request
  function getList() {
    $.ajax({
      url: 'http://localhost:8080/javabank/api/customer/',
      async: true,
      success: gestCustomers,
      error: errorCallback
    });
  };

  getList();

});