<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>
<body>
<c:import url="templates/header.jsp"/>
<div class="container">
    <h1>Search Page</h1>
    <div class="left-container">
        <form class="form-inline" method="post" action="/usersByName">
            <input id="name" name="name" class="form-control mr-sm-2" type="text"
                   placeholder="Search users by name">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit"> Search by name</button>
        </form>
    </div>
    <br/>

    <div class="left-container">
        <form class="form-inline" method="post" action="/usersByMail">
            <input id="email" name="email" class="form-control mr-sm-2" type="text"
                   placeholder="Search user by email">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search by email</button>
        </form>
    </div>
    <br/>

    <div class="left-container">
        <a href="/bookedTicket">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search booked ticket</button>
        </a>
    </div>
    <br/>

    <div class="left-container">
        <a href="/pdf">
            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Download PDF tickets</button>
        </a>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
        integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
        integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
        crossorigin="anonymous"></script>
</body>
</html>