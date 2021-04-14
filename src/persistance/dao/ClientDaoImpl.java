package persistance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistance.entities.Client;

public class ClientDaoImpl implements ClientDao {

	private Transaction tx;
	
	@Override
	public void add(Client value) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.save(value);
			tx.commit();
		}
	}

	@Override
	public void delete(Client value) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.delete(value);
			tx.commit();
		}
	}

	@Override
	public void update(Client value) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.update(value);
			tx.commit();
		}
	}

	@Override
	public Client findById(int id) {
		Client client = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			client = session.get(Client.class, id);
		}
		return client;
	}

	@Override
	public List<Client> findAll() {
		List<Client> listClients = new ArrayList<Client>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			listClients = session.createQuery("from Client").list();
		}
		return listClients;
	}

}
