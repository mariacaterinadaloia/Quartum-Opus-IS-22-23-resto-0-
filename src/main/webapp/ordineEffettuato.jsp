<%--
  Created by IntelliJ IDEA.
  User: MAURIZIO
  Date: 24/06/2023
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Ordine effettuato</title>

  <script src="libraries/jquery.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
          integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
          crossorigin="anonymous"></script>

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
          integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
          crossorigin="anonymous"></script>
  <link rel="icon" type="image/x-icon" href="images/favicon.ico">
</head>
</head>
<body class="d-flex flex-column min-vh-100">
<jsp:include page="header.jsp"/>
<div class="container text-center mt-5 mb-5">
  <h1>Ordine effettuato con successo</h1>
  <a class="btn btn-primary" href="./index.jsp" style="background-color: #800000; color:white">Torna alla homepage</a>
</div>


<jsp:include page="footer.jsp"/>
</body>
</html>
