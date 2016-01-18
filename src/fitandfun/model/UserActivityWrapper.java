package fitandfun.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Helper class to wrap a list of userActivities. This is used for saving the
 * userActivities list to XML
 * 
 * @author Viktoria Jechsmayr
 * @version 1.0
 */
@XmlRootElement(name = "ActivityWrapper")
public class UserActivityWrapper {

	private List<Activity> activities;

	@XmlElementWrapper(name = "UserActivities")
	@XmlElement(name = "UserActivity")
	public List<Activity> getUserActivities() {
		return activities;
	}

	public void setUserActivities(List<Activity> activities) {
		this.activities = activities;
	}
}
