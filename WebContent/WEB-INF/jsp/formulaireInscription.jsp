<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="W-UA-Compatible" content="ie=edge">

<link href="/css/stylesheet.css" rel="stylesheet" type="text/css"/>
<link href="vendor/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="vendor/bootstrap-3.3.7/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
<script src="vendor/bootstrap-3.3.7/js/jquery-3.2.1.js" type="text/javascript"></script>

<jsp:include page="/WEB-INF/fragments/fragmentCDNBootstrap.jspf"></jsp:include>

<meta charset="UTF-8">
<title>Page d'inscription</title>
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
				<h3 class="text-left">ENI-Enchères</h3>
			</div>
		</div>
	</div>
	
	<h3 style="text-align:center">Mon profil</h3><br>
	
	<form action="<%=request.getContextPath()%>/ServletInscription" method="post">
	
	
		<div class="row">
				<div class="col-lg-1 col-lg-offset-2">
					<label for="pseudo">Pseudo</label>
				</div>
			<div class="col-lg-2">
				<input type="text" name="pseudo" value="">
			</div>
		
			<div class="col-lg-1 col-lg-offset-1">
				<label for="nom" class="fontMonProfil">Nom</label>
			</div>
			<div class="col-lg-2">	
				<input type="text" name="nom" value="">
			</div>
		</div><br>
		
		<div class="row">
			<div class="col-lg-1 col-lg-offset-2">
				<label for="prenom">Prénom</label>
			</div>
			<div class="col-lg-2">
				<input type="text" name="prenom" value="">
			</div>
			
			<div class="col-lg-1 col-lg-offset-1">
				<label for="email">Email</label>
			</div>
			<div class="col-lg-2">
				<input type="text" name="email" value="">
			</div>
		</div><br>
		
		<div class="row">
			<div class="col-lg-1 col-lg-offset-2">
				<label for="telephone">Téléphone</label>
			</div>
			<div class="col-lg-2">
				<input type="text" name="telephone" value="">
			</div>
			
			<div class="col-lg-1 col-lg-offset-1">
				<label for="rue">Rue</label>
			</div>
			<div class="col-lg-2">
				<input type="text" name="rue" value="">
			</div>
		</div><br>
		
		<div class="row">
			<div class="col-lg-1 col-lg-offset-2">
				<label for="code_postal">Code postal</label>
			</div>
			<div class="col-lg-2">
				<input type="text" name="code_postal" value="">
			</div>
			
			<div class="col-lg-1 col-lg-offset-1">
				<label for="ville">Ville</label>
			</div>
			<div class="col-lg-2">
				<input type="text" name="ville" value=""><br>
			</div>
		</div><br>
		
		<div class="row">
			<div class="col-lg-1 col-lg-offset-2">
				<label for="mot_de_passe">Mot de passe</label>
			</div>
			<div class="col-lg-2">
				<input type="password" name="mot_de_passe" value=""><br>
			</div>
			
			<div class="col-lg-1 col-lg-offset-1">
				<label for="confirmation">Confirmation</label>
			</div>
			<div class="col-lg-2">
				<input type="password" name="confirmation" value=""><br>
			</div>
		</div><br>
		
		<div class="row">
			<div class="col-lg-3 col-lg-offset-3">
				<input type="submit" value="Créer" style="width : 220px; height : 50px"/>
			</div>
			
			<div class="col-lg-3">
				<a href="<%=request.getContextPath()%>/ServletConnexionAccueil"><input type="button" value="Annuler" style="width : 220px; height : 50px"></a>
			</div>
		</div>
	</form>

</body>
</html>