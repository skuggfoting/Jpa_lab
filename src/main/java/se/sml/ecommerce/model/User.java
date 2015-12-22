/*
- Hämta en user med ett visst id
- Hämta alla users
- Hämta en user med ett visst username
- Skapa en ny user
- Uppdatera en user
- Ändra status på en user (välj själv passande statusar)

 */

package se.sml.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import se.sml.ecommerce.repository.checkedexception.RepositoryException;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "User.getAll", query = "SELECT e FROM User e"),
		@NamedQuery(name = "User.getByUsername", query = "SELECT e FROM User e WHERE e.username = :username")
})

public final class User
{
	@Id
	@GeneratedValue
	private long userId;

	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String status;

	protected User()
	{
	}

	public User(String username, String firstName, String password, String status)
	{
		// this.userId = userId;
		this.username = username;
		this.firstName = firstName;
		this.password = password;
		this.status = status;
	}

	public long getUserId()
	{
		return userId;
	}

	public String getUsername()
	{
		return username;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getPassword()
	{
		return password;
	}

	public String getStatus()
	{
		return status;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public void setStatus(String status) throws RepositoryException
	{

		if (status == "passive" || status == "active")
		{
			this.status = status;
		}
		else
		{
			throw new RepositoryException("Status must be 'active' or 'passive'");
		}
	}

	@Override
	public String toString()
	{
		return userId + " : " + username + " : " + firstName + " : " + password + " : " + status;
	}

	@Override
	public boolean equals(Object otherObj)
	{
		if (this == otherObj)
		{
			return true;
		}

		if (otherObj instanceof User)
		{
			User otherUser = (User) otherObj;
			return this.username.equals(otherUser.username) && this.firstName.equals(otherUser.firstName);
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		int result = 1;
		result += 37 * username.hashCode();
		result += 37 * firstName.hashCode();
		return result;
	}
}
