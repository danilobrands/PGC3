<!DOCTYPE html>
<jsp:useBean id="Usuario" type="model.Usuario" scope="session"/>

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
                        Game with HateOS
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

                        <button type="submit" class="btn btn-primary">
                            Criar personagem
                        </button>
                        
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