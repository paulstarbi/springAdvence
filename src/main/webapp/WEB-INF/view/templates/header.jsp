<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="headers-region">
    <div class="alert alert-dark" role="alert">
        <nav class="navbar navbar-toggleable-md navbar-light bg-faded">
            <ul class="nav nav-pills">
                <li class="nav-item">
                    <a class="nav-link " href="/">Home </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/file">Add Users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/search">Search</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/booking">Booking</a>
                </li>
            </ul>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link active" href="/">Active: <security:authentication property="principal.username" /></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">
                        Log out
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
