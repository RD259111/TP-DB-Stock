package persistance.dao;

import persistance.entities.Commande;

public interface CommandeDao extends GlobalDao<Commande> {
	Commande findByObject(Commande commandeId);
}
