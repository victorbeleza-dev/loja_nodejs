var request = require('request');
var priceReduction = require('./modules/priceReduction');
var mostPopular = require('./modules/mostPopular');
var express = require('express');
var app = express();

app.get('/', function(req, res, next) {
    mostPopular().then((result) => {
        console.log('1')
    });

    priceReduction().then((result) => {
        console.log('2')
     });
});

app.listen(8081, function(){
    console.log('service running on http://localhost:8081 ...');
});