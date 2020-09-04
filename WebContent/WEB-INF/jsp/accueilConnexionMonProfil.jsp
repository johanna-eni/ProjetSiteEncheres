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
<body>
	<h3>Mon profil</h3>
	
	
	<a href="">Encheres</a>
	<a href="<%=request.getContextPath()%>/ServletNouvelleVente"">Vendre un article</a>
	<a href="<%=request.getContextPath()%>/ServletModifierMonProfil">Mon profil</a>
	<a href="<%=request.getContextPath()%>/ServletDeconnexion">Deconnexion</a>
	
	<h3>Liste des encheres</h3>
	
		<h3>Filtres :</h3>
	
	<form action="<%=request.getContextPath()%>/ServletFiltre" method="post">
		<input type="text" name="pseudo" value="Le nom de l'article contient"><br>
	
	<label for="categorie_selection">Catégories</label>
	
	<select name="categorie" id="categorie_selection">
		<option value="toutes">Toutes</option>
		<option value="bricolage">Bricolage</option>
		<option value="jardinnage">Jardinnage</option>
		<option value="equipement_maison">Equipement de la maison</option>
		<option value="decoration">Décoration</option>
	</select>
	
	<label for="rechercher"></label>
		<input type="submit"  value="Rechercher"><br>
	</form>
	
	<%@include file="/WEB-INF/jspf/presentationVente.jspf" %>
	
</body>
</html>