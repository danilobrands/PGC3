<!DOCTYPE html>
<jsp:useBean id="Usuario" type="model.Usuario" scope="session"/>
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
                        Bem vindo!!! ${Usuario.nome}
                    </h4>
                </div>
            </div>
            <div class="row" id="conteudo">
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
</div>
<div class="container-fluid">

    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center">
                Meus Dados           
            </h4></div>            
    </div>

    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">
            <form id="form" role="form" action="alteracadastro" method="POST">
                <div class="form-group">

                    <label for="txt_nome">
                        Seu nome
                    </label>
                    <input type="text" class="form-control" id="txt_nome" name="txtNome" value="${Usuario.nome}" disabled="true">
                </div>
                <div class="form-group">

                    <label for="txt_email">
                        Seu e-mail
                    </label>
                    <input type="email" class="form-control" id="txt_email" name="txtEmail" value="${Usuario.email}" disabled="true">

                    <div class="col-md-1">
                        &nbsp;
                    </div>
                    <input type="button" id="btn_altSenha" value="Alterar senha" onClick="SenhaOn()" class="btn btn-primary" disabled="true">
                    <div class="form-group" id="grp_senha" hidden>
                        <label for="exampleInputPassword1" id="exampleInputPassword1s" id="lbl_novaSenha">
                            Nova senha
                        </label>
                        <input type="password" class="form-control" value="${Usuario.senha}" id="txt_senha1" name="txtSenha">
                        <label for="exampleInputPassword1" id="exampleInputPassword1s" id="lbl_confirmaSenha">
                            Confirme a senha
                        </label>
                        <input type="password" class="form-control" value="${Usuario.senha}" id="txt_senha2" name="txtSenha2">
                    </div>
                </div>

                <div>

                    <script type="text/javascript">

                        function Editar() {
                            $('#txt_nome').attr("disabled", false);
                            $('#txt_email').attr("disabled", false);
                            $('#btn_altSenha').attr("disabled", false);
                            $('#btn_editar').attr("hidden", true);
                            $('#btn_salvar').attr("hidden", false);
                            $('#btn_cancelar').attr("hidden", false);
                            //document.getElementById("btn_editar").style.visibility = "hidden";
                            //document.getElementById("btn_editar").removeAttribute("hidden"); 
                            //$('#btn_editar').attr("visibility", false);
                            //$('#btn_editar').attr("id", "btn_salvar");
                        }
                        function Salvar() {
                            $('#btn_editar').attr("hidden", false);
                            $('#btn_salvar').attr("hidden", true);
                        }

                        function Cancelar() {
                            $('#btn_editar').attr("hidden", false);
                            $('#btn_salvar').attr("hidden", true);
                            $('#btn_cancelar').attr("hidden", true);
                            $('#btn_altSenha').attr("disabled", true);
                            $('#txt_nome').attr("disabled", true);
                            $('#txt_email').attr("disabled", true);
                            SenhaOff();
                        }
                        function SenhaOn() {
                            RetornaSenha();
                            $('#grp_senha').attr("hidden", false);
                            $('#btn_altSenha').attr("onclick", "SenhaOff()");
                        }
                        function SenhaOff() {
                            RetornaSenha();
                            $('#grp_senha').attr("hidden", true);
                            $('#btn_altSenha').attr("onClick", "SenhaOn()");
                        }
                        function RetornaSenha(){
                            document.getElementById('txt_senha1').value = "${Usuario.senha}";
                            document.getElementById('txt_senha2').value = "${Usuario.senha}";
                        }
                        function VerificaSenha() {
                            var senha1 = "";
                            var senha2 = "";
                            senha1 = document.getElementById('txt_senha1').value;
                            senha2 = document.getElementById('txt_senha2').value;
                            if (senha1 === senha2){
                                document.getElementById("form").submit();
                            }
                            else{
                                alert("Senhas diferentes!");
                                RetornaSenha();
                            }
                        }
                    </script>
                    <input type="button" id="btn_editar" value="Editar" onClick="Editar()" class="btn btn-primary">
                    <input type="button" id="btn_cancelar" value="Cancelar" onClick="form.reset();
                            Cancelar();" class="btn btn-primary" hidden="true">
                    <button type="button" id="btn_salvar"  class="btn btn-primary" hidden="true" onclick="VerificaSenha()">
                        Salvar
                    </button>
                </div>
            </form>

        </div>
        <div class="col-md-2">
        </div>
    </div>
</div>


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>