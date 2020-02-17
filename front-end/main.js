var products;
const url = 'http://localhost:8081/';
fetch(url).then(function (response) {
  return response.json().then(function(json) {
    products = json;
    for(let i = 0; i < products[1].length; i++){
        $('.slider-price-reduction').slick('slickAdd','<image src=\"https:' + products[1][i].images[0].path + '\" > <p>' + products[1][i].name + '</p> </div> ');
    }
    for(let i = 0; i < products[0].length; i++){
      $('.slider-mostpopular').slick('slickAdd','<div> <image src=\"https:' + products[0][i].images[0].path + '\" > <p>' + products[0][i].name + '</p> </div> ');
  }
  });
})

$('.slider-mostpopular').slick({
    infinite: false,
    speed: 300,
    slidesToShow: 4,
  });

  $('.slider-price-reduction').slick({
    speed: 300,
    slidesToShow: 4,
    slideToScroll: 4
  });