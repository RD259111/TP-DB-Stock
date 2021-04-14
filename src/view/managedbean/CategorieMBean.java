package view.managedbean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import persistance.dao.CategorieDao;
import persistance.dao.CategorieDaoImpl;
import persistance.entities.Categorie;

@ManagedBean
@SessionScoped
public class CategorieMBean {

	private Categorie categorie = new Categorie();
	private Categorie selectedCategorie = new Categorie();
	CategorieDao categorieDao = new CategorieDaoImpl();
	private List<Categorie> listCategories = new ArrayList<Categorie>();

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Categorie getSelectedCategorie() {
		return selectedCategorie;
	}

	public void setSelectedCategorie(Categorie selectedCategorie) {
		this.selectedCategorie = selectedCategorie;
	}

	public List<Categorie> getListCategories() {
		listCategories = categorieDao.findAll();
		return listCategories;
	}

	public void setListCategories(List<Categorie> listCategories) {
		this.listCategories = listCategories;
	}

	public void addCategorie(ActionEvent e) {
		categorieDao.add(categorie);
		categorie = new Categorie();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajout effectué avec succès"));
	}
	
	public void deleteCategorie(ActionEvent e) {
		if(selectedCategorie == null || selectedCategorie.getIdcateg() == new BigDecimal(0)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention" ,"Aucune catégorie n'a été sélectionné !"));
		} else {
			categorieDao.delete(selectedCategorie);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppresion effectué avec succès"));
		}
	}
	
	public String editCategorie() {
		return "updateCategorie.xhtml";
	}
	
	public void updateCategorie(ActionEvent e) {
		categorieDao.update(selectedCategorie);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modification effectué avec succès"));
	}
}
