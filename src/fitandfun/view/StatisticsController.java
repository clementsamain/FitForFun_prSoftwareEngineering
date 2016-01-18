package fitandfun.view;

import fitandfun.MainApp;
import fitandfun.Period;
import fitandfun.model.Activity;
import fitandfun.model.ActivityType;
import fitandfun.model.User;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * 
 * @author StefanKaindlbinder
 * @version 1.0
 *
 */
public class StatisticsController {

	// Reference to the main application.
	private MainApp mainApp;
	private String username;
	private ObservableList<ActivityType> activityTypeList;
	private ObservableList<Activity> activityList;
	private int gCals;
	private int gKms;
	private int gHms;

	@FXML
	private BarChart<String, Integer> distChart;
	@FXML
	private CategoryAxis distX;
	@FXML
	private CategoryAxis hmX;
	@FXML
	private BarChart<String, Integer> hmChart;
	@FXML
	private PieChart activityOverviewChart;
	@FXML
	private ComboBox<Period> cboPeriod;
	@FXML
	private Label actUserLabel;
	@FXML
	private Label absT;
	@FXML
	private Label kms;
	@FXML
	private Label hms;
	@FXML
	private Label cals;

	private ObservableList<String> monthNames = FXCollections.observableArrayList();
	private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public StatisticsController() {

	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		gCals = 0;
		gKms = 0;
		gHms = 0;
		//Category Names
		String[] months = {"Jan", "Feb", "Mar", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"};
		monthNames.addAll(Arrays.asList(months));
		distX.setCategories(monthNames);
		hmX.setCategories(monthNames);

		cboPeriod.getItems().addAll(Period.values());
		cals.setText("-");
	}

	public void setDistChart() {
		ObjectProperty<LocalDate> temp;
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        for (int i = 0; i < 12; i++) {
        	int val = 0;
        	int m = i + 1;
        	for (Activity act : activityList) {
            	temp = act.dateProperty();
            	int actM = temp.get().getMonthValue();
            	if(m == actM) val += act.getDistance();

            }
            series.getData().add(new XYChart.Data<>(monthNames.get(i), val));
            gKms += val;
        }
        distChart.setLegendVisible(false);
        distChart.getData().add(series);
        kms.setText(String.valueOf(gKms));
    }

	public void setHmChart() {
		ObjectProperty<LocalDate> temp;
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        for (int i = 0; i < 12; i++) {
        	int val = 0;
        	int m = i + 1;
        	for (Activity act : activityList) {
            	temp = act.dateProperty();
            	int actM = temp.get().getMonthValue();
            	if(m == actM)val += act.getHMeter();
            }
            series.getData().add(new XYChart.Data<>(monthNames.get(i), val));
            gHms += val;
        }
        hmChart.setLegendVisible(false);
        hmChart.getData().add(series);
        hms.setText(String.valueOf(gHms));
    }

	public void setActivityOverviewChart() {
		activityOverviewChart.setLegendVisible(false);
		pieChartData = FXCollections.observableArrayList();
		for (ActivityType typ : activityTypeList) {
			int anz = 0;
			for (Activity act : activityList) {
				if(act.getTypeString().equals(typ.getName())) anz++;
			}
            pieChartData.add(new PieChart.Data(typ.getName(), anz));
        }
		activityOverviewChart.setData(pieChartData);
		absT.setText(String.valueOf(activityList.size()));
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		username = mainApp.getActiveUser().getUsername();
		actUserLabel.setText(username);
		activityTypeList = mainApp.getActivityData();
		activityList = mainApp.getUserActivity();
		setHmChart();
		setDistChart();
		setActivityOverviewChart();
	}

	@FXML
	private void showHomepage() {
		mainApp.showHomepage();
	}
}
