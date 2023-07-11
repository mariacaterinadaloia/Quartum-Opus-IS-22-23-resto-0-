<%@ page import="utente.model.Carrello" %>
<%@ page import="utente.model.UtenteBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="gestore.model.ProdottoBean" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: Francesca
  Date: 07/01/2023
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Carrello cart = (Carrello) request.getSession().getAttribute("carrello");
    UtenteBean user = (UtenteBean) request.getSession().getAttribute("user");

    if(cart==null){
        response.sendRedirect(response.encodeRedirectURL("CarrelloController"));
        return;
    }

    ArrayList<ProdottoBean> prodotti = cart.getItems();

    boolean flag=false;
    if(prodotti.size()==0) flag=true;
%>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Carrello - Quartum Opus</title>
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
<section class="h-100 h-custom mb-0">
    <div class="container h-100 py-5">
        <div class="row d-flex h-100">
            <div class="col">

                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th class="h5">Carrello</th>
                            <th>Prodotto</th>
                            <th></th>
                            <th>Prezzo</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <%if(!flag){ %>
                        <% for (ProdottoBean bean : prodotti){

                            double prezzo = bean.getPrezzo();
                            long ISBN = bean.getISBN();
                            DecimalFormat df = new DecimalFormat("#.00");
                        %>
                        <tr>
                            <td>
                                <div class="d-flex align-items-center">
                                    <img src="<%=bean.getCopertina()%>" class="img-fluid rounded-3"
                                    style="width: 120px;" alt="Bottle">

                                </div>
                            </td>

                            <td class="align-middle"> <div class="flex-column ms-4">
                                <p class="mb-2 ml-2"><%=bean.getNome()%></p>

                            </div>
                            </td>
                            <td></td>


                            <td class="align-middle">
                                <p class="mb-0" style="font-weight: 500;"><%=df.format(prezzo)%>€</p>
                            </td>
                            <td class="align-middle">

                                <a class="btn btn-primary" href="./CarrelloController?action=deleteCart&ISBN=<%=ISBN%>" style="background-color: #800000; color:white">Elimina</a>
                            </td>
                        </tr>
                        <%}%>
                        <%} else{%>
                            <h2 class="text-center font-weight-light">Non ci sono articoli nel carrello</h2>
                        <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container text-center">
        <%if(!flag){%>
        <a class="btn btn-primary mb-4" href="./CarrelloController?action=clearCart" style="background-color: #800000; color:white">Svuota carrello</a>
        <%} %>
        <br>
        <%if(!flag && user!=null){ %>
        <a class="btn btn-primary mb-4" href="./checkout.jsp" style="background-color: #800000; color:white">Vai al checkout</a>
        <%} else if(!flag && user==null){ %>
        <p>Effettua il login o registrati prima di finalizzare l'acquisto</p>
        <a class="btn btn-primary mb-4" href="./login.jsp" style="background-color: #800000; color:white">Login</a>
        <%} %>
    </div>
</section>




<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
