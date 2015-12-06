package fitandfun.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Helper class to wrap a list of activities. This is used for saving the
 * activities list to XML
 */

@XmlRootElement(name="ActivityWrapper")
public class UserActivityWrapper {

	private List<Activity> activities;

	@XmlElementWrapper(name = "Activities")
	@XmlElement(name = "Activity")
	public List<Activity> getActivities()
	{
		return activities;
	}
	
	public void setUserActivities(List<Activity> activities)
	{
		this.activities = activities;
	}

	
}
