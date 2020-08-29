package fr.eni.ProjetSiteEncheres.bo;

import java.util.List;

/**
 * 
 * @author jrigollo2020
 *classe utilisateur
 */
public class Utilisateur {

/*
 * variables et constantes
 */
	private int noUtilisateur;
	private String premierPseudo;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private String confirmation;
	private int credit;
	private int administrateur;
	private String nvxMotDePasse;
	
	private List<ArticleVendu> articleVendu;
	private List<Enchere> enchere;
/*
 * Constructeur
 */
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, int administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}

/*
 * Constructeur d'insertion en base de donnée 
 * no utilisateur + crédit + administrateur auto généré par bdd
*/
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
		String rue, String codePostal, String ville, String motDePasse) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
	}

/*
* Constructeur validation couple pseudo mot de passe
*/
	public Utilisateur(String pseudo, String motDePasse) {
		super();	
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
}

/*
* Constructeur validation inscription
*/
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, String confirmation) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.confirmation = confirmation;
	}

/*
* Constructeur
*/
	public Utilisateur() {
		
	}

/*
* Constructeur général
*/
public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, int administrateur) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}

//Constructeur modif utilisateur
public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String code_postal, String ville, String mot_de_passe, String confirmation, String nvx_mot_de_passe, String premierPseudo) {
	super();
	this.pseudo = pseudo;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.telephone = telephone;
	this.rue = rue;
	this.codePostal = code_postal;
	this.ville = ville;
	this.motDePasse = mot_de_passe;
	this.confirmation = confirmation;
	this.nvxMotDePasse = nvx_mot_de_passe;
	this.setPremierPseudo(premierPseudo);
	}

	//GETTERS AND SETTERS
	public int getNoUtilisateur() {
		return noUtilisateur;
	}


	public int setNoUtilisateur(int i) {
		return noUtilisateur = i;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public int getCredit() {
		return credit;
	}


	public void setCredit(int credit) {
		this.credit = credit;
	}


	public int getAdministrateur() {
		return administrateur;
	}


	public void setAdministrateur(int administrateur) {
		this.administrateur = administrateur;
	}
	
	public List<ArticleVendu> getArticleVendu() {
		return articleVendu;
	}


	public void setArticleVendu(List<ArticleVendu> articleVendu) {
		this.articleVendu = articleVendu;
	}


	public List<Enchere> getEnchere() {
		return enchere;
	}


	public void setEnchere(List<Enchere> enchere) {
		this.enchere = enchere;
	}
	

	public String getConfirmation() {
		return confirmation;
	}


	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
	
	public String getNvxMotDePasse() {
		return nvxMotDePasse;
	}

	public void setNvxMotDePasse(String nvxMotDePasse) {
		this.nvxMotDePasse = nvxMotDePasse;
	}
	
	public String getPremierPseudo() {
		return premierPseudo;
	}

	public void setPremierPseudo(String premierPseudo) {
		this.premierPseudo = premierPseudo;
	}

	
//affichage
	@Override
	public String toString() {
		return "Utilisateur [noUtilisateur=" + noUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal="
				+ codePostal + ", ville=" + ville + ", motDePasse=" + motDePasse + ", credit=" + credit
				+ ", administrateur=" + administrateur + "]";
	}



}
