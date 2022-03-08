<%-- 
    Document   : signup
    Created on : Mar 28, 2020, 12:30:32 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://bootswatch.com/4/flatly/bootstrap.min.css" rel="stylesheet">
        <script crossorigin="anonymous" src="https://kit.fontawesome.com/1362bcbee6.js"></script>
        <title>Sign Up Page</title>
    </head>
    <body>
        <div class="container">
            <div id="second">
                <div class="myform form ">
                    <div class="logo mb-3">
                        <div class="col-md-12 text-center mt-5">
                            <h1>Signup</h1>
                        </div>
                    </div>
                    <form method="POST" action="signup">
                        <div class="form-group">
                            <label>Full Name</label>
                            <input class="form-control" id="name" name="name" placeholder="Enter Name"
                                   type="text">
                        </div>
                        <div class="form-group">
                            <label >Email address</label>
                            <input class="form-control" id="email" name="email" placeholder="Enter email"
                                   type="email">
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input class="form-control" id="password" name="password" placeholder="Enter Password"
                                   type="password">
                        </div>
                        <div class="text-center alert alert-danger" >
                            <p>This email is being used</p>
                        </div>
                        <div class="col-md-12 text-center mb-3">
                            <button class=" btn btn-block mybtn btn-primary tx-tfm post-signup" type="submit">Get Started For Free</button>
                        </div>
                        <div class="col-md-12 ">
                            <div class="form-group">
                                <p class="text-center"><a href="login" id="signin">Already have an account?</a></p>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
