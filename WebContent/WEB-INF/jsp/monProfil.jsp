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
	
	${ utilisateurInfo }
	<h3>Numero utilisateur :</h3${utilisateurInfo.getNoUtilisateur();}>
	<h3>Numero utilisateur :</h3${pageScope [NoUtilisateur]}>
	

<div class="modifier_profil">
		<a href=""><input type="button" value="Modifier"/></a>
</div>

</body>
</html>