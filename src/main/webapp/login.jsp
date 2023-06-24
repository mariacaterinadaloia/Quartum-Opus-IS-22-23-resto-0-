<%@ page import="utente.model.UtenteBean" %><%--
  Created by IntelliJ IDEA.
  User: Francesca
  Date: 07/01/2023
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UtenteBean user = (UtenteBean) request.getSession().getAttribute("user");
    if(user != null){
        response.sendRedirect(request.getContextPath() + "index.jsp");
        return;
    }
    Boolean error = (Boolean) request.getAttribute("error");
    if(error == null){
        error = false;
    }
%>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Login - Quartum Opus</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="styles/login.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<section class="vh-100">
    <div class="container-fluid h-custom">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="images/logo1.png"
                     class="img-fluid" alt="Sample image">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <form action="<%=response.encodeRedirectURL("LoginController")%>" method="post" name="LoginForm">
                    <%if(error==true){%>
                    <p id = "errorMessage" style="color:red;">Email e/o password errate, ritenta.</p>
                    <%}%>
                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <input type="email" id="form3Example3" name="email" class="form-control form-control-lg"
                               placeholder="es.mariorossi@gmail.com" />
                        <label class="form-label" for="form3Example3">Indirizzo email</label>
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-3">
                        <input type="password" name="password" id="form3Example4" class="form-control form-control-lg"
                               />
                        <label class="form-label" for="form3Example4">Password</label>
                    </div>

                    <div class="text-center text-lg-start mt-4 pt-2">
                        <button type="submit" class="btn btn-primary btn-lg"
                                style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
                        <p class="small fw-bold mt-2 pt-1 mb-0">Non hai un account? <a href="./signup.jsp"
                                                                                          class="link-danger">Registrati</a></p>
                    </div>

                </form>
            </div>
        </div>
    </div>

</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
