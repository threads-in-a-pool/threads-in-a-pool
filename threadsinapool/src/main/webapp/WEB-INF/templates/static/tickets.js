$(document).ready(function () {

    function usertickets() {
        console.log('fuck');
        $.ajax({
          type: 'GET',
          url: 'http://localhost:8080/threadsinapool/api/user/1/tickets',
          async: true,
          success: function (response) {
            
            var grid = $('.card-columns');
            var imageurl = "";




            
            response.forEach(ticket => {
        
              var card =  '<div class="card">'+
                '<img class="card-img-top" src="' +  + '" alt="Card image cap">'+
                '<div class="card-body">' +
                    '<h5 class="card-title">' + + 'z</h5>' +
                    '<p class="card-text">' + + '</p>' +
                '</div>'+
                '</div>';
        
              $(card).appendTo(grid);
                
            });
            location.reload();
            
            alert('ok');
          
          },
          error: function () {
  
            alert('error');
          }
        })
  
  
  
    };

    function getimageurl() {
      $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/threadsinapool/api/user/1/tickets',
        async: true,
        success: function (response) {
          
          var grid = $('.card-columns');
          var imageurl = "";




          
          response.forEach(ticket => {
      
            var card =  '<div class="card">'+
              '<img class="card-img-top" src="' +  + '" alt="Card image cap">'+
              '<div class="card-body">' +
                  '<h5 class="card-title">' + + 'z</h5>' +
                  '<p class="card-text">' + + '</p>' +
              '</div>'+
              '</div>';
      
            $(card).appendTo(grid);
              
          });
          location.reload();
          
          alert('ok');
        
        },
        error: function () {

          alert('error');
        }
      })



  };

   
    usertickets();


});