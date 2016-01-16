package fitandfun.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Helper class to wrap a list of Weight. This is used for saving the
 * Weight list to XML
 * 
 * @author Viki
 * @version 0.1
 */
@XmlRootElement(name = "WeightWrapper")
public class WeightWrapper {

	private List<Weight> weight;

	@XmlElementWrapper(name = "WeightEntry")
	@XmlElement(name = "Weight")
	public List<Weight> getWeight() {
		return weight;
	}

	public void setWeight(List<Weight> weight) {
		this.weight = weight;
	}
}