<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html ng-app="appPoster">
<head>

    <link rel="stylesheet" type="text/css" href="static/lib/bootstrap/css/bootstrap-theme.css">
    <link rel="stylesheet" type="text/css" href="static/lib/bootstrap/css/bootstrap.css">
    <%--<link rel="stylesheet" href="static/lib/bootstrap/bootstrap-select/css/bootstrap-select.min.css" />--%>
    <title></title>
</head>
<body>
<!--Nav -->
<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" style="background-color: #31b0d5" href="#">Poster</a>
        </div>


        <%--<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">--%>
            <%--<ul class="nav navbar-nav">--%>
                <%--<li class="dropdown">--%>
                    <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Все рубрики<span class="caret"></span></a>--%>
                    <%--<ul class="dropdown-menu">--%>
                        <%--<li><a href="#" ng-click="rubrica='meet'">Знакомства</a></li>--%>
                        <%--<li><a href="#">Товары</a></li>--%>
                        <%--<li><a href="#">Услуги</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
            <%--</ul>--%>




            <form class="navbar-form navbar-left" role="search" ng-controller="SearchController as sctl" ng-submit="sctl.posterSearch()">
                <div class="form-group" >
        <%--TODO:Рубрика должна тянуться с сервера--%>
                        <label for="sel1">Рубрика :</label>
                        <select name ="rubrick" ng-model="rubrick" class="form-control" id="sel1" >
                            <option></option>
                            <option>продажа</option>
                        <option>покупка</option>
                        <option>оренда</option>
                        <option>услуги</option>
                        <option>знакомсва</option>
                        <option>прочее</option>
                    </select>
                    </div>
                               <div class="form-group">
                    <input type="text" class="form-control" ng-model="searchRequestPoster" name="posterS" placeholder="Что ищем ?">
                </div>

                <div class="form-group">
                    <input type="text" class="form-control" ng-change="" ng-disabled="checked" ng-model="author" placeholder="Поиск по автору" >
                </div>
                <div class="checkbox">
                    <label><input type="checkbox" value="" ng-model="checked">Мои</label>
                </div>

                <button type="submit" class="btn btn-default">Поиск</button>

            </form>
            <ul class="nav navbar-nav navbar-right" >
                <!--Login and help-->
            </ul>
        </div>

</nav>
<!--Nav-->

<!--body-->
<div class="container">
    <div class="row" ng-init="currentView='search'" ng-include="'static/view/' + currentView + '.html'">
        </div>

    </div>

<!--body-->

<!-- Scripts-->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="static/lib/angularjs/angular.js"></script>
<script src="static/scripts/posterapp.js"></script>
<script src="static/scripts/service/SearchService.js"></script>
<script src="static/scripts/controller/SearchController.js"></script>
<script src="static/scripts/controller/HomeController.js"></script>
<%--<script src="static/lib/bootstrap/bootstrap-select/js/bootstrap-select.min.js"></script>--%>
<!-- Scripts-->



</body>
</html>