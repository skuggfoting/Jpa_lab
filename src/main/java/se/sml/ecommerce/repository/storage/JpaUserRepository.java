package se.sml.ecommerce.repository.storage;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.sml.ecommerce.model.User;
import se.sml.ecommerce.repository.UserRepository;
import se.sml.ecommerce.repository.checkedexception.RepositoryException;


public class JpaUserRepository implements UserRepository
{

//	private HashMap<String, Object> userMap = new HashMap<>();

private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

//	EntityManager manager = factory.createEntityManager();
	
	@Override
	public void create(User user) throws RepositoryException
	{
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();

		manager.persist(user);
		
		manager.getTransaction().commit();
		manager.close();

		manager = factory.createEntityManager();
	}

	@Override
	public User getById(long userId) throws RepositoryException
	{
		EntityManager manager = factory.createEntityManager();
		User user = manager.find(User.class, userId);
		manager.close();
		return user;
	}
	
	@Override
	public List<User> getAll() throws RepositoryException
	{
		EntityManager manager = factory.createEntityManager();
		List<User> users = manager.createNamedQuery("User.getAll", User.class).getResultList();
		manager.close();
		return users;
	}
	
	@Override
	public User getByUsername(String username) throws RepositoryException
	{
		EntityManager manager = factory.createEntityManager();
		User user = manager.createNamedQuery("User.getByUsername", User.class).setParameter("username", username).getSingleResult();
		manager.close();
		return user;
	}

//	@Override
//	public boolean delete(String item) throws RepositoryException
//	{
//		// TODO Auto-generated method stub
//		return false;
//	}


//	@Override
//	public boolean status(String item) throws RepositoryException
//	{
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public boolean update(User user) throws RepositoryException
	{
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		user = manager.merge(user);
		manager.getTransaction().commit();
		manager.close();
		return true;
	}
	
	

}
