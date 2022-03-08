<%-- 
    Document   : show
    Created on : Apr 1, 2020, 3:39:36 PM
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
        <div class="container">
            <h1 style="margin-left: 20rem" class="mt-5">${requestScope.b.title}</h1>
            <p class="lead">${requestScope.b.content}</p>

            <hr>
            <c:choose>
                <c:when test="${requestScope.check == '0'}">
                    <form method="post" action="like">
                        <input type="hidden" value="${requestScope.b.likes}" name="like">
                        <input type="hidden" value="${requestScope.b.id}" name="id">
                        <div>${requestScope.count} <i class="fas fa-thumbs-up fa-1x mb-3" ></i></div>
                        <button style="display: inline-block" type="submit">Likes</button><h4 style="display: inline-block; margin-left: 2rem">Comments:</h4>
                    </form>
                </c:when>
                <c:otherwise>
                    <form method="post" action="unLike">
                        <input type="hidden" value="${requestScope.b.likes}" name="like">
                        <input type="hidden" value="${requestScope.b.id}" name="id">
                        <div>${requestScope.count} <i class="fas fa-thumbs-up fa-1x mb-3" ></i></div>
                        <button style="display: inline-block" type="submit">Unlike</button><h4 style="display: inline-block; margin-left: 2rem">Comments:</h4>
                    </form>
                </c:otherwise>
            </c:choose>
            
            <c:forEach items="${requestScope.comments}" var="c">
                <div class="card mb-2">
                    <strong>${c.username}: </strong> <span class="ml-1">${c.content}</span>
                </div>
            </c:forEach>
            <form method="POST" action="show">
                ${sessionScope.users.name}: <input type="text" name="content" style="width: 100%"> <br>
                <input type="hidden" name="commentTo" value="${requestScope.b.id}">
                <input type="hidden" name="commentFrom" value="${sessionScope.users.id}">
                <button type="submit" class="mt-2">Add Comment</button>
            </form>
        </div>     
    </body>
</html>
