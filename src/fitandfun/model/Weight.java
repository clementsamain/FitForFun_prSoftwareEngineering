package fitandfun.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.XmlElement;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Weight-Class for creating new Weight-Entrys
 * 
 * @author Viktoria Jechsmayr
 * @version 1.0
 * 
 */
public class Weight {
	private final ObjectProperty<LocalDate> date;
	private final DoubleProperty weight;

	public Weight() {
		this(null);
	}

	public Weight(LocalDate date) {
		this(date, 0);
	}

	public Weight(LocalDate date, double weight) {
		this.date = new SimpleObjectProperty<>(date);
		this.weight = new SimpleDoubleProperty(weight);
	}

	/*
	 * Property-getter, Getter- and Setter Methods for date
	 */
	public ObjectProperty<LocalDate> dateProperty() {
		return this.date;
	}

	@XmlElement(name = "Date")
	public String getDateString() {
		if (date.get() == null) {
			return "";
		}
		return date.get().format(DateTimeFormatter.ISO_DATE);
	}

	public void setDateString(String dateString) {
		if (dateString != null) {
			this.date.set(LocalDate.parse(dateString));
		} else {
			this.date.set(null);
		}
	}

	/*
	 * Property-getter, Getter- and Setter Methods for weight
	 */
	public DoubleProperty weightProperty() {
		return this.weight;
	}

	@XmlElement(name = "Weight")
	public double getWeight() {
		return weight.get();
	}

	public void setWeight(double weight) {
		this.weight.set(weight);
	}
}
