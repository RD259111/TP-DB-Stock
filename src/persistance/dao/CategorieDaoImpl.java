package persistance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistance.entities.Categorie;

public class CategorieDaoImpl implements CategorieDao {

	private Transaction tx;
	
	@Override
	public void add(Categorie value) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.save(value);
			tx.commit();
		}
	}

	@Override
	public void delete(Categorie value) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.delete(value);
			tx.commit();
		}
	}

	@Override
	public void update(Categorie value) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.update(value);
			tx.commit();
		}
	}

	@Override
	public Categorie findById(int id) {
		Categorie categorie = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			categorie = session.get(Categorie.class, id);
		}
		return categorie;
	}

	@Override
	public List<Categorie> findAll() {
		List<Categorie> listCategories = new ArrayList<Categorie>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			listCategories = session.createQuery("from Categorie").list();
		}
		return listCategories;
	}
}
