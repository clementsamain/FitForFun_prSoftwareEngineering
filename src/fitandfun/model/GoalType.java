package fitandfun.model;

import javax.xml.bind.annotation.XmlElement;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * GoalType to load and save GoalTypes used by all Users
 * @author Viktoria Jechsmayr
 * @version 1.0
 */
public class GoalType {
	
	private final StringProperty actName;
	private final ObjectProperty<ActivityType> actType;
	private final ObjectProperty<ActivityTypeParameter> actTypeParam;

	public GoalType() {
		this(null);
	}

	public GoalType(String name) {
		this.actName = new SimpleStringProperty(name);
		this.actType = new SimpleObjectProperty<>();
		this.actTypeParam = new SimpleObjectProperty<>();
	}

	//actName
	public StringProperty nameProperty() {
		return this.actName;
	}

	@XmlElement(name = "GoalType")
	public String getName() {
		return this.actName.get();
	}

	public void setName(String name) {
		this.actName.set(name);
	}
	
	// actType
	public ObjectProperty<ActivityType> actTypeProperty() {
		return this.actType;
	}

	@XmlElement(name = "AktivityType")
	public ActivityType getActType() {
		return this.actType.get();
	}

	public void setActType(ActivityType at) {
		this.actType.set(at);
	}
	
	//actTypeParam
	public ObjectProperty<ActivityTypeParameter> actTypeParamProperty() {
		return this.actTypeParam;
	}

	@XmlElement(name = "AktivityTypeParam")
	public ActivityTypeParameter getActTypeParam() {
		return this.actTypeParam.get();
	}

	public void setActTypeParam(ActivityTypeParameter param) {
		this.actTypeParam.set(param);
	}

	
}
