package fitandfun.model;

import javax.xml.bind.annotation.XmlElement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * WorkoutType to load and save WorkoutTypes used by all Users
 * @author Sabrina, Marion, Kerstin
 * @version 0.1
 */

public class WorkoutType {
	private StringProperty actName;

	private StringProperty exercise1;
	private StringProperty exercise2;
	private StringProperty exercise3;
	private StringProperty exercise4;
	private StringProperty exercise5;
	private StringProperty exercise6;

	private StringProperty repeat1;
	private StringProperty repeat2;
	private StringProperty repeat3;
	private StringProperty repeat4;
	private StringProperty repeat5;
	private StringProperty repeat6;

	private StringProperty countsToGo;
	
	
	public WorkoutType() {
		this(null);
	}

	public WorkoutType(String name) {
		this.actName = new SimpleStringProperty(name);
		this.exercise1 = new SimpleStringProperty();
		this.exercise2 = new SimpleStringProperty();
		this.exercise3 = new SimpleStringProperty();
		this.exercise4 = new SimpleStringProperty();
		this.exercise5 = new SimpleStringProperty();
		this.exercise6 = new SimpleStringProperty();
		this.repeat1 = new SimpleStringProperty();
		this.repeat2 = new SimpleStringProperty();
		this.repeat3 = new SimpleStringProperty();
		this.repeat4 = new SimpleStringProperty();
		this.repeat5 = new SimpleStringProperty();
		this.repeat6 = new SimpleStringProperty();
		this.countsToGo = new SimpleStringProperty();
	}

	public StringProperty nameProperty() {
		return this.actName;
	}

	@XmlElement(name = "Type")
	public String getName() {
		return this.actName.get();
	}

	public void setName(String name) {
		this.actName.set(name);
	}

	public StringProperty getExercise1Property() {
		return this.exercise1;
	}

	@XmlElement(name = "Exercise1")
	public String getExercise1() {
		return this.exercise1.get();
	}

	public void setExercise1(String exercise1) {
		this.exercise1.set(exercise1);
	}

	public StringProperty getExercise2Property() {
		return this.exercise2;
	}

	@XmlElement(name = "Exercise2")
	public String getExercise2() {
		return this.exercise2.get();
	}

	public void setExercise2(String exercise2) {
		this.exercise2.set(exercise2);
	}

	public StringProperty getExercise3Property() {
		return this.exercise3;
	}

	@XmlElement(name = "Exercise3")
	public String getExercise3() {
		return this.exercise3.get();
	}

	public void setExercise3(String exercise3) {
		this.exercise3.set(exercise3);
	}

	public StringProperty getExercise4Property() {
		return this.exercise4;
	}

	@XmlElement(name = "Exercise4")
	public String getExercise4() {
		return this.exercise4.get();
	}

	public void setExercise4(String exercise4) {
		this.exercise4.set(exercise4);
	}

	public StringProperty getExercise5Property() {
		return this.exercise5;
	}

	@XmlElement(name = "Exercise5")
	public String getExercise5() {
		return this.exercise5.get();
	}

	public void setExercise5(String exercise5) {
		this.exercise5.set(exercise5);
	}

	public StringProperty getExercise6Property() {
		return this.exercise6;
	}

	@XmlElement(name = "Exercise6")
	public String getExercise6() {
		return this.exercise6.get();
	}

	public void setExercise6(String exercise6) {
		this.exercise6.set(exercise6);
	}

	public StringProperty getRepeat1Property() {
		return this.repeat1;
	}

	@XmlElement(name = "Repeat1")
	public String getRepeat1() {
		return this.repeat1.get();
	}

	public void setRepeat1(String repeat1) {
		this.repeat1.set(repeat1);
	}

	public StringProperty getRepeat2Property() {
		return this.repeat2;
	}

	@XmlElement(name = "Repeat2")
	public String getRepeat2() {
		return this.repeat2.get();
	}

	public void setRepeat2(String repeat2) {
		this.repeat2.set(repeat2);
	}

	public StringProperty getRepeat3Property() {
		return this.repeat3;
	}

	@XmlElement(name = "Repeat3")
	public String getRepeat3() {
		return this.repeat3.get();
	}

	public void setRepeat3(String repeat3) {
		this.repeat3.set(repeat3);
	}

	public StringProperty getRepeat4Property() {
		return this.repeat4;
	}

	@XmlElement(name = "Repeat4")
	public String getRepeat4() {
		return this.repeat4.get();
	}

	public void setRepeat4(String repeat4) {
		this.repeat4.set(repeat4);
	}

	public StringProperty getRepeat5Property() {
		return this.repeat5;
	}

	@XmlElement(name = "Repeat5")
	public String getRepeat5() {
		return this.repeat5.get();
	}

	public void setRepeat5(String repeat5) {
		this.repeat5.set(repeat5);
	}

	public StringProperty getRepeat6Property() {
		return this.repeat6;
	}

	@XmlElement(name = "Repeat6")
	public String getRepeat6() {
		return this.repeat6.get();
	}

	public void setRepeat6(String repeat6) {
		this.repeat6.set(repeat6);
	}

	public StringProperty getCountsToGoProperty() {
		return this.countsToGo;
	}

	@XmlElement(name = "Counts")
	public String getCountsToGo() {
		return this.countsToGo.get();
	}

	public void setCountsToGo(String countsToGo) {
		this.countsToGo.set(countsToGo);
	}
}