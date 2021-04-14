package view.managedbean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import persistance.dao.ProduitDao;
import persistance.dao.ProduitDaoImpl;
import persistance.entities.Produit;

@ManagedBean
@SessionScoped
public class ProduitMBean {

	private Produit produit = new Produit();
	private Produit selectedProduit = new Produit();
	ProduitDao produitDao = new ProduitDaoImpl();
	private List<Produit> listProduits = new ArrayList<Produit>();

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Produit getSelectedProduit() {
		return selectedProduit;
	}

	public void setSelectedProduit(Produit selectedProduit) {
		this.selectedProduit = selectedProduit;
	}

	public List<Produit> getListProduits() {
		listProduits = produitDao.findAll();
		return listProduits;
	}

	public void setListProduits(List<Produit> listProduits) {
		this.listProduits = listProduits;
	}

	public void addProduit(ActionEvent e) {
		produitDao.add(produit);
		produit = new Produit();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajout effectué avec succès"));
	}
	
	public void deleteProduit(ActionEvent e) {
		if(selectedProduit == null || selectedProduit.getIdproduit() == new BigDecimal(0)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention" ,"Aucun produit n'a été sélectionné !"));
		} else {
			produitDao.delete(selectedProduit);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppresion effectué avec succès"));
		}
	}
	
	public String editProduit() {
		return "updateProduit.xhtml";
	}
	
	public void updateProduit(ActionEvent e) {
		produitDao.update(selectedProduit);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modification effectué avec succès"));
	}
}
