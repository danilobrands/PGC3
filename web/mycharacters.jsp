<!DOCTYPE html>
<jsp:useBean id="Usuario" type="model.Usuario" scope="session"/>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>PGC - Game with HATEOAS</title>


        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

    </head>
    <body>

        <script type="text/javascript">
            function MinhaConta() {
                location.href = "myaccount.jsp";
            }
            function DeletarPersona(Id) {

                var xhr = new XMLHttpRequest();

                xhr.open("POST", "http://localhost:8084/PGCII/ExcluirPersonagemServlet", true);
                xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

                resultado = window.confirm("O personagem de Id: " + Id + " será deletado. Confirmar?");

                if (resultado === true) {
                    xhr.send("id="+Id);
                }
                
                MinhaConta();
                
            }
        </script>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <img src="images/ufabc-logo.png" class="rounded mx-auto d-block" width=150>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">

                    <h3 class="text-center">
                        Game with HATEOAS
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
                            <a class="nav-link" href="personagens23">Meus Personagens</a>
                        </li>
                        <li class="nav-item ml-md-auto">
                            <a class="nav-link" href="novaskin">Novo Personagem</a>
                        </li>
                    </li><li class="nav-item ml-md-auto">
                    <a class="nav-link" href="./index.html">Logout</a>
                </li>
            </ul>
        </div>
        <div class="col-md-1">
            &nbsp;
        </div>
    </div>

    <div class="row">
        <div class="col-md-2"> &nbsp;                   </div>
        <div class="col-md-1"><b> Código        </b>    </div>
        <div class="col-md-2"><b> Nome          </b>    </div>
        <div class="col-md-1"><b> Forca         </b>    </div>
        <div class="col-md-1"><b> Agilidade     </b>    </div>
        <div class="col-md-1"><b> Resistencia   </b>    </div>
        <div class="col-md-1"><b> Deletar       </b>    </div>
        <div class="col-md-1"> &nbsp;                   </div>
    </div>


    <p>
        <c:forEach var="personagens" items="${Usuario.personagens}">
            <!--Várias Iterações-->
        <p>
        <div class="row">
            <div class="col-md-2"> &nbsp;                   </div>
            <div class="col-md-1"> ${personagens.id}        </div>
            <div class="col-md-2"> ${personagens.nick}      </div>
            <div class="col-md-1"> ${personagens.forca}      </div>
            <div class="col-md-1"> ${personagens.agilidade}      </div>
            <div class="col-md-1"> ${personagens.resistencia}      </div>
            <div class="col-md-1"> <input type="button" value="x" onClick="DeletarPersona(${personagens.id})" class="btn-danger"></div>
            <div class="col-md-2"> &nbsp;                   </div>
        </div>
    </p>
</c:forEach>
</p>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>