package fitandfun.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Helper class to wrap a list of activities. This is used for saving the
 * activities list to XML
 * 
 * @author Viktoria Jechsmayr
 * @version 1.0
 */
@XmlRootElement(name = "ActivityWrapper")
public class ActivityWrapper {

	private List<ActivityType> activities;

	@XmlElementWrapper(name = "Activities")
	@XmlElement(name = "Activity")
	public List<ActivityType> getActivities() {
		return activities;
	}

	public void setActivities(List<ActivityType> activities) {
		this.activities = activities;
	}
}