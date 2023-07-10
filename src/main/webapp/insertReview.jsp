<%@ page import="utente.model.UtenteBean" %>
<%@ page import="java.util.Collection" %>
<%@ page import="gestore.model.OrdineBean" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="gestore.model.ProdottoBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String codice = request.getParameter("id");
  UtenteBean user = (UtenteBean) request.getSession().getAttribute("user");
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
            <a href="./visualizzaOrdini.jsp" class="nav-link px-0 align-middle">
              <i class="fs-4 bi-table"></i> <span class="ms-1 d-none d-sm-inline">Ordini</span></a>
          </li>
        </ul>
        <hr>

      </div>
    </div>
    <div class="col py-3">
      <div class="card m-auto">
        <div class="card-header">Inserisci recensione</div>
        <form action="./InserisciRecensioneController" method="POST" class="m-3">
          <div class="form-group">
            <label for="recensione" class="form-label">Inserisci recensione</label>
            <textarea class="form-control" id="recensione" name="testoRec" rows="5" required></textarea>
          </div>
          <input type="hidden" name="mail" value=<%=user.getMail()%>>
          <input type="hidden" name="ISBN" value=<%=codice%>>
          <button type="submit" class="btn btn-primary">Inserisci</button>
        </form>

      </div>
    </div>
  </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</body>
</html>
