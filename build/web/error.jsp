<!DOCTYPE html>
<jsp:useBean id="erroSTR" type="java.lang.String" scope="request"/>
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

                    <h3 class="text-center">
                        Game with HATEOAS
                    </h3>
                </div>
                
            </div>
            <div class="row">
                <div class="col-md-12">

                    <h4 class="text-center" id="h4error">
                        Erro: ${erroSTR}
                    </h4>
                </div>
                
            </div>
          
      </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>