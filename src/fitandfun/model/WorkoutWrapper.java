package fitandfun.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Helper class to wrap a list of workouts. This is used for saving the
 * workouts list to XML
 *
 * @author Sabrina, Marion, Kerstin
 * @version 0.1
 */

@XmlRootElement(name = "WorkoutWrapper")
public class WorkoutWrapper {

	private List<WorkoutType> workouts;

	@XmlElementWrapper(name = "Workouts")
	@XmlElement(name = "Workout")
	public List<WorkoutType> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<WorkoutType> workouts) {
		this.workouts = workouts;
	}
}