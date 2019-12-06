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
                        Envie sua Skin ${Usuario.nome}
                    </h4></div>            
            </div>

            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <form role="form" action="uploadskin" method="POST" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="txtNome">
                                Nome da skin
                            </label>
                            <input type="text" class="form-control" id="skinName" name="txtNome">
                        </div>

                        <div class="form-group">

                            <label for="fileIMG">
                                Selecionar Imagem
                            </label>
                            <input type="file" class="form-control-file" id="fileIMG" name="fileIMG" />
                            <p class="help-block">
                                Utilize o modelo padrão
                            </p>
                        </div>

                        <button type="submit" class="btn btn-primary">
                            Enviar skin
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