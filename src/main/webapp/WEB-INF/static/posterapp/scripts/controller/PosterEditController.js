(function () {
    'use strict';

    var PosterEditController = function (SearchService) {
        //var _this = this;
        //_this.products = [];
        //
        //SearchService.searchAll()
        //    .then(function (data) {
        //        _this.products = data;
        //    });
    };

    PosterEditController.$inject = ['SearchService'];
    angular.module('appPoster').controller('PosterEditController', PosterEditController);

}());