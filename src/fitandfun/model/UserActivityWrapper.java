package fitandfun.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Helper class to wrap a list of activities. This is used for saving the
 * activities list to XML
 * 
 * @author Viki
 * @version 0.1
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
