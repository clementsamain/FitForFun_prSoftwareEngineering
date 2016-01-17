package fitandfun.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Helper class to wrap a list of goalTypes. This is used for saving the
 * goalTypes list to XML
 * 
 * @author Viki
 * @version 0.1
 */
@XmlRootElement(name = "GoalTypeWrapper")
public class GoalTypeWrapper {

	private List<GoalType> goalTypes;

	@XmlElementWrapper(name = "GoalTypes")
	@XmlElement(name = "GoalType")
	public List<GoalType> getGoalTypes() {
		return goalTypes;
	}

	public void setGoalTypes(List<GoalType> goalTypes) {
		this.goalTypes = goalTypes;
	}
}