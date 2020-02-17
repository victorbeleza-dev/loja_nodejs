var request = require('request');
var findProducts = function (id){
    return new Promise((resolve, reject) => {
        request('http://localhost:8080/products/' + id, function(error, response, body){
            if(error){
                reject(error)
            }else{
                resolve(body);
            }
        })
    });
}

module.exports = findProducts;