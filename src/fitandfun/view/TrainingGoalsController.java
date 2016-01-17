package fitandfun.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import fitandfun.MainApp;
import fitandfun.model.Activity;
import fitandfun.model.GoalType;
import fitandfun.model.TrainingGoals;

public class TrainingGoalsController {

	// Reference to the main application.
	private MainApp mainApp;

	@FXML
	private PieChart pie;

	@FXML
	private ComboBox<TrainingGoals> trainingGoals;
	
	@FXML
	private Label caption;

	private List<Activity> userActivities = new ArrayList<>();
	private TrainingGoals trainingGoal = new TrainingGoals();
	float sumFloatDistance = 0;
	float sumFloatDuration = 0;
	float sumFloat = 0;
	
	
	

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public TrainingGoalsController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		pie.setVisible(false);
		caption.setTextFill(Color.DARKBLUE);
		caption.setStyle("-fx-font: 24 arial;");

		trainingGoals.setCellFactory(new Callback<ListView<TrainingGoals>, ListCell<TrainingGoals>>() {
			@Override
			public ListCell<TrainingGoals> call(ListView<TrainingGoals> param) {
				return new ListCell<TrainingGoals>() {
					@Override
					protected void updateItem(TrainingGoals item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							this.setText(item.getType().getName());
						}
					}
				};
			}
		});
		trainingGoals.setConverter(new StringConverter<TrainingGoals>() {
			@Override
			public String toString(TrainingGoals at) {
				if (at == null) {
					return null;
				} else {
					return at.getType().getName();
				}
			}

			@Override
			public TrainingGoals fromString(String name) {
				return null;
			}
		});

		trainingGoals.valueProperty().addListener(new ChangeListener<TrainingGoals>() {

			@Override
			public void changed(ObservableValue<? extends TrainingGoals> observable, TrainingGoals oldValue,
					TrainingGoals newValue) {
				trainingGoal = newValue;
				updateCharts();
			}
		});
	}

	private void updateCharts() {
		sumFloatDistance = 0;
		sumFloatDuration = 0;
		sumFloat = 0;
		
		userActivities.clear();
		if (trainingGoal != null) {
			pie.setVisible(true);
			for (Activity a : mainApp.getUserActivity()) {
				if (a.getType().getName().equals(trainingGoal.getType().getActType().getName())
						&& (a.getDate().isEqual(trainingGoal.getStartDate())
								|| a.getDate().isAfter(trainingGoal.getStartDate()))
						&& (a.getDate().isEqual(trainingGoal.getDate())
								|| a.getDate().isBefore(trainingGoal.getDate()))) {
					userActivities.add(a);
				}
			}

			for (Activity act : userActivities) {
				if (trainingGoal.getType().getActTypeParam().getParamName().equals("Distanz")) {
					sumFloat = sumFloat + act.getDistance();
				} else if (trainingGoal.getType().getActTypeParam().getParamName().equals("Durchschnittsgeschwindigkeit")) {
					sumFloatDistance = sumFloatDistance + act.getDistance();
					sumFloatDuration = sumFloatDuration + (float)(act.getDuration().getHour() + act.getDuration().getMinute()/60.0);
				} else if (trainingGoal.getType().getActTypeParam().getParamName().equals("Dauer")) {
					sumFloatDuration = sumFloatDuration + (float)(act.getDuration().getHour() + act.getDuration().getMinute()/60.0);
				} else if (trainingGoal.getType().getActTypeParam().getParamName().equals("Verbrauchte kcal")) {
					sumFloat = sumFloat + act.getCalories();
				} else if (trainingGoal.getType().getActTypeParam().getParamName().equals("Höhenmeter")) {
					sumFloat = sumFloat + act.getHMeter();
				}
			}
			if(sumFloatDuration>0)
			{
				sumFloat = sumFloatDistance/sumFloatDuration;
			}
			
			ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
					new PieChart.Data("geschafft", sumFloat),
					new PieChart.Data("offen", trainingGoal.getGoalValue()-sumFloat)
					);

			pie.setData(pieChartData);
			pie.setTitle(trainingGoal.getType().getName());
			pie.setLegendSide(Side.RIGHT);
			
			
			for (final PieChart.Data data : pie.getData()) {
			    data.getNode().addEventHandler(MouseEvent.MOUSE_MOVED,
			        new EventHandler<MouseEvent>() {
			            @Override public void handle(MouseEvent e) {
			                caption.setTranslateX(e.getSceneX());
			                caption.setTranslateY(e.getSceneY()-220);
			                caption.setText(String.valueOf(data.getPieValue()) + " " + trainingGoal.getType().getActTypeParam().getParamUnit());
			             }
			        });
			    data.getNode().addEventHandler(MouseEvent.MOUSE_EXITED,  new EventHandler<MouseEvent>(){
			    	@Override public void handle(MouseEvent e)
			    	{
			    		caption.setText("");
			    	}
			    	
			    });
			}
		
		} else {
			pie.setVisible(false);
		}
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		trainingGoals.getItems().addAll(mainApp.getTrainingGoals());
	}

	@FXML
	private void showHomepage() {
		mainApp.showHomepage();
	}

	@FXML
	private void showInputTrainingGoal() {
		mainApp.showInputTrainingGoalController();
	}
}
