package fitandfun.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * ActivityTypeParameter to get the ParameterUnits from the Parameters from
 * Activities
 * 
 * @author Viktoria Jechsmayr
 * @version 1.0
 * 
 */
public class ActivityTypeParameter {

	private String paramName;
	private String paramUnit;

	public ActivityTypeParameter() {
		this("", "");
	}

	public ActivityTypeParameter(String name, String unit) {
		this.paramName = name;
		this.paramUnit = unit;
	}

	@XmlElement(name = "Name")
	public String getParamName() {
		return this.paramName;
	}

	@XmlElement(name = "Unit")
	public String getParamUnit() {
		return this.paramUnit;
	}

	public void setParamName(String name) {
		this.paramName = name;
	}

	public void setParamUnit(String unit) {
		this.paramUnit = unit;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof ActivityTypeParameter) {
			ActivityTypeParameter temp = (ActivityTypeParameter) o;
			return this.paramName.equals(temp.getParamName());
		}
		return false;
	}
}