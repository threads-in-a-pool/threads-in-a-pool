$(document).ready(function () {

    function customerDetails() {
        console.log('fuck');
        $.ajax({
          type: 'GET',
          url: 'http://localhost:8080/javabank/api/producer/event',
          async: true,
          success: function (response) {
            
            var grid = $('.card-columns');
            
            i = 0;
            while(i < 10) {
              
        
              var card =  '<div class="card">'+
                '<img class="card-img-top" src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fa.vsstatic.com%2Fmobile%2Fapp%2Fconcerts%2Ftool.jpg&f=1&nofb=1" alt="Card image cap">'+
                '<div class="card-body">' +
                    '<h5 class="card-title">' + + 'z</h5>' +
                    '<p class="card-text">' + + '</p>' +
                '</div>'+
                '</div>';
        
              $(card).appendTo(grid);
                i++;
            }
            location.reload();
            
            alert('ok');
          
          },
          error: function () {
                    
            var grid = $('.card-columns');
            
            i = 1;
            while(i < 8) {
              
                id = i
              var card =  '<div class="card">'+
                '<img class="card-img-top" src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/'+ id +'.png" alt="Card image cap">'+
                '<div class="card-body">' +
                    '<h5 class="card-title">' + + 'z</h5>' +
                    '<p class="card-text">' + + '</p>' +
                '</div>'+
                '</div>';
        
              $(card).appendTo(grid);
                i++;
            }
            
            alert('error');
          }
        })
  
  
  
    };

   
    customerDetails();


});