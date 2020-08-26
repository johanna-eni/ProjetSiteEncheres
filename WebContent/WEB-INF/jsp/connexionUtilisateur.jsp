<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion utilisateur</title>
</head>
<body>
	<h1>Page de connexion</h1>
	
	<form action="<%=request.getContextPath()%>/ServletConnexionMonProfil" method="post">
		<label for="pseudo">Pseudo :</label>
		<input type="text" name="pseudo" value=""><br>
		
		<label for="mot_de_passe">Not de passe :</label>
		<input type="text" name="mot_de_passe" value=""><br>
		
		<label for="connexion"></label>
		<input type="submit"  value="Connexion"><br>
		
		<!--<label for="se_souvenir_de_moi">Se souvenir de moi</label>
		<input type="checkbox" name="se_souvenir_de_moi" id="se_souvenir_de_moi"></div><br>
		
		<a href="envoieEmail">Mot de passe oublié</a><br>
		-->
		
		<a href="<%=request.getContextPath()%>/jsp/formulaireInscription.jsp"><input type="button" value="creer_un_compte"></a>
		
	</form>
	
	
</body>
</html>