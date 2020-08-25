<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page d'inscription</title>
</head>
<body>
	<h1>Page d'inscription</h1>
	
	<form action="">
		<label for="pseudo">Pseudo :</label>
		<input type="text" name="pseudo" value="">
		
		<label for="nom">Nom :</label>
		<input type="text" name="nom" value="">
		
		<label for="prenom">Prénom :</label>
		<input type="text" name="prenom" value="">
		
		<label for="email">Email :</label>
		<input type="text" name="email" value="">
		
		<label for="telephone">Téléphone :</label>
		<input type="text" name="telephone" value="">
		
		<label for="rue">Rue :</label>
		<input type="text" name="rue" value="">
		
		<label for="code_postal">Code postal :</label>
		<input type="text" name="code_postal" value="">
		
		<label for="ville">Ville :</label>
		<input type="text" name="ville" value="">
		
		<label for="mot_de_passe">Mot de passe :</label>
		<input type="text" name="mot_de_passe" value="">
		
		<label for="confirmation">Confirmation :</label>
		<input type="text" name="confirmation" value="">
		
		<input type="submit" value="valider"/>
		<a href="<%=request.getContextPath()%>"><input type="button" value="annuler"></a>
	</form>

</body>
</html>