package fitandfun.model;

/**
 * GoalType for TrainingGoals
 * 
 * @author Viki
 * @version 0.1
 */
public enum GoalType {
	WEIGHT("Gewicht"), 
	STEPS("Schritte"), 
	RUNDIST("Laufen-Distanz"), 
	WALKDIST("Spazierengehen-Distanz"), 
	BIKEDIST("Radfahren-Distanz"), 
	SWIMDIST("Schwimmen-Distanz"), 
	HIKEDIST("Bergwandern-Distanz"), 
	KCAL("Kcal verbrauchte kcal");
	
	private final String text;
	
	private GoalType()
	{
		this("");
	}
	
	private GoalType(final String text)
	{
		this.text = text;
	}
	
	@Override
	public String toString()
	{
		return text;
	}
}
