/**
 * Created by fantsay on 10/20/15.
 */
(function()
{
    'use strict';
    var SearchService = function($http)
    {
        var _this = this;
        _this.$http = $http;

    };

    SearchService.$inject=['$http'];

    SearchService.prototype = {
        searchAll : function(){return this.$http.get('/poster').then(function(request){return request.data})},
        searchByParam : function(data){return this.$http.post('/query',data).then(function(request){return request.data})}
        //searchBykeyword : function(keyword){},
        //searcByDate:function(date){},
        //searchByRubric : function(rubric){}


    };
    angular.module('appPoster').service('SearchService', SearchService);


}());

