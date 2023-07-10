<%@ page import="java.util.Collection" %>
<%@ page import="gestore.model.ProdottoBean" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="gestore.model.ProdottoDAO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
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
<jsp:include page="header.jsp"/>
<%
    Collection<ProdottoBean> libri = (Collection<ProdottoBean>) application.getAttribute("listaLibri");
%>
<header class="bg-dark py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">Homepage</h1>
            <p class="lead fw-normal text-white-50 mb-0">Benvenuto su Quartum Opus!</p>
        </div>
    </div>
</header>
<!-- Section-->
<section class="py-5">
    <h2 class="fw-bolder text-center">Libri consigliati</h2>
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <% Iterator<ProdottoBean> list = libri.iterator();
                for(int i=0; i<3; i++){
                    if(!list.hasNext()) break;
                        ProdottoBean libro = (ProdottoBean) list.next();

            %>
            <div class="col mb-5">
                <div class="card h-100">
                    <!-- Product image-->
                    <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Product name-->
                            <h5 class="fw-bolder"><%=libro.getNome()%></h5>
                            <!-- Product price-->
                            <%=libro.getPrezzo()%>
                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="./ProductPageController?ISBN=<%=libro.getISBN()%>">Visualizza</a></div>
                    </div>
                </div>
            </div>
            <%}%>
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