var request = require('request');
var priceReduction = require('./modules/priceReduction');
var mostPopular = require('./modules/mostPopular');
var findProducts = require('./modules/findStep1')
var express = require('express');
var app = express();

app.get('/', function(req, res, next) {
    res.setHeader('Access-Control-Allow-Origin', '*');
    var mostPopularProducts = [];
    var priceReductionProducts = [];
    var allProducts = [];
    mostPopular().then((result) => {
        let productsId = JSON.parse(result);
        for(let i = 0; i < productsId.length; i++){
            let idString = productsId[i].recommendedProduct.id;   
            findProducts(idString).then((product) => {
                let prdct = (JSON.parse(product))
                mostPopularProducts.push(prdct);
                if(mostPopularProducts.length == 90){
                    priceReduction().then((resultR) => {
                        let productRId = (JSON.parse(resultR));
                        for (let y = 0; y < productRId.length; y++){
                            let idStringR = productRId[y].recommendedProduct.id;
                            findProducts(idStringR).then((productReduct) => {
                                let redPrdct = JSON.parse(productReduct)
                                priceReductionProducts.push(redPrdct);
                                console.log(priceReductionProducts.length)
                                if(priceReductionProducts.length == 87){
                                    allProducts.push(mostPopularProducts);
                                    allProducts.push(priceReductionProducts);
                                    res.status(200).send(allProducts);
                                }
                            }).catch(err => console.log(err));   
                        }
                    });
                }
            }).catch(error => {

            })
            
        }
        console.log(mostPopularProducts)
        
    }).catch(err => {
        console.log(err)
    });

    

    
});

app.listen(8081, function(){
    console.log('service running on http://localhost:8081 ...');
});