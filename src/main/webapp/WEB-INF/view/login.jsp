<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>
<body>
<div class="container">
<div class="card text-center">
        <h3 class="card-header">Login with Username and Password</h3>
        <div class="card-block">
            <p class="card-text">
            <form name='f' action='/login' method='POST'>

                <%--<label class="sr-only" > Username </label>--%>
                <%--<div class="input-group mb-2 mr-sm-2 mb-sm-0">--%>
                    <%--<div class="input-group-addon">UserName:</div>--%>
                    <%--<input type="text" class="form-control" id="username" name="username" placeholder="Username">--%>
                <%--</div><br/>--%>
            <label class="sr-only" > User email </label>
            <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                <div class="input-group-addon">User email:</div>
                <input type="text" class="form-control" id="mail" name="mail" placeholder="mail">
            </div><br/>


                <label class="sr-only">Password</label>
                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                    <div class="input-group-addon">Password:</div>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                </div><br/>

                <button name="submit" type="submit" value="Login" class="btn btn-primary">Login</button><br/>

                <div class="form-check mb-2 mr-sm-2 mb-sm-0">
                    <input id="remember_me" name="remember-me" type="checkbox"/>
                    <label for="remember_me" class="inline">remember me</label>
                </div>
                <input name="_csrf" type="hidden" value="6829b1ae-0a14-4920-aac4-5abbd7eeb9ee"/>
            </form>
            </p>
        </div>

    <div class="alert alert-danger" role="alert">
        <strong>${error}</strong>
    </div>
    <div class="card-footer text-muted">
        @Spring Advance Welcome
    </div>
</div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>
</html>
