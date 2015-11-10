(function () {
    'use strict';

    var SearchController = function (SearchService,$scope) {
        var _this = this;
        _this._$scope = $scope;
        _this._$scope.products = [];



        SearchService.searchAll()
            .then(function (data) {
                _this._$scope.products = data;


            });



        _this._$scope.searchService = SearchService;
        _this._$scope.requestParam =[];

        _this.posterSearch = function(){
            _this._$scope.products.length=0;
            _this._$scope.requestParam.push(_this._$scope.rubrick);
           _this._$scope.requestParam.push(_this._$scope.searchRequestPoster);
             _this._$scope.requestParam.push(_this._$scope.author);
           _this._$scope.requestParam.push(_this._$scope.checked);
          SearchService.searchByParam(_this._$scope.requestParam).then(function(data){_this._$scope.products.push.apply(_this._$scope.products,data); console.log(_this._$scope.products);});

           _this._$scope.requestParam =[];

        };

    };
SearchController.$inject=['SearchService', '$scope'];



    angular.module('appPoster').controller('SearchController', SearchController);
    /**
     * Created by fantsay on 10/29/15.
     */
}());