var request = require('request');
var mostPopular = function (){
    return new Promise((resolve, reject) => {
        request('https://wishlist.neemu.com/onsite/impulse-core/ranking/mostpopular.json', function(error, response, body){
            if(error){
                reject(error)
            }else{
                resolve(body);
            }
        })
    });
}

module.exports = mostPopular;