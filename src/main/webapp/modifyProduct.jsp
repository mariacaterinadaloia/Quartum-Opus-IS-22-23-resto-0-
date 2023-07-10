<%@ page import="gestore.model.AutoreBean" %>
<%@ page import="utente.model.UtenteBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String codice = request.getParameter("id");

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
            <a href="./OrdiniController" class="nav-link px-0 align-middle">
              <i class="fs-4 bi-table"></i> <span class="ms-1 d-none d-sm-inline">Ordini</span></a>
          </li>
          <li>
            <a href="./CatalogoAdminController" data-bs-toggle="collapse" class="nav-link px-0 align-middle ">
              <i class="fs-4 bi-card-list"></i> <span class="ms-1 d-none d-sm-inline">Modifica catalogo</span></a>

          </li>

          <li>
            <a href="./AutoriController" class="nav-link px-0 align-middle">
              <i class="fs-4 bi-people"></i> <span class="ms-1 d-none d-sm-inline">Modifica autori</span> </a>
          </li>
        </ul>
        <hr>

      </div>
    </div>
    <div class="col py-3">
      <div class="card m-auto">
        <div class="card-header">Modifica prodotto</div>
        <div class="card-body">


          <form id="nomeForm" method="POST" action="./ModificaProdottoController">
            <div class="mb-3">
              <label for="nome" class="form-label">Nome</label>
              <input type="text" class="form-control" id="nome" name="nome" required>
            </div>
            <input type="hidden" name="action" value="modifyNome">
            <input type="hidden" name="codice" value=<%=codice%>>
            <button type="submit" class="btn btn-primary">Modifica</button>
          </form>

          <form id="genereForm" method="POST" action="./ModificaProdottoController">
            <div class="mb-3">
              <label for="genere" class="form-label">Genere</label>
              <input type="text" class="form-control" id="genere" name="genere" required>
            </div>
            <input type="hidden" name="action" value="modifyGenere">
            <input type="hidden" name="codice" value=<%=codice%>>
            <button type="submit" class="btn btn-primary">Modifica</button>
          </form>

          <form id="annoForm" method="POST" action="./ModificaProdottoController">
            <div class="mb-3">
              <label for="anno" class="form-label">Anno</label>
              <input type="number" class="form-control" id="anno" name="anno" required>
            </div>
            <input type="hidden" name="action" value="modifyAnno">
            <input type="hidden" name="codice" value=<%=codice%>>
            <button type="submit" class="btn btn-primary">Modifica</button>
          </form>

          <form id="edizioneForm" method="POST" action="./ModificaProdottoController">
            <div class="mb-3">
              <label for="edizione" class="form-label">Edizione</label>
              <input type="number" class="form-control" id="edizione" name="edizione" required>
            </div>
            <input type="hidden" name="action" value="modifyEdizione">
            <input type="hidden" name="codice" value=<%=codice%>>
            <button type="submit" class="btn btn-primary">Modifica</button>
          </form>

          <form id="casaEditriceForm" method="POST" action="./ModificaProdottoController">
            <div class="mb-3">
              <label for="casaEditrice" class="form-label">Casa Editrice</label>
              <input type="text" class="form-control" id="casaEditrice" name="casa" required>
            </div>
            <input type="hidden" name="action" value="modifyCasa">
            <input type="hidden" name="codice" value=<%=codice%>>
            <button type="submit" class="btn btn-primary">Modifica</button>
          </form>

          <form id="copertinaForm" method="POST" action="./ModificaProdottoController">
            <div class="mb-3">
              <label for="copertina" class="form-label">Copertina</label>
              <input type="text" class="form-control" id="copertina" name="copertina" required>
            </div>
            <input type="hidden" name="action" value="modifyCopertina">
            <input type="hidden" name="codice" value=<%=codice%>>
            <button type="submit" class="btn btn-primary">Modifica</button>
          </form>

          <form id="prezzoForm" method="POST" action="./ModificaProdottoController">
            <div class="mb-3">
              <label for="prezzo" class="form-label">Prezzo</label>
              <input type="number" step="0.01" class="form-control" id="prezzo" name="prezzo" required>
            </div>
            <input type="hidden" name="action" value="modifyPrezzo">
            <input type="hidden" name="codice" value=<%=codice%>>
            <button type="submit" class="btn btn-primary">Modifica</button>
          </form>


        </div>
      </div>



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
