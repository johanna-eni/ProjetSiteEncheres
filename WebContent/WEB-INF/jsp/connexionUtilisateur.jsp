<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="W-UA-Compatible" content="ie=edge">

<link href="css/stylesheet.css" rel="stylesheet" type="text/css"/>
<link href="vendor/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="vendor/bootstrap-3.3.7/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
<script src="vendor/bootstrap-3.3.7/js/jquery-3.2.1.js" type="text/javascript"></script>

<jsp:include page="/WEB-INF/fragments/fragmentCDNBootstrap.jspf"></jsp:include>
<title>Connexion utilisateur</title>
</head>

<body class="container-fluid col-lg-10 col-sm-offset-1">
	<div class="">
		<span class="col-xs-12 visible-xs alert alert-danger">extra small</span>
		<span class="col-sm-12 visible-sm alert alert-info">small</span>
		<span class="col-md-12 visible-md alert alert-success">medium</span>
		<span class="col-lg-12 visible-lg alert alert-warning">large</span>
	</div>
	
	<div class="row">
		<div class="hautDePage">
			<div class="col-lg-2">
				<h3 class="text-left">ENI-Enchères</h3><br><br>
			</div>
		</div>
	</div>
	
	<form action="<%=request.getContextPath()%>/ServletConnexionUtilisateur" method="post">
	<div class="row">
		<div  class="col-lg-2 col-lg-offset-4">
			<label for="pseudo">Pseudo :</label><br><br>
			<label for="mot_de_passe">Mot de passe :</label><br><br>
			<label for="connexion"></label>
			<input type="submit"  value="Connexion" style="width : 100px; height : 50px"><br>
		</div>
		<div  class="col-lg-2">
			<input type="text" name="pseudo" value=""><br><br>
			<input type="password" name="mot_de_passe" value=""><br><br>
 			<input type="checkbox" id="scales" name="scales" checked>
 			<label for="scales">Se souvenir de moi</label><br>
			<a href="<%=request.getContextPath()%>\ServletConnexionUtilisateur">Mot de passe oublié</a><br><br><br><br>
		</div>
	</div>

	<div class="col-lg-4 col-lg-offset-4">
		<a href="<%=request.getContextPath()%>/jsp/formulaireInscription.jsp"><input type="button" value="Créer un compte" style="width : 370px; height : 75px"></a>
	</div>
	
	</form>
</body>
</html>