package view.managedbean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import persistance.dao.ClientDao;
import persistance.dao.ClientDaoImpl;
import persistance.entities.Client;

@ManagedBean
@SessionScoped
public class ClientMBean {

	private Client client = new Client();
	private Client selectedClient = new Client();
	ClientDao clientDao = new ClientDaoImpl();
	private List<Client> listClients = new ArrayList<Client>();

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}

	public List<Client> getListClients() {
		listClients = clientDao.findAll();
		return listClients;
	}

	public void setListClients(List<Client> listClients) {
		this.listClients = listClients;
	}
	
	public void addClient(ActionEvent e) {
		clientDao.add(client);
		client = new Client();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajout effectué avec succès"));
	}
	
	public void deleteClient(ActionEvent e) {
		if(selectedClient == null || selectedClient.getIdclient() == new BigDecimal(0)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention" ,"Aucun client n'a été sélectionné !"));
		} else {
			clientDao.delete(selectedClient);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Suppresion effectué avec succès"));
		}
	}
	
	public String editClient() {
		return "updateClient.xhtml";
	}
	
	public void updateClient(ActionEvent e) {
		clientDao.update(selectedClient);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modification effectué avec succès"));
	}

}
