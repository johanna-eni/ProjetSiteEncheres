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

<title>Nouvelle vente</title>
</head>

<body>
	<div class="container-fluid col-md-10 col-md-offset-1">
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
	</div>
	
	
	<form>
		<div class="row col-md-4 col-md-offset-4">
			<div class="container">
					<img src="" alt="">
			</div>
		</div>
		<div class="row col-md-4 col-md-offset-4">
					<div action="<%=request.getContextPath()%>/ServletConnexionUtilisateur" method="post">
						<div class="container">
							<label for="nom-article">Article</label>
							<input class="" type="text" name="nom_article" value=""><br>
						</div>
					</div>
			
		</div>	
				
		<div class="row col-md-4 col-md-offset-4">
			<div class="container">
				<label for="description">Description : </label>
				<textarea class="" name="description" rows="5" cols="33"></textarea><br>
			</div>
		</div>
		
		<div class="row col-md-4 col-md-offset-4">
			<div class="container">
					<label for="nom_categorie">Catégories </label>
				<select class="" name="nom_categorie" id="nom_categorie">
					<option value="bricolage">Bricolage</option>
					<option value="jardinage">Jardinage</option>
					<option value="equipement_maison">Equipement de la maison</option>
					<option value="decoration">Décoration</option>
				</select><br>
			</div>
		</div>
		
		<div class="row col-md-4 col-md-offset-4">
			<div class="container">
				<label for="photo_article">Photo de l'article </label>
				<input class="" type="file" id="photo_article" name="photo_article" accept="image/png, image/jpeg"/>
			</div>
		</div>
		
		<div class="row col-md-4 col-md-offset-4">
			<div class="container">
				<label for="mise_a_prix">Mise à prix : </label>
				<input class="" type="number" step ="10" value="10" min="10" max="10000" name="mise_a_prix"><br>
			</div>
		</div>
		
		<div class="row col-md-4 col-md-offset-4">
			<div class="container">
				<label for="date_debut_enchere">Début de l'enchère </label>
				<input class="" type="date" name="date_debut_enchere"><br>
			</div>
		</div>
		
		<div class="row col-md-4 col-md-offset-4">
			<div class="container">
				<label for="date_fin_enchere">Fin de l'enchère </label>
				<input class="" type="date" name="date_fin_enchere"><br>
			</div>
		</div>
	
		<div class="row col-md-4 col-md-offset-4">
			<div class="container">
				<fieldset>
					<legend>Retrait</legend>
			
					<label for="retrait_rue">Rue</label>
					<input type="text" name="rue" value=" ${ utilisateurInfo.rue}"><br>
			
					<label for="retrait_c_p">Code postal</label>
					<input type="text" name="retrait_c_p" value=" ${ utilisateurInfo.codePostal}"><br>
			
					<label for="retrait_ville">Ville</label>
					<input type="text" name="retrait_ville" value=" ${ utilisateurInfo.ville}"><br>
				</fieldset>
			</div>
		</div>
		<div class="row col-md-4 col-md-offset-4">
			<div class="container">
				<p>
					<a href="<%=request.getContextPath()%>/jsp/accueilConnexionMonProfil.jsp"><input type="button" value="Enregistrer"/></a>
					<a href="<%=request.getContextPath()%>/jsp/accueilConnexionMonProfil.jsp"><input type="button" value="Annuler"/></a>
				</p>
			
			</div>
		</div>
	</form>
	
	
	
	
	
	
	
	
	</div>
	
	




	 <%@ include file="/WEB-INF/fragments/footer.html" %>
</body>
</html>