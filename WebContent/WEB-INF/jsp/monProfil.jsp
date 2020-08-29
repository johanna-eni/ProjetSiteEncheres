<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mon profil</title>
</head>
<body>

<h3>ENI-Encheres</h3>
	
	<div style="text-align:center">
	<h4>Pseudo : ${ utilisateurInfo.pseudo } </h4>
	<h4>Nom : ${ utilisateurInfo.nom } </h4>
	<h4>Prenom : ${ utilisateurInfo.prenom } </h4>
	<h4>Email : ${ utilisateurInfo.email } </h4>
	<h4>Téléphone : ${ utilisateurInfo.telephone } </h4>
	<h4>Rue : ${ utilisateurInfo.rue } </h4>
	<h4>Code postal : ${ utilisateurInfo.codePostal } </h4>
	<h4>Ville : ${ utilisateurInfo.ville } </h4>
	</div>

<div class="modifier_profil">
		<a href="<%=request.getContextPath()%>/jsp/formulaireModifierProfil.jsp"><input type="button" value="Modifier"/></a>
</div>

<div class="modifier_profil">
		<a href="<%=request.getContextPath()%>/jsp/accueilConnexionMonProfil.jsp"><input type="button" value="Retour"/></a>
</div>

</body>
</html>