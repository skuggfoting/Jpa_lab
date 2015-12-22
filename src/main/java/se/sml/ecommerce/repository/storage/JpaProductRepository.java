package se.sml.ecommerce.repository.storage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import se.slam.interfaces.ProductRepository;
import se.slam.parts.Product;

public class JpaProductRepository implements ProductRepository
{

	@Override
	public void updateProduct()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void createProduct(Product p, String fileName)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Product readProduct(String filename)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
