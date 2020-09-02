package fr.eni.ProjetSiteEncheres.bo;
import java.sql.Date;
/**
 * classe d�crivant un article
 */
import java.time.LocalDate;
import java.util.List;

public class ArticleVendu {
	
//VARIABLE ET CONSTANTES
	private int noArticle;
	private String nomArticle;
	private String description;
	private java.util.Date dateDebutEncheres;
	private java.util.Date dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private int etatVente;
	private int noUtilisateur;
	
	//lien vers les autres classes
	private Categorie categorie;
	private Retrait retrait;
	private Utilisateur utilisateur;
	
//CONSTRUCTEUR
	public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int miseAPrix, int prixVente) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
	}


public ArticleVendu(String nom_article, String description, String nomCategorie, int mise_a_prix,
			java.util.Date date_debut_enchere, java.util.Date date_fin_enchere, String retrait_rue, String retrait_c_p,
			String retrait_ville, int no_utilisateur) {
		super();
		this.nomArticle = nom_article;
		this.description = description;
		this.miseAPrix = mise_a_prix;
		this.dateDebutEncheres = date_debut_enchere;
		this.dateFinEncheres = date_fin_enchere;
		this.retrait.setRue(retrait_rue);
		this.retrait.setCodePostal(retrait_c_p);
		this.retrait.setVille(retrait_ville);
		this.setNoUtilisateur(no_utilisateur);
		this.categorie.setLibelle(nomCategorie);
		
	}


	public ArticleVendu() {
		super();
}


	//GETTERS ANS SETTERS
	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public java.util.Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(java.util.Date date) {
		this.dateDebutEncheres = date;
	}

	public java.util.Date getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(java.util.Date date) {
		this.dateFinEncheres = date;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public int getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(int etatVente) {
		this.etatVente = etatVente;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


//affichage
	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + "]";
	}


	public int getNoUtilisateur() {
		return noUtilisateur;
	}


	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	
	
}
