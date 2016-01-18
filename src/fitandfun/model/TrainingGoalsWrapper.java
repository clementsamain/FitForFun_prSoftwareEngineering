package fitandfun.model;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Helper class to wrap a list of trainingGoals. This is used for saving the
 * trainingGoals list to XML
 * 
 * @author Viktoria Jechsmayr
 * @version 1.0
 * 
 */
@XmlRootElement(name = "TrainingGoalsWrapper")
public class TrainingGoalsWrapper {

	private List<TrainingGoals> tg;

	@XmlElementWrapper(name = "TrainingGoals")
	@XmlElement(name = "TrainingGoal")
	public List<TrainingGoals> getGoals() {
		return tg;
	}

	public void setGoals(List<TrainingGoals> tg) {
		this.tg = tg;
	}
}