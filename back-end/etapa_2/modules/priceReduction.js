var request = require('request');
var priceReduction = function (){
    return new Promise((resolve, reject) => {
        request('https://wishlist.neemu.com/onsite/impulse-core/ranking/pricereduction.json', function(error, response, body){
            if(error){
                reject(error)
            }else{
                resolve(body);
            }
        })
    });
}

module.exports = priceReduction;