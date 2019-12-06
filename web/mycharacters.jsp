<!DOCTYPE html>
<jsp:useBean id="Usuario" type="model.Usuario" scope="session"/>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>PGCII - Game with HATEOS</title>


        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

    </head>
    <body>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <img src="images/ufabc-logo.png" class="rounded mx-auto d-block" width=150>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">

                    <h3 class="text-center">
                        Game with HateOS
                    </h3>
                </div>

            </div>
            <div class="row">
                <div class="col-md-12">

                    <h4 class="text-center">
                        Meus personagens
                    </h4>
                </div>
            </div>
            <div class="row" id="menu">
                <div class="col-md-1">
                    &nbsp;
                </div>
                <div class="col-md-8">
                    <ul class="nav">
                        <li class="nav-item ml-md-auto">
                            <a class="nav-link active" href="./myaccount.jsp">Minha Conta</a>
                        </li>
                        <li class="nav-item ml-md-auto">
                            <a class="nav-link" href="novopersonagem">Novo Personagem</a>
                        </li>
                        <li class="nav-item ml-md-auto">
                            <a class="nav-link" href="personagens">Meus Personagens</a>
                        </li>
                        <li class="nav-item ml-md-auto">
                            <a class="nav-link" href="novaskin">Nova Skin</a>
                        </li><li class="nav-item ml-md-auto">
                            <a class="nav-link" href="./index.html">Logout</a>
                        </li>
                    </ul>
                </div>
                <div class="col-md-1">
                    &nbsp;
                </div>
            </div>
            <c:forEach var="personagens" items="${Usuario.personagens}">
                <!--Várias Iterações-->
                <div class="row">
                    <div class="col-md-2"> &nbsp; </div>
                    <div class="col-md-8"> ${personagens.nick}
                    </div>
                    <div class="col-md-2"> &nbsp; </div>
                </div>
            </c:forEach>

        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>