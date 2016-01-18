package fitandfun.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Helper class to wrap a list of users. This is used for saving the user list
 * to XML
 * 
 * @author Viktoria Jechsmayr
 * @version 1.0
 */
@XmlRootElement(name = "UserWrapper")
public class UserWrapper {

	private List<User> users;

	@XmlElementWrapper(name = "Users")
	@XmlElement(name = "User")
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
