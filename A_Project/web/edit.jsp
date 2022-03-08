<%-- 
    Document   : edit.jsp
    Created on : Apr 1, 2020, 1:09:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
            <div class="card card-body card-form " style="width:50rem">
                <form method="POST" action="editBlog">
                    <input type="hidden" name="id" value="${requestScope.b.id}">
                    <h1>Edit your Blog</h1>
                    <div class="form-group">
                        <input type="text" id="title" class="form-control" value="${requestScope.b.title}" name="title">
                    </div>
                    <div class="form-group">
                        <textarea id="body" class="form-control"  name="content">${requestScope.b.content}</textarea>
                    </div>
                    <input type="hidden" id="id" value="">
                    <button class="post-submit btn btn-primary btn-block" type="submit">Save</button>
                    <span class="form-end"></span>
                </form>
            </div>
            <br>

            <c:if test="${requestScope.fix != null}">
                <div class="text-center" style="width: 50%; margin-left: 8rem">
                    <p class="alert alert-success">Saved Successfully</p>
                </div>
            </c:if>
            
            <button><a href="main">Back</a></button>
        </div>
        <script>
            const currentAlert = document.querySelector(".alert");
            setTimeout(() => {
                currentAlert.remove()
            }, 2000)
        </script>
    </body>