<!DOCTYPE html>

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
            function TelaInicial() {
                location.href = "index.html";
            }
        </script>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <p id="creditos">Developed by danlkill </p>
                </div>
            </div>
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
                        Novo Usu�rio                    
                    </h4>
                </div>            
            </div>

            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <form role="form" action="efetivacadastro" method="POST">
                        <div class="form-group">

                            <label for="exampleNome">
                                Seu nome
                            </label>
                            <input type="text" class="form-control" id="exampleNome" name="txtNome">
                        </div>
                        <div class="form-group">

                            <label for="exampleInputEmail1">
                                Seu e-mail
                            </label>
                            <input type="email" class="form-control" id="exampleInputEmail1" name="txtEmail">
                        </div>
                        <div class="form-group">

                            <label for="exampleInputPassword1">
                                Sua senha
                            </label>
                            <input type="password" class="form-control" id="exampleInputPassword1" name="txtSenha">
                        </div>

                        <div>
                            <button type="submit" class="btn btn-primary">
                                Cadastrar
                            </button>

                            <input type="button" value="Voltar" onClick="TelaInicial()" class="btn btn-primary">

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