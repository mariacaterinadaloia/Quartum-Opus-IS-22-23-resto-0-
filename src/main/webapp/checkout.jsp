<%@ page import="utente.model.Carrello" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="utente.model.ProdottoBean" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: Francesca
  Date: 08/01/2023
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>Checkout - Quartum Opus</title>
  <!-- Favicon-->
  <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
  <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Bootstrap icons-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
</head>
<%
  Carrello cart = (Carrello) request.getSession().getAttribute("carrello");
  ArrayList<ProdottoBean> items = cart.getItems();
%>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container mt-5 mb-5">

  <div class="row">
    <div class="col-md-4 order-md-2 mb-4">
      <h4 class="d-flex justify-content-between align-items-center mb-3">
        <span class="text-muted">Carrello</span>

      </h4>
      <ul class="list-group mb-3 sticky-top">
        <%
          DecimalFormat df = new DecimalFormat("#.00");
          for (ProdottoBean bean: items){

            double prezzo = bean.getPrezzo();

        %>
        <li class="list-group-item d-flex justify-content-between lh-condensed">
          <div>
            <h6 class="my-0"><%=bean.getNome()%></h6>

          </div>
          <span class="text-muted"><%=df.format(prezzo)%>€</span>
        </li>
        <%} %>

        <li class="list-group-item d-flex justify-content-between">
          <span>Totale</span>
          <strong><%=df.format(cart.getTotal())%>€</strong>
        </li>
      </ul>

    </div>
    <div class="col-md-8 order-md-1">
      <h4 class="mb-3">Dati per la spedizione</h4>
      <form name="checkoutForm" method="post" action="<%=response.encodeURL("CarrelloController")%>">


        <input name="action" value="buy" style="visibility: hidden">
        <h4 class="mb-3">Pagamento</h4>

        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="titolare">Nome titolare</label>
            <input type="text" class="form-control" id="titolare" name="titolare" placeholder="Mario Rossi" required>
            <p id="errTitolare" class="errTextInterior"></p>

          </div>
          <div class="col-md-6 mb-3">
            <label for="numeroCarta">Numero carta</label>
            <input type="text" class="form-control" id="numeroCarta" name="numeroCarta" maxlength="16" placeholder="1111222233334444" required>
            <p id="errCarta" class="errTextInterior"></p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3 mb-3">
            <label for="scadenza">Data di scadenza</label>
            <input type="text" class="form-control" id="scadenza" name="scadenza" maxlength="5" placeholder="mm/yy" required>
            <p id="errScadenza" class="errTextInterior"></p>
          </div>
          <div class="col-md-3 mb-3">
            <label for="cvv">CVV</label>
            <input type="password" class="form-control" id="cvv" name="cvv" maxlength="3" required>
            <p id="errCvv" class="errTextInterior"></p>
          </div>
        </div>
        <hr class="mb-4">

        <button class="btn btn-primary btn-lg btn-block" type="submit">Effettua ordine</button>
      </form>
    </div>
  </div>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
