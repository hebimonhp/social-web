<%-- 
    Document   : main
    Created on : Mar 30, 2020, 1:39:57 AM
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

        <div class="container postsContainer mt-5">
            <div class="row" >
                <div class="col-sm-12 col-md-6 col-lg-5 my-1">
                    <div class="card card-body card-form " style="width:50rem">
                        <form method="POST" action="main">
                            <h1>Write Something</h1>
                            <p class="lead">Hello ${sessionScope.users.name}, how are you today?</p>
                            <div class="form-group">
                                <input type="text" id="title" class="form-control" placeholder="Blog Title" name="title">
                            </div>
                            <div class="form-group">
                                <textarea id="body" class="form-control" placeholder="Blog Content" name="content"></textarea>
                            </div>
                            <input type="hidden" id="id" value="">
                            <button class="post-submit btn btn-primary btn-block" type="submit">Post It</button>
                            <span class="form-end"></span>
                        </form>
                    </div>
                    <!--                    <div class="col-sm-12 col-md-6 col-lg-6 my-1 ">
                                            <div class="card">
                                                <div class="card-body">
                                                    Some content Some content Some content Some content Some content
                                                </div>
                                            </div>
                                        </div>-->
                    <c:forEach items="${requestScope.myBlogs}" var="b">
                        <div class="card my-3" style="width:50rem">
                            <div class="card-body mb-3">
                                <h4 class="card-title"><a href="show?id=${b.id}" style="text-decoration: none">${b.title}</a> </h4>
                                


                                <a href="editBlog?id=${b.id}" class="edit card-link">
                                    <i class="fa fa-pencil"></i>
                                </a>

                                <a  href="deleteBlog?id=${b.id}" class="delete card-link">
                                    <i class="fa fa-remove"></i>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="col-sm-12 col-md-6 col-lg-3 my-1" style="margin-left: 21rem">
                    <c:forEach items="${requestScope.followings}" var="f">
                        <div class="card mb-2 p-4" style="width: 100%">
                            ${f.friendName} has posted a blog with title: <a href="show?id=${f.blogID}">${f.blogTitle}</a>
                        </div>
                    </c:forEach>
                </div>
                <br>
            </div>
        </div>



    </body>
</html>
