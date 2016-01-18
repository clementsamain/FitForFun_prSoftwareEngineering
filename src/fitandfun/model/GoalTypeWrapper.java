package fitandfun.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Helper class to wrap a list of GoalTypes. This is used for saving the
 * GoalTypes list to XML
 * 
 * @author Viktoria Jechsmayr
 * @version 1.0
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