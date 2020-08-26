<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
</head>
<body>

	<h3>ENI-Enchères</h3>
	<a href="<%=request.getContextPath()%>\ServletInscription">Inscription</a>
	<a href="<%=request.getContextPath()%>\ServletConnexionMonProfil">Se connecter</a>
	
	<h3>Liste des enchères</h3>
	
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
	
	<article class="">
		<ul id="listeArticle">
			<li class="">
				<a href="#">
					<img src="" alt=""/>
					<h3>PC Gamer</h3>
					<p>Prix :</p>
					<p>Fin de l'enchère :</p>
					<p>Vendeur :</p>
				</a>
			</li>
		
		</ul>
	
	
	
	
	
</body>
</html>