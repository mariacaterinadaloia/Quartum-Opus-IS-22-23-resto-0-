<%@ page import="utente.model.UtenteBean" %><%--
  Created by IntelliJ IDEA.
  User: Francesca
  Date: 06/01/2023
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UtenteBean user = (UtenteBean) request.getSession().getAttribute("user");
%>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Quartum Opus</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
</head>
<body>
<header>
<nav class="shadow navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="index.jsp">
            <img src="images/logo.png" alt="..." height="40">
            <img src="images/logoscritta.png" alt="..." height="40">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="catalogDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Catalogo</a>
                    <ul class="dropdown-menu" aria-labelledby="catalogDropdown">
                        <li><a class="dropdown-item" href="./CatalogoController">Visualizza tutto</a></li>
                        <li><a class="dropdown-item" href="./CatalogoGenereController?genere=romanzo">Romanzi</a></li>
                        <li><a class="dropdown-item" href="./CatalogoGenereController?genere=thriller">Thriller</a></li>
                        <li><a class="dropdown-item" href="./CatalogoGenereController?genere=giallo">Gialli</a></li>
                        <li><a class="dropdown-item" href="./CatalogoGenereController?genere=fantasy">Fantasy</a></li>
                        <li><a class="dropdown-item" href="./CatalogoGenereController?genere=educativo">Educazione</a></li>
                    </ul>
                </li>
                <%if(user==null){%>
                <li class="nav-item"><a class="nav-link" href="./login.jsp">Login</a></li>
                <li class="nav-item"><a class="nav-link" href="./signup.jsp">Registrati</a></li>
                <%}
                else if(user.isGestore()){%>
                <li class="nav-item"><a class="nav-link" href="./adminPage.jsp">Area Admin</a></li>
                <li class="nav-item"><a class="nav-link" href="<%=response.encodeRedirectURL("LogoutController")%>">Logout</a></li>
                <%}
                else{%>
                <li class="nav-item"><a class="nav-link" href="./areaUtente.jsp">Area Utente</a></li>
                <li class="nav-item"><a class="nav-link" href="<%=response.encodeRedirectURL("LogoutController")%>">Logout</a></li>
                <%}%>

            </ul>
            <form class="d-flex" action="./carrello.jsp">
                <button class="btn btn-outline-dark" type="submit">
                    <i class="bi-cart-fill me-1"></i>
                    Carrello

                </button>
            </form>
        </div>
    </div>
</nav>
</header>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
