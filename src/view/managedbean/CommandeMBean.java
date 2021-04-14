package view.managedbean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import persistance.dao.CommandeDao;
import persistance.dao.CommandeDaoImpl;
import persistance.entities.Commande;

@ManagedBean
@SessionScoped
public class CommandeMBean {

	private Commande commande = new Commande();
	private Commande selectedCommande = new Commande();
	CommandeDao commandeDao = new CommandeDaoImpl();
	private List<Commande> listCommandes = new ArrayList<Commande>();

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Commande getSelectedCommande() {
		return selectedCommande;
	}

	public void setSelectedCommande(Commande selectedCommande) {
		this.selectedCommande = selectedCommande;
	}

	public List<Commande> getListCommandes() {
		listCommandes = commandeDao.findAll();
		return listCommandes;
	}

	public void setListCommandes(List<Commande> listCommandes) {
		this.listCommandes = listCommandes;
	}

	public void addCommande(ActionEvent e) {
		commandeDao.add(commande);
		commande = new Commande();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajout effectué avec succès"));
	}
	
	public void deleteCommande(ActionEvent e) {
		if(selectedCommande == null || (selectedCommande.getId().getIdclient() == new BigDecimal(0) && selectedCommande.getId().getIdproduit() == new BigDecimal(0))) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention" ,"Aucune commande n'a été sélectionné !"));
		} else {
			commandeDao.delete(selectedCommande);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppresion effectué avec succès"));
		}
	}
	
	public String editCommande() {
		return "updateCommande.xhtml";
	}
	
	public void updateCommande(ActionEvent e) {
		commandeDao.update(selectedCommande);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modification effectué avec succès"));
	}
}
