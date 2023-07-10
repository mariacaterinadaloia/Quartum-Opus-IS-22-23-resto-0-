<%@ page import="gestore.model.OrdineBean" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="utente.model.UtenteBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Collection<OrdineBean> ordini = (Collection<OrdineBean>) request.getAttribute("ordini");

    UtenteBean user = (UtenteBean) request.getSession().getAttribute("user");
    if (user == null || !user.isGestore()) {
        response.sendError(response.SC_FORBIDDEN, "Non sei admin!");
        return;
    }
%>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Admin page</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="styles/adminPage.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
</head>
<body>
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
                        <a href="./adminPage.jsp" class="nav-link align-middle px-0">
                            <i class="fs-4 bi-house"></i> <span class="ms-1 d-none d-sm-inline">Home</span>
                        </a>
                    </li>

                    <li>
                        <a href="./VisualizzaOrdiniAdminServlet" class="nav-link px-0 align-middle">
                            <i class="fs-4 bi-table"></i> <span class="ms-1 d-none d-sm-inline">Ordini</span></a>
                    </li>
                    <li>
                        <a href="./CatalogoServlet" data-bs-toggle="collapse" class="nav-link px-0 align-middle ">
                            <i class="fs-4 bi-card-list"></i> <span class="ms-1 d-none d-sm-inline">Modifica catalogo</span></a>

                    </li>

                    <li>
                        <a href="./UtentiServlet" class="nav-link px-0 align-middle">
                            <i class="fs-4 bi-people"></i> <span class="ms-1 d-none d-sm-inline">Visualizza clienti</span> </a>
                    </li>
                </ul>
                <hr>

            </div>
        </div>
        <div class="col py-3">
            <div class="card m-auto">
                <div class="card-header">Ordini effettuati</div>

                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>ID Ordine</th>
                        <th>Data</th>
                        <th>Mail utente</th>
                    </tr>
                    </thead>

                    <tbody>

                    <%
                        Iterator<OrdineBean> i= ordini.iterator();
                        while(i.hasNext()){
                            OrdineBean ordine = i.next();
                    %>
                    <tr>
                        <td><%=ordine.getId() %></td>
                        <td><%=ordine.getData()%></td>
                        <td><%=ordine.getUtente()%></td>
                    </tr>
                    <%} %>

                    </tbody>
                </table>

            </div>
        </div>

        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>