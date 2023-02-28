<%--
  Created by IntelliJ IDEA.
  User: Francesca
  Date: 07/01/2023
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<section class="h-100 h-custom">
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
                            <th>Quantità</th>
                            <th>Prezzo</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>

                        <tr>
                            <td>
                                <div class="d-flex align-items-center">
                                    <img src="https://i.imgur.com/2DsA49b.webp" class="img-fluid rounded-3"
                                    style="width: 120px;" alt="Bottle">

                                </div>
                            </td>

                            <td class="align-middle"> <div class="flex-column ms-4">
                                <p class="mb-2 ml-2">prova</p>

                            </div>
                            </td>
                            <td></td>

                            <td class="align-middle">
                                <div class="d-flex flex-row">

                                    <a class="btn btn-link px-2"
                                       href="">
                                        <i class="fa fa-minus"></i>
                                    </a>

                                    <h5 class="mt-1">1</h5>


                                    <a class="btn btn-link px-2"
                                       href="">
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </div>
                            </td>
                            <td class="align-middle">
                                <p class="mb-0" style="font-weight: 500;">10€</p>
                            </td>
                            <td class="align-middle">

                                <a class="btn btn-primary" href="" style="background-color: #800000; color:white">Elimina</a>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </div>
                <div class="container text-center">


                    <p>Effettua il login o registrati prima di finalizzare l'acquisto</p>
                    <a class="btn btn-primary mb-4" href="./login.jsp" style="background-color: #800000; color:white">Login</a>

                </div>


            </div>
        </div>
    </div>
</section>






<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
