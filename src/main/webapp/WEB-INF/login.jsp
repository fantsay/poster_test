
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="static/lib/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/styles/styles.css">
    <link rel="icon" type="image/jpg" href="static/img/favicon.ico" />
    <title>Poster</title>

</head>
<body>

<div class="container" >
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Авторизируйтесь для продолжения</h1>
            <div class="account-wall">
                <img class="profile-img" src="static/img/icon.jpg" alt="">
                <form id = "form" action="login" method="post" class="form-signin"  >
                    <input type="text" class="form-control" placeholder="Email"  name="username" required autofocus>
                    <input type="password" class="form-control" placeholder="Password" name="password" required>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" >Login</button>
                    <label class="checkbox pull-left">
                        <input type="checkbox" value="remember-me">
                        Запомнить меня
                    </label>
                    <a href="#" class="pull-right need-help">Help? </a><span class="clearfix"></span>
                </form>
            </div>

            <a href="#" class="text-center new-account">Создать акаунт </a>
        </div>
    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>
</html>