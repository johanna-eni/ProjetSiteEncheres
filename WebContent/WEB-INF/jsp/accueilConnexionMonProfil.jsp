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

<title>Mon profil</title>
</head>

<body class="container-fluid col-lg-10 col-lg-offset-1">
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
		<div class="hautDePage">
			<div class="text-right col-lg-4 col-lg-offset-6" >
				<a href="">Encheres</a>
				<a href="<%=request.getContextPath()%>/ServletNouvelleVente">Vendre un article</a>
				<a href="<%=request.getContextPath()%>/ServletModifierMonProfil">Mon profil</a>
				<a href="<%=request.getContextPath()%>/ServletDeconnexion">Deconnexion</a>
			</div>
		</div>
	</div>
	
	<h3 style="text-align:center">Liste des encheres</h3>
	
		<h3>Filtres :</h3>
	
		<form action="<%=request.getContextPath()%>/ServletFiltreCategorie" method="post">
		<div class="row">
			<div class="col-lg-5">
				<input text="" value="Le nom de l'article contient" style="width:28.3em"><br><br>
					<label>Catégorie :  </label>
					<select name="categorie" style="width : 315px">
					<option value="toutes">Toutes</option>
					<option value="bricolage">Bricolage</option>
					<option value="jardinage">Jardinage</option>
					<option value="equipement maison">Equipement de la maison</option>
					<option value="decoration">Décoration</option>
				</select>
			</div>
			
				<div class="col-lg-5 ">
					<label for="rechercher"></label>
					<input type="submit"  value="Rechercher" style="width : 350px; height : 75px"><br>
				</div>
		</div>
	</form>
	<br>
	<br>
	
	<%@include file="/WEB-INF/jspf/presentationVente.jspf" %>
	
	
	<%@ include file="/WEB-INF/fragments/footer.html" %>
</body>
</html>