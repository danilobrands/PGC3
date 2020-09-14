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

            var pontosTotal = 10;
            var pontosRestantes = 7;
            var forca = 1, agilidade = 1, resistencia = 1;

            function AddForca() {
                if (pontosRestantes > 0) {
                    forca++;
                    pontosRestantes--;
                }
                $('#rangeForca').attr("value", forca);
                $('#txtForca').attr("value", forca);
                $('#txtPontosRest').attr("value", pontosRestantes);
            }

            function SubForca() {
                if (forca > 1) {
                    forca--;
                    pontosRestantes++;
                }
                $('#rangeForca').attr("value", forca);
                $('#txtForca').attr("value", forca);
                $('#txtPontosRest').attr("value", pontosRestantes);
            }
            
            function AddAgilidade() {
                if (pontosRestantes > 0) {
                    agilidade++;
                    pontosRestantes--;
                }
                $('#rangeAgilidade').attr("value", agilidade);
                $('#txtAgilidade').attr("value", agilidade);
                $('#txtPontosRest').attr("value", pontosRestantes);
            }

            function SubAgilidade() {
                if (agilidade > 1) {
                    agilidade--;
                    pontosRestantes++;
                }
                $('#rangeAgilidade').attr("value", agilidade);
                $('#txtAgilidade').attr("value", agilidade);
                $('#txtPontosRest').attr("value", pontosRestantes);
            }
            
            function AddResistencia() {
                if (pontosRestantes > 0) {
                    resistencia++;
                    pontosRestantes--;
                }
                $('#rangeResistencia').attr("value", resistencia);
                $('#txtResistencia').attr("value", resistencia);
                $('#txtPontosRest').attr("value", pontosRestantes);
            }

            function SubResistencia() {
                if (resistencia > 1) {
                    resistencia--;
                    pontosRestantes++;
                }
                $('#rangeResistencia').attr("value", resistencia);
                $('#txtResistencia').attr("value", resistencia);
                $('#txtPontosRest').attr("value", pontosRestantes);
            }
            
            function Destravar(){
                $('#txtAgilidade').attr("disabled", false);
                $('#txtForca').attr("disabled", false);
                $('#txtResistencia').attr("disabled", false);
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

            <div class="row" >
                <div class="col-md-12">
                    <h4 class="text-center">
                        Crie seu personagem ${Usuario.nome}
                    </h4>
                </div>            
            </div>

            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <form role="form" action="uploadskin" method="POST" enctype="multipart/form-data">

                        <div class="form-group">
                            <label for="personagemName">
                                Nome
                            </label>
                            <div class="row">
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="personagemName" name="txtNome">
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-3">
                                Total de Pontos = 
                            </div>
                            <div class="col-md-1">
                                <input class="form-control" type="text" value="10" style="width:50px" disabled="true" >
                            </div>
                            <div class="col-md-3">
                                Pontos Sobrando = 
                            </div>
                            <div class="col-md-1">
                                <input class="form-control" type="text" value="7" style="width:50px" disabled="true" id="txtPontosRest"> 
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="personagemForca">
                                Força
                            </label>
                            <div class="row">
                                <div class="col-md-1"><input type="button" value="-" onClick="SubForca()" class="btn btn-primary" ></div>
                                <div class="col-md-2"><input type="range" min="1" max="8" step="1" value="1" name="rangeForca" id="rangeForca" disabled="true"></div>
                                <div class="col-md-1"><input type="button" value="+" onClick="AddForca()" class="btn btn-primary"></div>
                                <div class="col-md-4"><input type="text" class="form-control" name="txtForca" id="txtForca" value="1" disabled="true"></div>
                            </div>
                        </div>



                        <div class="form-group">
                            <label for="personagemAgilidade ">
                                Agilidade
                            </label>
                            <div class="row">
                                <div class="col-md-1"><input type="button" value="-" onClick="SubAgilidade()" class="btn btn-primary"></div>
                                <div class="col-md-2"><input type="range" min="1" max="8" step="1" value="1" name="rangeAgilidade" id="rangeAgilidade" disabled="true"></div>
                                <div class="col-md-1"><input type="button" value="+" onClick="AddAgilidade()" class="btn btn-primary"></div>
                                <div class="col-md-4"><input type="text" class="form-control" value="1" name="txtAgilidade" id="txtAgilidade" disabled="true"></div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="personagemResistência">
                                Resistência
                            </label>

                            <div class="row">
                                <div class="col-md-1"><input type="button" value="-" onClick="SubResistencia()" class="btn btn-primary"></div>
                                <div class="col-md-2"><input type="range" min="1" max="8" step="1" value="1" name="rangeResistencia" id="rangeResistencia" disabled="true"></div>
                                <div class="col-md-1"><input type="button" value="+" onClick="AddResistencia()" class="btn btn-primary"></div>
                                <div class="col-md-4"><input type="text" class="form-control" value="1" name="txtResistencia" id="txtResistencia" disabled="true"></div>
                            </div>

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

                        <button type="submit" class="btn btn-primary" onclick="Destravar()">
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