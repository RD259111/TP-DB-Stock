package persistance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistance.entities.Commande;

public class CommandeDaoImpl implements CommandeDao {
	
	private Transaction tx;
	
	@Override
	public void add(Commande value) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.save(value);
			tx.commit();
		}
	}

	@Override
	public void delete(Commande value) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.delete(value);
			tx.commit();
		}
	}

	@Override
	public void update(Commande value) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.update(value);
			tx.commit();
		}
	}

	@Override
	public Commande findById(int id) {
		return null;
	}

	@Override
	public Commande findByObject(Commande commandeId) {

		Commande commande = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			commande = session.get(Commande.class, commandeId.getId());
		}
		return commande;
	}

	@Override
	public List<Commande> findAll() {
		List<Commande> listCommandes = new ArrayList<Commande>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			listCommandes = session.createQuery("from Commande").list();
		}
		return listCommandes;
	}

}
