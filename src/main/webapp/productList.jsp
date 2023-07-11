<%@ page import="gestore.model.ProdottoBean" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: Francesca
  Date: 08/01/2023
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Catalogo - Quartum Opus</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="styles/productList.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
    <style>
        #immagine {
            max-width: 100%;
            max-height: 100%;
        }
    </style>

    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<%

    Collection<ProdottoBean> libri = (Collection<ProdottoBean>) request.getAttribute("libri");

%>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br/>
<h2 class="text-center font-weight-light">Acquista un libro</h2>
    <div class="container pb-5 mb-sm-1 mt-2">

        <div class="row">
            <%
                Iterator i = libri.iterator();
                while(i.hasNext()){
                    ProdottoBean bean = (ProdottoBean) i.next();
                    if(!bean.isAcquistabile()) continue;
                    double prezzo = bean.getPrezzo();
                    DecimalFormat df = new DecimalFormat("#.00");
            %>

            <div class="col-md-4 col-sm-6">
                <div class="card border-0 mb-grid-gutter">
                    <a class="card-img-tiles border">
                        <div class="main-img"><img src="<%=bean.getCopertina()%>" id="immagine"></div>

                    </a>
                    <div class="card-body border mt-n1 py-4 text-center">
                        <h2 class="h5 mb-1"><%=bean.getNome() %></h2>
                        <span class="d-block mb-3 font-size-xs text-muted"><%=bean.getCasaEditrice() %></span
                        ><span class="font-weight-semibold"><%=df.format(prezzo)%>€</span>
                        <br/><br/>
                        <span><a class="btn btn-pill btn-outline-primary btn-sm" href="./ProductPageController?ISBN=<%=bean.getISBN()%>">Visualizza</a></span>
                    </div>
                </div>
            </div>
            <%} %>
        </div>
    </div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
