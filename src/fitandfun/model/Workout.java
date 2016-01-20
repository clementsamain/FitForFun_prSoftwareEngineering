//package fitandfun.model;
//
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlTransient;
//
//import javafx.beans.property.ObjectProperty;
//import javafx.beans.property.SimpleObjectProperty;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//
///**
// * 'Workout-Class for creating UserWorkout
// * 
// * @author Marion, Sabrina, Kerstin
// * @version 0.1
// */
//public class Workout {
//
//	/**
//	 * Workout Variables to fill data
//	 */
//	private final ObjectProperty<WorkoutType> type;
//	
//	private final StringProperty completedCounts;
//	private final StringProperty countsToGo;
//	
//	private final StringProperty exercise1;
//	private final StringProperty exercise2;
//	private final StringProperty exercise3;
//	private final StringProperty exercise4;
//	private final StringProperty exercise5;
//	private final StringProperty exercise6;
//
//	private final StringProperty repeat1;
//	private final StringProperty repeat2;
//	private final StringProperty repeat3;
//	private final StringProperty repeat4;
//	private final StringProperty repeat5;
//	private final StringProperty repeat6;
//	
//
//	public Workout() {
//		this(null);
//	}
//	
//	public Workout(WorkoutType type) {
//		this.type = new SimpleObjectProperty<WorkoutType>(type);
//		this.exercise1 = new SimpleStringProperty();
//		this.exercise2 = new SimpleStringProperty();
//		this.exercise3 = new SimpleStringProperty();
//		this.exercise4 = new SimpleStringProperty();
//		this.exercise5 = new SimpleStringProperty();
//		this.exercise6 = new SimpleStringProperty();
//		this.repeat1 = new SimpleStringProperty();
//		this.repeat2 = new SimpleStringProperty();
//		this.repeat3 = new SimpleStringProperty();
//		this.repeat4 = new SimpleStringProperty();
//		this.repeat5 = new SimpleStringProperty();
//		this.repeat6 = new SimpleStringProperty();
//		this.completedCounts = new SimpleStringProperty();
//		this.countsToGo = new SimpleStringProperty();
//	}
//	
//	public Workout(WorkoutType type, String exercise1, String repeat1, String completedCounts, String countsToGo) {
//		this.type = new SimpleObjectProperty<WorkoutType>(type);
//		this.exercise1 = new SimpleStringProperty(exercise1);
//		this.exercise2 = new SimpleStringProperty();
//		this.exercise3 = new SimpleStringProperty();
//		this.exercise4 = new SimpleStringProperty();
//		this.exercise5 = new SimpleStringProperty();
//		this.exercise6 = new SimpleStringProperty();
//		this.repeat1 = new SimpleStringProperty(repeat1);
//		this.repeat2 = new SimpleStringProperty();
//		this.repeat3 = new SimpleStringProperty();
//		this.repeat4 = new SimpleStringProperty();
//		this.repeat5 = new SimpleStringProperty();
//		this.repeat6 = new SimpleStringProperty();
//		this.completedCounts = new SimpleStringProperty(completedCounts);
//		this.countsToGo = new SimpleStringProperty(countsToGo);
//	}
//	
//	public Workout(WorkoutType type, String exercise1, String exercise2, String repeat1, String repeat2, String completedCounts, String countsToGo) {
//		this.type = new SimpleObjectProperty<WorkoutType>(type);
//		this.exercise1 = new SimpleStringProperty(exercise1);
//		this.exercise2 = new SimpleStringProperty(exercise2);
//		this.exercise3 = new SimpleStringProperty();
//		this.exercise4 = new SimpleStringProperty();
//		this.exercise5 = new SimpleStringProperty();
//		this.exercise6 = new SimpleStringProperty();
//		this.repeat1 = new SimpleStringProperty(repeat1);
//		this.repeat2 = new SimpleStringProperty(repeat2);
//		this.repeat3 = new SimpleStringProperty();
//		this.repeat4 = new SimpleStringProperty();
//		this.repeat5 = new SimpleStringProperty();
//		this.repeat6 = new SimpleStringProperty();
//		this.completedCounts = new SimpleStringProperty(completedCounts);
//		this.countsToGo = new SimpleStringProperty(countsToGo);
//	}
//	
//	public Workout(WorkoutType type, String exercise1, String exercise2, String exercise3, String repeat1, String repeat2, String repeat3, String completedCounts, String countsToGo) {
//		this.type = new SimpleObjectProperty<WorkoutType>(type);
//		this.exercise1 = new SimpleStringProperty(exercise1);
//		this.exercise2 = new SimpleStringProperty(exercise2);
//		this.exercise3 = new SimpleStringProperty(exercise3);
//		this.exercise4 = new SimpleStringProperty();
//		this.exercise5 = new SimpleStringProperty();
//		this.exercise6 = new SimpleStringProperty();
//		this.repeat1 = new SimpleStringProperty(repeat1);
//		this.repeat2 = new SimpleStringProperty(repeat2);
//		this.repeat3 = new SimpleStringProperty(repeat3);
//		this.repeat4 = new SimpleStringProperty();
//		this.repeat5 = new SimpleStringProperty();
//		this.repeat6 = new SimpleStringProperty();
//		this.completedCounts = new SimpleStringProperty(completedCounts);
//		this.countsToGo = new SimpleStringProperty(countsToGo);
//	}
//	
//	public Workout(WorkoutType type, String exercise1, String exercise2, String exercise3, String exercise4, String repeat1, String repeat2, String repeat3, String repeat4, String completedCounts, String countsToGo) {
//		this.type = new SimpleObjectProperty<WorkoutType>(type);
//		this.exercise1 = new SimpleStringProperty(exercise1);
//		this.exercise2 = new SimpleStringProperty(exercise2);
//		this.exercise3 = new SimpleStringProperty(exercise3);
//		this.exercise4 = new SimpleStringProperty(exercise4);
//		this.exercise5 = new SimpleStringProperty();
//		this.exercise6 = new SimpleStringProperty();
//		this.repeat1 = new SimpleStringProperty(repeat1);
//		this.repeat2 = new SimpleStringProperty(repeat2);
//		this.repeat3 = new SimpleStringProperty(repeat3);
//		this.repeat4 = new SimpleStringProperty(repeat4);
//		this.repeat5 = new SimpleStringProperty();
//		this.repeat6 = new SimpleStringProperty();
//		this.completedCounts = new SimpleStringProperty(completedCounts);
//		this.countsToGo = new SimpleStringProperty(countsToGo);
//	}
//	
//	public Workout(WorkoutType type, String exercise1, String exercise2, String exercise3, String exercise4, String exercise5, String repeat1, String repeat2, String repeat3, String repeat4, String repeat5, String completedCounts, String countsToGo) {
//		this.type = new SimpleObjectProperty<WorkoutType>(type);
//		this.exercise1 = new SimpleStringProperty(exercise1);
//		this.exercise2 = new SimpleStringProperty(exercise2);
//		this.exercise3 = new SimpleStringProperty(exercise3);
//		this.exercise4 = new SimpleStringProperty(exercise4);
//		this.exercise5 = new SimpleStringProperty(exercise5);
//		this.exercise6 = new SimpleStringProperty();
//		this.repeat1 = new SimpleStringProperty(repeat1);
//		this.repeat2 = new SimpleStringProperty(repeat2);
//		this.repeat3 = new SimpleStringProperty(repeat3);
//		this.repeat4 = new SimpleStringProperty(repeat4);
//		this.repeat5 = new SimpleStringProperty(repeat5);
//		this.repeat6 = new SimpleStringProperty();
//		this.completedCounts = new SimpleStringProperty(completedCounts);
//		this.countsToGo = new SimpleStringProperty(countsToGo);
//	}
//	
//	public Workout(WorkoutType type, String exercise1, String exercise2, String exercise3, String exercise4, String exercise5, String exercise6, 
//			String repeat1, String repeat2, String repeat3, String repeat4, String repeat5, String repeat6, String completedCounts, String countsToGo) {
//		this.type = new SimpleObjectProperty<>(type);
//		
//		this.exercise1 = new SimpleStringProperty(exercise1);
//		this.exercise2 = new SimpleStringProperty(exercise2);
//		this.exercise3 = new SimpleStringProperty(exercise3);
//		this.exercise4 = new SimpleStringProperty(exercise4);
//		this.exercise5 = new SimpleStringProperty(exercise5);
//		this.exercise6 = new SimpleStringProperty(exercise6);
//		
//		this.repeat1 = new SimpleStringProperty(repeat1);
//		this.repeat2 = new SimpleStringProperty(repeat2);
//		this.repeat3 = new SimpleStringProperty(repeat3);
//		this.repeat4 = new SimpleStringProperty(repeat4);
//		this.repeat5 = new SimpleStringProperty(repeat5);
//		this.repeat6 = new SimpleStringProperty(repeat6);
//		
//		this.completedCounts = new SimpleStringProperty(completedCounts);
//		this.countsToGo = new SimpleStringProperty("0");					/*asjdflksakdlf*/
//	}
//
//	/**
//	 * Property-getter, Getter- and Setter Methods for activityName
//	 */
//	public ObjectProperty<WorkoutType> workoutTypeProperty() {
//		return this.type;
//	}
//
//	@XmlTransient
//	public String getTypeString() {
//		if (type.get() != null) {
//			return type.get().getName();
//		}
//		return "";
//	}
//
//	public void setTypeString(String nType) {
//		// TODO nice to have --> sehr komplex!
//	}
//
//	@XmlElement(name = "Type")
//	public WorkoutType getType() {
//		return type.get();
//	}
//
//	public void setType(WorkoutType type) {
//		this.type.set(type);
//	}
//
//	
//	public StringProperty getExercise1Property() {
//		return this.exercise1;
//	}
//
//	@XmlElement(name = "Exercise1")
//	public String getExercise1() {
//		return this.exercise1.get();
//	}
//
//	public void setExercise1(String exercise1) {
//		this.exercise1.set(exercise1);
//	}
//	
//	public StringProperty getExercise2Property() {
//		return this.exercise2;
//	}
//
//	@XmlElement(name = "Exercise2")
//	public String getExercise2() {
//		return this.exercise2.get();
//	}
//
//	public void setExercise2(String exercise2) {
//		this.exercise2.set(exercise2);
//	}
//
//	public StringProperty getExercise3Property() {
//		return this.exercise3;
//	}
//
//	@XmlElement(name = "Exercise3")
//	public String getExercise3() {
//		return this.exercise3.get();
//	}
//
//	public void setExercise3(String exercise3) {
//		this.exercise3.set(exercise3);
//	}
//
//	public StringProperty getExercise4Property() {
//		return this.exercise4;
//	}
//
//	@XmlElement(name = "Exercise4")
//	public String getExercise4() {
//		return this.exercise4.get();
//	}
//
//	public void setExercise4(String exercise4) {
//		this.exercise4.set(exercise4);
//	}
//
//	public StringProperty getExercise5Property() {
//		return this.exercise5;
//	}
//
//	@XmlElement(name = "Exercise5")
//	public String getExercise5() {
//		return this.exercise5.get();
//	}
//
//	public void setExercise5(String exercise5) {
//		this.exercise5.set(exercise5);
//	}
//
//	public StringProperty getExercise6Property() {
//		return this.exercise6;
//	}
//
//	@XmlElement(name = "Exercise6")
//	public String getExercise6() {
//		return this.exercise6.get();
//	}
//
//	public void setExercise6(String exercise6) {
//		this.exercise6.set(exercise6);
//	}
//
//	public StringProperty getRepeat1Property() {
//		return this.repeat1;
//	}
//
//	@XmlElement(name = "Repeat1")
//	public String getRepeat1() {
//		return this.repeat1.get();
//	}
//
//	public void setRepeat1(String repeat1) {
//		this.repeat1.set(repeat1);
//	}
//
//	public StringProperty getRepeat2Property() {
//		return this.repeat2;
//	}
//
//	@XmlElement(name = "Repeat2")
//	public String getRepeat2() {
//		return this.repeat2.get();
//	}
//
//	public void setRepeat2(String repeat2) {
//		this.repeat2.set(repeat2);
//	}
//
//	public StringProperty getRepeat3Property() {
//		return this.repeat3;
//	}
//
//	@XmlElement(name = "Repeat3")
//	public String getRepeat3() {
//		return this.repeat3.get();
//	}
//
//	public void setRepeat3(String repeat3) {
//		this.repeat3.set(repeat3);
//	}
//
//	public StringProperty getRepeat4Property() {
//		return this.repeat4;
//	}
//
//	@XmlElement(name = "Repeat4")
//	public String getRepeat4() {
//		return this.repeat4.get();
//	}
//
//	public void setRepeat4(String repeat4) {
//		this.repeat4.set(repeat4);
//	}
//
//	public StringProperty getRepeat5Property() {
//		return this.repeat5;
//	}
//
//	@XmlElement(name = "Repeat5")
//	public String getRepeat5() {
//		return this.repeat5.get();
//	}
//
//	public void setRepeat5(String repeat5) {
//		this.repeat5.set(repeat5);
//	}
//
//	public StringProperty getRepeat6Property() {
//		return this.repeat6;
//	}
//
//	@XmlElement(name = "Repeat6")
//	public String getRepeat6() {
//		return this.repeat6.get();
//	}
//
//	public void setRepeat6(String repeat6) {
//		this.repeat6.set(repeat6);
//	}
//
//	public StringProperty getCountsToGoProperty() {
//		return this.countsToGo;
//	}
//
//	@XmlElement(name = "Counts")
//	public String getCountsToGo() {
//		return this.countsToGo.get();
//	}
//
//	public void setCountsToGo(String countsToGo) {
//		this.countsToGo.set(countsToGo);
//	}
//	
//	public StringProperty getCompletedCountsProperty() {
//		return this.completedCounts;
//	}
//
//	@XmlElement(name = "CompletedCounts")
//	public String getCompletedCounts() {
//		return this.completedCounts.get();
//	}
//
//	public void setCompletedCounts(String completedCounts) {
//		this.completedCounts.set(completedCounts);
//	}
//}