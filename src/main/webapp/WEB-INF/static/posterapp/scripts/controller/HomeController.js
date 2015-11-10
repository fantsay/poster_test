(function () {
    'use strict';

    var HomeController = function (SearchService ){
        var _this = this;
        _this.products = [];



        SearchService.searchAll()
            .then(function (data) {
                _this.products = data;
            });


    };

    HomeController.$inject = ['SearchService','$rootScope'];
    angular.module('appPoster').controller('HomeController', HomeController);
    /**
     * Created by fantsay on 10/29/15.
     */
}());