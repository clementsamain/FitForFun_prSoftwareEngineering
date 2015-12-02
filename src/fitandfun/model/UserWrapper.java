package fitandfun.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

/**
 * Helper class to wrap a list of users. This is used for saving the
 * user list to XML
 */

@XmlRootElement(name="Users")
public class UserWrapper {

	public List<User> users;
	
	@XmlElement(name="user")
	public List<User> getUsers()
	{
		return users;
	}
	
	public void setUsers(List<User> users)
	{
		this.users = users;
	}

	
}
