<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<title>Accueil</title>
</head>

<body class="container-fluid col-sm-10 col-sm-offset-1">
	<div class="">
		<span class="col-xs-12 visible-xs alert alert-danger">extra small</span>
		<span class="col-sm-12 visible-sm alert alert-info">small</span>
		<span class="col-md-12 visible-md alert alert-success">medium</span>
		<span class="col-lg-12 visible-lg alert alert-warning">large</span>
	</div>
	
	<div class="row align-items-center;">
		<div class="hautDePage">
			<div class="col-lg-2">
				<h3 class="text-left">ENI-Enchères</h3>
			</div>
		</div>
		<div class="hautDePage">
			<div class="text-right col-lg-2 col-lg-offset-8" >
				<a href="<%=request.getContextPath()%>\ServletInscription">Inscription</a>
				<a href="<%=request.getContextPath()%>\ServletConnexionUtilisateur">Se connecter</a>
			</div>
		</div>
	</div>
	
	<h3 style="text-align:center">Liste des enchères</h3>
	<h3>Filtres :</h3>
	
	<div class="row">
		<div class="col-lg-5">
			<form action="<%=request.getContextPath()%>/ServletFiltre" method="post">
			<input type="text" name="pseudo" value="Le nom de l'article contient">
			<br>
			<br>
			<label for="categorie_selection">Catégories</label>
	
			<select name="categorie" id="categorie_selection">
				<option value="toutes">Toutes</option>
				<option value="bricolage">Bricolage</option>
				<option value="jardinnage">Jardinnage</option>
				<option value="equipement_maison">Equipement de la maison</option>
				<option value="decoration">Décoration</option>
			</select>
		</div>
		
		<div class="col-lg-5">
			<label for="rechercher"></label>
			<input type="submit"  value="Rechercher" style="width : 350px"><br>
		</div>
	</div>
	
	
	</form>
	<br>
	<br>
	
	<%@include file="/WEB-INF/jspf/presentationVente.jspf" %>
	
	
	
	
	 <%@ include file="/WEB-INF/fragments/footer.html" %>
</body>
</html>