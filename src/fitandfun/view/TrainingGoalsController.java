package fitandfun.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.util.Callback;
import javafx.util.StringConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import fitandfun.MainApp;
import fitandfun.model.Activity;
import fitandfun.model.TrainingGoals;

/**
 * 
 * @author Viktoria Jechsmayr
 * @version 1.0
 *
 */
public class TrainingGoalsController {

	/**
	 * Reference to the main Application
	 */
	private MainApp mainApp;

	/*
	 * FXML Variables to link
	 */
	@FXML
	private PieChart pie;

	@FXML
	private ComboBox<TrainingGoals> trainingGoals;

	@FXML
	private Label caption;

	@FXML
	private GridPane details;

	@FXML
	private Label trainingGoalName;

	@FXML
	private Label goalTypeName;

	@FXML
	private Label startDate;

	@FXML
	private Label goalDate;

	@FXML
	private Label valueUnit;

	@FXML
	private Button detailButton;
	
	@FXML
	private Label activeUserLabel;

	private List<Activity> userActivities = new ArrayList<>();
	private TrainingGoals trainingGoal = new TrainingGoals();
	
	/*
	 * Variables to calculate values to show in pieChart
	 */
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
							this.setText(item.getName());
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
					return at.getName();
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
		detailButton.setVisible(false);
	}

	/**
	 * Update Pie Chart when Value Changed in ComboBox
	 */
	private void updateCharts() {
		Date date;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat print = new SimpleDateFormat("dd.MM.yyyy");
		
		sumFloatDistance = 0;
		sumFloatDuration = 0;
		sumFloat = 0;
		detailButton.setVisible(true);

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
				} else if (trainingGoal.getType().getActTypeParam().getParamName()
						.equals("Durchschnittsgeschwindigkeit")) {
					sumFloatDistance = sumFloatDistance + act.getDistance();
					sumFloatDuration = sumFloatDuration
							+ (float) (act.getDuration().getHour() + act.getDuration().getMinute() / 60.0);
				} else if (trainingGoal.getType().getActTypeParam().getParamName().equals("Dauer")) {
					sumFloat = sumFloat + (float) (act.getDuration().getHour() + act.getDuration().getMinute() / 60.0);
				} else if (trainingGoal.getType().getActTypeParam().getParamName().equals("Verbrauchte kcal")) {
					sumFloat = sumFloat + act.getCalories();
				} else if (trainingGoal.getType().getActTypeParam().getParamName().equals("Höhenmeter")) {
					sumFloat = sumFloat + act.getHMeter();
				}
			}
			if (sumFloatDuration > 0) {
				sumFloat = sumFloatDistance / sumFloatDuration;
			}

			if (sumFloat >= trainingGoal.getGoalValue()) {
				deleteTrainingGoal(trainingGoal);
				showTrainingGoalCompleted();
			} else {
				ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
						new PieChart.Data("geschafft", sumFloat),
						new PieChart.Data("offen", trainingGoal.getGoalValue() - sumFloat));

				pie.setData(pieChartData);
				pie.getStylesheets().add("FitandFunTheme.css");			
				goalTypeName.setText(trainingGoal.getType().getName());
				trainingGoalName.setText(trainingGoal.getName());
				
				try {
					date = format.parse(trainingGoal.getStartDateString());
					startDate.setText(print.format(date));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					date = format.parse(trainingGoal.getDateString());
					goalDate.setText(print.format(date));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				valueUnit.setText(
						trainingGoal.getGoalValue() + " " + trainingGoal.getType().getActTypeParam().getParamUnit());
			}

			pie.setTitle(trainingGoal.getName());

			for (final PieChart.Data data : pie.getData()) {
				data.getNode().addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						caption.setTranslateX(e.getSceneX());
						caption.setTranslateY(e.getSceneY() - 220);
						if (trainingGoal.getType().getActTypeParam().getParamName().equals("Dauer")) {
							Double t = data.getPieValue();
							int h = t.intValue();
							t = t - h;
							int m = (int) (t * 60 + 0.5);
							if (m < 10) {
								caption.setText(h + ":0" + m);
							} else {
								caption.setText(h + ":" + m);
							}

						} else {
							caption.setText(String.valueOf(Math.round((data.getPieValue()*100))/100.0) + " "
									+ trainingGoal.getType().getActTypeParam().getParamUnit());
						}
					}
				});
				data.getNode().addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						caption.setText("");
					}
				});
			}
		} else {
			pie.setVisible(false);
		}
	}

	/**
	 * show Activity Details when clicked on Detail Button
	 */
	@FXML
	private void showActivities() {
		Date date;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat print = new SimpleDateFormat("dd.MM.yyyy");
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("UserActivities");
		alert.setHeaderText("Erfasste Aktivitäten");

		String cont = "";
		for (Activity act : userActivities) {
			try {
				date = format.parse(act.getDateString());
				cont = cont + print.format(date) + " (" + act.getDistance() + "km - " + act.getDurationString() + ")<br> ";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		WebView view = new WebView();
		view.getEngine().loadContent(cont);
		view.setPrefSize(280, 400);

		alert.getDialogPane().setContent(view);
		alert.showAndWait();
	}

	/**
	 * Delete TrainingGoal when completed
	 * @param tg
	 */
	private void deleteTrainingGoal(TrainingGoals tg) {
		if (tg != null) {
			mainApp.getTrainingGoals().remove(tg);
			mainApp.saveTrainingGoalsXML();
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
		activeUserLabel.setText(mainApp.getActiveUser().getUsername());
	}

	/**
	 * Method to navigate to the Homepage in FXML
	 */
	@FXML
	private void showHomepage() {
		mainApp.showHomepage();
	}

	/**
	 * Method to navigate to the InputTrainingGoal in FXML
	 */
	@FXML
	private void showInputTrainingGoal() {
		mainApp.showInputTrainingGoalController();
	}

	/**
	 * Method to navigate to the TrainingGoalCompleted in FXML
	 */
	private void showTrainingGoalCompleted() {
		mainApp.showTrainingGoalCompletedController();
	}
}
