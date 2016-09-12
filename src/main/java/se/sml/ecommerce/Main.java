package se.sml.ecommerce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.Order;

import se.sml.ecommerce.model.Product;
import se.sml.ecommerce.model.User;
import se.sml.ecommerce.repository.OrderRepository;
import se.sml.ecommerce.repository.ProductRepository;
import se.sml.ecommerce.repository.UserRepository;
import se.sml.ecommerce.repository.checkedexception.RepositoryException;
import se.sml.ecommerce.repository.storage.JpaOrderRepository;
import se.sml.ecommerce.repository.storage.JpaProductRepository;
import se.sml.ecommerce.repository.storage.JpaUserRepository;

public final class Main
{

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args) throws RepositoryException
	{

		// Initiate new user
		User mattias = new User("Mano", "Mattias", "1234", "active");
		User shafi = new User("Shab", "Shafi Abdullah", "5678", "active");
		User lina = new User("Lica", "Lina Carlén", "1357", "passive");
		// User lina2 = new User("991212", "Lina Carlén", "lamborgini");

		// Initiate new product
		Product product1 = new Product("milk", 3.30, "981374");
		Product product2 = new Product("hat", 3.87, "098312094");
		Product product3 = new Product("computer", 20.000, "9873414");

		// Initiate order
		Order order1 = new Order("20151028", mattias);
		order1.addOrderItems(product1, 5);
		order1.addOrderItems(product2);
		order1.addOrderItems(product3, 2);

		// Initiate E-Commerce Service
		UserRepository userRepository = new JpaUserRepository();
		// ProductRepository prodRepository = new JpaProductRepository();
		// OrderRepository orderRepository = new JpaOrderRepository();
		ECommerceService eService = new ECommerceService(userRepository); // ,
																			// prodRepository,
																			// orderRepository);

		// Create user
		eService.createUser(mattias);
		eService.createUser(shafi);
		eService.createUser(lina);

		// Find user by id
		System.out.println(eService.findUserById(1L).toString());
		// System.out.println(eService.readUser(shafi));
		// System.out.println(eService.readUser(lina));

		// Get all users
		List<User> users = eService.getAllUsers();
		for (User user : users)
		{
			System.out.println(user.toString());
		}

		// Get user by username
		System.out.println(eService.getByUsername("Shab").toString());

		// update user
		mattias.setFirstName("MattiasN");
		System.out.println(eService.updateUser(mattias));
		System.out.println(mattias.toString());

		// update user
		mattias.setStatus("passive");
		System.out.println(eService.setStatus(mattias));
		System.out.println(mattias.toString());
		

	}

}
