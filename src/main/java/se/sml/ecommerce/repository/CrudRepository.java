package se.sml.ecommerce.repository;

import java.util.List;

import se.sml.ecommerce.repository.checkedexception.RepositoryException;

public interface CrudRepository<T>
{
	void create(T item) throws RepositoryException;

	T getById(long item) throws RepositoryException;

	List<T> getAll() throws RepositoryException;
	
	T getByUsername(String username) throws RepositoryException;

//	boolean delete(String item) throws RepositoryException;

//	boolean status(String item) throws RepositoryException;
	
	boolean update(T item) throws RepositoryException;
}
