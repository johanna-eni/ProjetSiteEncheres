<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	</article>
</body>
</html>