var request = require('request');
var priceReduction = require('./modules/priceReduction');
var mostPopular = require('./modules/mostPopular');
var express = require('express');
var app = express();

app.get('/', function(req, res, next) {
    mostPopular().then((result) => {
       res.send(result);
    });

    priceReduction().then((result) => {
        res.send(result);
     });
});

app.listen(8081, function(){
    console.log('service running on http://localhost:8081 ...');
});