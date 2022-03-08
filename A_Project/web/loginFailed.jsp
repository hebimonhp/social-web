<%-- 
    Document   : login
    Created on : Mar 28, 2020, 12:24:31 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="https://bootswatch.com/4/flatly/bootstrap.min.css" rel="stylesheet">
        <script crossorigin="anonymous" src="https://kit.fontawesome.com/1362bcbee6.js"></script>
    </head>
    <body>
        <div class="container login-container">
            <div class="row login ">
                <div class="col-md-5 mx-auto mt-5">
                    <div id="first">
                        <div class="myform form ">
                            <div class="logo mb-3">
                                <div class="col-md-12 text-center">
                                    <h1>Login</h1>
                                </div>
                            </div>
                            <form id="login" method="POST" action="login">
                                <div class="form-group">
                                    <label >Email address</label>
                                    <input class="form-control" id="emailLogin" name="email" placeholder="Enter email"
                                           type="email">
                                </div>
                                <div class="form-group">
                                    <label >Password</label>
                                    <input class="form-control" id="passwordLogin" name="password" placeholder="Enter Password"
                                           type="password">
                                </div>
                                <div class="form-group">
                                    <p class="text-center">By signing up you accept our <a href="#">Terms Of Use</a></p>
                                </div>
                                <div class="text-center">
                                    <p class="alert alert-danger">Unable to login</p>
                                </div>
                                <div class="col-md-12 text-center">
                                    <button class="btn btn-block mybtn btn-primary post-login" type="submit">Login</button>
                                </div>
                                <div class="col-md-12 ">
                                    <div class="login-or">
                                        <hr class="hr-or">
                                        <span class="span-or">or</span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <p class="text-center">Don't have account? <a href="signup" id="signup">Sign up here</a></p>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            const currentAlert = document.querySelector(".alert");
            setTimeout(() => {
                currentAlert.remove()
            },2000)
        </script>
    </body>
</html>
