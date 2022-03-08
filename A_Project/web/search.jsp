<%-- 
    Document   : search
    Created on : Apr 2, 2020, 1:34:58 AM
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
                            <a class="nav-link" href="profile">My Profile <span class="sr-only">(current)</span></a>
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
            <c:forEach items="${requestScope.users}" var="u" varStatus="loop">
                <div class="card my-3">
                    <div class="card-body mb-3">
                        <h4 class="card-title"><a href="showProfile?id=${u.id}">${u.name}</a> </h4>
                        <c:choose>
                            <c:when test="${u.checkFollow == false}">
                                <form method="POST" action="follow">
                                    <input type="hidden" value="${requestScope.searchName}" name="searchName">
                                    <input type="hidden" value="${u.id}" name="followID">
                                    <button type="submit" class="btn btn-success">Follow</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <form method="POST" action="unfollow">
                                    <input type="hidden" value="${requestScope.searchName}" name="searchName">
                                    <input type="hidden" value="${u.id}" name="unfollowID">
                                    <button type="submit" class="btn btn-danger" name="unfollowID">Un-Follow</button>
                                </form>
                            </c:otherwise>
                        </c:choose>
<!--                            <a  href="deleteFollowing?id=${u.id}" class="delete card-link">
                                <i class="fa fa-remove"></i>
                            </a>-->
                        
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
