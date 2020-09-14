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

        <script type="text/javascript">
            function MinhaConta() {
                location.href = "myaccount.jsp";
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
                        Crie seu Personagem ${Usuario.nome}
                    </h4></div>            
            </div>

            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <form role="form" action="efetivapersonagem" method="POST">

                        <div class="form-group">
                            <label for="personagemName">
                                Nick do personagem
                            </label>
                            <input type="text" class="form-control" id="personagemName" name="txtNick">
                        </div>
                        
                          <div class="form-group">
                            <label for="personagemName">
                                Range Test
                            </label>
                            <input type="range" min="5" max="10" step="0.01">
                        </div>
                        
                        <input type="range" min="5" max="10" step="0.01">

                        <div class="form-group">
                            <label for="personagemForca">
                                Força
                            </label>
                            <input type="text" class="form-control" id="personagemForca" name="txtForca">
                        </div>

                        <div class="form-group">
                            <label for="personagemAgilidade ">
                                Agilidade
                            </label>
                            <input type="text" class="form-control" id="personagemAgilidade" name="txtAgilidade">
                        </div>

                        <div class="form-group">
                            <label for="personagemSkin ">
                                Skin
                            </label>
                            <input type="text" class="form-control" id="personagemSkin" name="txtSkin">

                            <select name="Skin" class="form-control" id="personagemSkin" name="txtSkin">
                                <option value="valor1">Valor 1</option> 
                                <option value="valor2" selected>Valor 2</option>
                                <option value="valor3">Valor 3</option>
                            </select>
                        </div>

                        <button type="submit" class="btn btn-primary">
                            Criar personagem
                        </button>

                        <input type="button" value="Voltar" onClick="MinhaConta()" class="btn btn-primary">

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