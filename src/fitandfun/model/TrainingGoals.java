package fitandfun.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

/**
 * 
 * @author Viki
 * @version 0.1
 */
public class TrainingGoals {

	private final GoalType type;
	private final FloatProperty goal;
	private final FloatProperty current;
	private final BooleanProperty completed;
	
	/**
	 * Constructor
	 * @param type
	 * @param goal
	 */
	public TrainingGoals(GoalType type, float goal)
	{
		this.type = type;
		this.goal = new SimpleFloatProperty(goal);
		this.current = new SimpleFloatProperty(0);
		this.completed = new BooleanProperty();
	}
	
	/**
	 * Get-Methods
	 */
	public GoalType getType()
	{
		return this.type;
	}
	
	public float getGoal()
	{
		return this.goal.get();
	}
	
	public float getCurrent()
	{
		return this.current.get();
	}
	
	public boolean getCompleted()
	{
		return this.completed.get();
	}
	
	/**
	 * Set-Methods
	 */
	
	public void setCurrent(float current)
	{
		this.current.set(current);
		updateCompleted();
	}
	
	/**
	 * Check if Goal is completed
	 */
	private void updateCompleted()
	{
		if(current.get()>=goal.get())
		{
			completed.set(true);
		}
	}	
}
