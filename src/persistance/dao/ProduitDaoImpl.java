package persistance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistance.entities.Produit;

public class ProduitDaoImpl implements ProduitDao {

	private Transaction tx;
	
	@Override
	public void add(Produit value) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.save(value);
			tx.commit();
		}
	}

	@Override
	public void delete(Produit value) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.delete(value);
			tx.commit();
		}
	}

	@Override
	public void update(Produit value) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.update(value);
			tx.commit();
		}
	}

	@Override
	public Produit findById(int id) {
		Produit produit = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			produit = session.get(Produit.class, id);
		}
		return produit;
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> listProduits = new ArrayList<Produit>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			listProduits = session.createQuery("from Produit").list();
		}
		return listProduits;
	}

}
