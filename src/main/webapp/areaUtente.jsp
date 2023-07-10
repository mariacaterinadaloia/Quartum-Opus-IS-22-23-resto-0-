<%@ page import="utente.model.UtenteBean" %><%--
  Created by IntelliJ IDEA.
  User: MAURIZIO
  Date: 07/07/2023
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  UtenteBean user = (UtenteBean) request.getSession().getAttribute("user");
  if (user == null) {
    request.setAttribute("destination", "/areaUtente.jsp");
    request.setAttribute("error", Boolean.FALSE);
    request.getRequestDispatcher("/login.jsp").forward(request, response);
  }
  if (user.isGestore()) {
    request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
  }


%>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>Area utente</title>
  <!-- Favicon-->
  <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
  <link rel="stylesheet" type="text/css" href="styles/adminPage.css">
  <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
  <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Bootstrap icons-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
</head>
<body>
<body class="d-flex flex-column min-vh-100">
<jsp:include page="header.jsp"/>

<div class="container-fluid">
  <div class="row flex-nowrap">
    <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark">
      <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
        <a href="/" class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none">
          <span class="fs-5 d-none d-sm-inline">Menu</span>
        </a>
        <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
          <li class="nav-item">
            <a href="./areaUtente.jsp" class="nav-link align-middle px-0">
              <i class="fs-4 bi-house"></i> <span class="ms-1 d-none d-sm-inline">Home</span>
            </a>
          </li>

          <li>
            <a href="./VisualizzaOrdiniController?email=<%=user.getMail()%>" class="nav-link px-0 align-middle">
              <i class="fs-4 bi-table"></i> <span class="ms-1 d-none d-sm-inline">Ordini</span></a>
          </li>
        </ul>
        <hr>

      </div>
    </div>
    <div class="col py-3">
      <h3>Benvenuto <%=user.getNome()%> <%=user.getCognome()%> nell'area utente!</h3>
      <p class="lead">
        Da qui potrai visualizzare i tuoi ordini ed effettuarne il download</p>

    </div>
  </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</body>
</html>
