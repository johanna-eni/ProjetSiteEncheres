<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modifier Profil</title>
</head>
<body>

	<h3>ENI-Enchères</h3>
	
	<h3 style="text-align:center">Mon Profil</h3>
	
	<div style="text-align:center">
	<form action="<%=request.getContextPath()%>/ServletModifierMonProfil" method="post">
	
		<label for="pseudo">Pseudo :</label>
		<input type="text" name="pseudo" value=""><br>
		
		<label for="nom">Nom :</label>
		<input type="text" name="nom" value=""><br>
		
		<label for="prenom">Prénom :</label>
		<input type="text" name="prenom" value=""><br>
		
		<label for="email">Email :</label>
		<input type="text" name="email" value=""><br>
		
		<label for="telephone">Téléphone :</label>
		<input type="text" name="telephone" value=""><br>
		
		<label for="rue">Rue :</label>
		<input type="text" name="rue" value=""><br>
		
		<label for="code_postal">Code postal :</label>
		<input type="text" name="code_postal" value=""><br>
		
		<label for="ville">Ville :</label>
		<input type="text" name="ville" value=""><br>
		
		<label for="mot_de_passe">Mot de passe actuel:</label>
		<input type="password" name="mot_de_passe" value=""><br>
		
		<label for="confirmation">Confirmation :</label>
		<input type="password" name="confirmation" value=""><br>
		
		<label for="nvx_mot_de_passe">Nouveau mot de passe :</label>
		<input type="password" name="nvx_mot_de_passe" value=""><br>
		
		<input type="submit" value="Valider"/>
		<a href="<%=request.getContextPath()%>/jsp/monProfil.jsp"><input type="button" value="Annuler"></a>
	</form>
	</div>
</body>
</html>