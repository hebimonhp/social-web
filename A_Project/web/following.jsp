<%-- 
    Document   : following
    Created on : Apr 1, 2020, 5:23:03 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://bootswatch.com/4/flatly/bootstrap.min.css" rel="stylesheet">
        <script crossorigin="anonymous" src="https://kit.fontawesome.com/1362bcbee6.js"></script>
        <title>My Blog</title>
        <style>
            .fa-blog {
                width: 5rem;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <i class="fas fa-blog text-white fa-2x ml-3"></i>
            <div class="container">
                <a class="navbar-brand" href="main">Face Blog</a>
                <button aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler"
                        data-target="#navbarColor01" data-toggle="collapse" type="button">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarColor01">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">My Profile <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="following">Following <span class="sr-only">(current)</span></a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0" method="GET" action="search">
                        <input class="form-control mr-sm-2" placeholder="Search for someone" type="text" name="search">
                        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
                    </form>

                </div>
            </div>
            <form method="post" action="logout">
                <button class="btn btn-success my-2 my-sm-0" type="submit">Log Out</button>
            </form>
        </nav>
        
        
    </body>
</html>
