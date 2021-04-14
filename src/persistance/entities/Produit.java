package persistance.entities;
// Generated 24 mars 2021 � 13:36:36 by Hibernate Tools 4.0.1.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Produit generated by hbm2java
 */
@Entity
@Table(name = "PRODUIT")
public class Produit implements java.io.Serializable {

	private BigDecimal idproduit;
	private Categorie categorie = new Categorie();
	private String designproduit;
	private BigDecimal puproduit;
	private BigDecimal qteproduit;
	private String configproduit;
	private String marqueproduit;
	private String modelproduit;
	private Set<Commande> commandes = new HashSet<Commande>(0);

	public Produit() {
	}

	public Produit(BigDecimal idproduit) {
		this.idproduit = idproduit;
	}

	public Produit(BigDecimal idproduit, Categorie categorie, String designproduit, BigDecimal puproduit,
			BigDecimal qteproduit, String configproduit, String marqueproduit, String modelproduit,
			Set<Commande> commandes) {
		this.idproduit = idproduit;
		this.categorie = categorie;
		this.designproduit = designproduit;
		this.puproduit = puproduit;
		this.qteproduit = qteproduit;
		this.configproduit = configproduit;
		this.marqueproduit = marqueproduit;
		this.modelproduit = modelproduit;
		this.commandes = commandes;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "IDPRODUIT", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdproduit() {
		return this.idproduit;
	}

	public void setIdproduit(BigDecimal idproduit) {
		this.idproduit = idproduit;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDCATEGORIE")
	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Column(name = "DESIGNPRODUIT", length = 254)
	public String getDesignproduit() {
		return this.designproduit;
	}

	public void setDesignproduit(String designproduit) {
		this.designproduit = designproduit;
	}

	@Column(name = "PUPRODUIT", precision = 22, scale = 0)
	public BigDecimal getPuproduit() {
		return this.puproduit;
	}

	public void setPuproduit(BigDecimal puproduit) {
		this.puproduit = puproduit;
	}

	@Column(name = "QTEPRODUIT", precision = 22, scale = 0)
	public BigDecimal getQteproduit() {
		return this.qteproduit;
	}

	public void setQteproduit(BigDecimal qteproduit) {
		this.qteproduit = qteproduit;
	}

	@Column(name = "CONFIGPRODUIT", length = 254)
	public String getConfigproduit() {
		return this.configproduit;
	}

	public void setConfigproduit(String configproduit) {
		this.configproduit = configproduit;
	}

	@Column(name = "MARQUEPRODUIT", length = 254)
	public String getMarqueproduit() {
		return this.marqueproduit;
	}

	public void setMarqueproduit(String marqueproduit) {
		this.marqueproduit = marqueproduit;
	}

	@Column(name = "MODELPRODUIT", length = 254)
	public String getModelproduit() {
		return this.modelproduit;
	}

	public void setModelproduit(String modelproduit) {
		this.modelproduit = modelproduit;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "produit")
	public Set<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

}
