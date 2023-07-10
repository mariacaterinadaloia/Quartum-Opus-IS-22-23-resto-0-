<%@ page import="gestore.model.ProdottoBean" %>
<%@ page import="java.util.Collection" %>
<%@ page import="utente.model.RecensioneBean" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Francesca
  Date: 06/01/2023
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  ProdottoBean libro = (ProdottoBean) request.getAttribute("libro");
  ArrayList<RecensioneBean> recensioni = (ArrayList<RecensioneBean>) request.getAttribute("recensioni");
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
<jsp:include page="header.jsp"></jsp:include>
<section class="py-5">
  <div class="container px-4 px-lg-5 my-5">
    <div class="row gx-4 gx-lg-5 align-items-center">
      <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src=https://www.pixartprinting.it/blog/wp-content/uploads/2020/01/2-4.jpg alt="..." /></div>
      <div class="col-md-6">

        <h1 class="display-5 fw-bolder"><%=libro.getNome()%></h1>
        <div class="fs-5 mb-5">

          <span><%=libro.getPrezzo()%></span>
        </div>
        <p class="lead">Prova</p>
        <div class="d-flex">
          <a class="btn btn-outline-dark flex-shrink-0" href="./CarrelloController?action=addCart&ISBN=<%=libro.getISBN()%>">
            <i class="bi-cart-fill me-1"></i>
            Aggiungi al carrello
          </a>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Related items section-->
<section class="py-5 bg-light">
  <div class="container px-4 px-lg-5 my-5">
    <h2 class="mb-4">Recensioni</h2>
    <div class="row gx-4 gx-lg-5">

      <% for (RecensioneBean x: recensioni){ %>
      <div class="col-md-4 mb-5">
        <div class="card h-100">
          <div class="card-body">
            <h5 class="card-title fw-bold"><%=x.getNome()%> <%=x.getCognome()%></h5>
            <p class="card-text"><%=x.getText()%></p>
          </div>
        </div>
      </div>
      <% } %>

    </div>
  </div>
</section>
<!-- Footer-->
<footer class="py-5 bg-dark">
  <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Quartum Opus 2022</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>

</body>
</html>
