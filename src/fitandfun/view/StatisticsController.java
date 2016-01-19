package fitandfun.view;

import fitandfun.MainApp;
import fitandfun.Period;
import fitandfun.model.Activity;
import fitandfun.model.ActivityType;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * StatisticsController shows an staistical overview of the activities
 * (kinds of activities, achieved distances and altitude changes) of
 * active user.
 *
 * @author Stefan Kaindlbinder
 * Version 1.0
 *
 */
public class StatisticsController {
	// Reference to the main application.
	private MainApp mainApp;
	private String username;
	private ObservableList<ActivityType> activityTypeList;
	private ObservableList<Activity> activityList;
	private ObservableList<String> monthNames = FXCollections.observableArrayList();
	private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
	private int gKms;
	private int gHms;
	private Calendar cal = new GregorianCalendar();

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
	@FXML
	private Button refresh;

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

	@FXML
	private void refresh() {
		gKms = 0;
		gHms = 0;
		if(cboPeriod.getValue() == Period.last) {
			setHmChart("last");
			setDistChart("last");
			setActivityOverviewChart("last");
		} else {
			setHmChart("act");
			setDistChart("act");
			setActivityOverviewChart("act");
		}
		System.out.println(cal.get(Calendar.YEAR));
	}

	/**
	 * Sets up the bar chart view for achieved distances using the list
	 * of activities gathered from the main app.
	 *
	 */
	public void setDistChart(String period) {
		ObjectProperty<LocalDate> temp;
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        distChart.getData().clear();
        int y;
        if (period.equals("last")) y = cal.get(Calendar.YEAR) - 1;
        else y = cal.get(Calendar.YEAR);
        for (int i = 0; i < 12; i++) {
        	int val = 0;
        	int m = i + 1;
        	for (Activity act : activityList) {
            	temp = act.dateProperty();
            	int actM = temp.get().getMonthValue();
            	if(m == actM && y == temp.get().getYear()) val += act.getDistance();
            }
            series.getData().add(new XYChart.Data<>(monthNames.get(i), val));
            gKms += val;
        }
        distChart.setLegendVisible(false);
        distChart.getData().add(series);
        kms.setText(String.valueOf(gKms));
    }

	/**
	 * Sets up the bar chart view for achieved altitude changes using the list
	 * of activities gathered from the main app.
	 *
	 */
	public void setHmChart(String period) {
		ObjectProperty<LocalDate> temp;
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        hmChart.getData().clear();
        int y;
        if (period.equals("last")) y = cal.get(Calendar.YEAR) - 1;
        else y = cal.get(Calendar.YEAR);
        for (int i = 0; i < 12; i++) {
        	int val = 0;
        	int m = i + 1;
        	for (Activity act : activityList) {
            	temp = act.dateProperty();
            	int actM = temp.get().getMonthValue();
            	if(m == actM  && y == temp.get().getYear())val += act.getHMeter();
            }
            series.getData().add(new XYChart.Data<>(monthNames.get(i), val));
            gHms += val;
        }
        hmChart.setLegendVisible(false);
        hmChart.getData().add(series);
        hms.setText(String.valueOf(gHms));
    }

	/**
	 * Sets up the pie chart view for the percentages of the different types
	 * of activities of the active user. Uses the list of activities and the
	 * list of activity types gathered from the main app.
	 *
	 */
	public void setActivityOverviewChart(String period) {
		ObjectProperty<LocalDate> temp;
		activityOverviewChart.setLegendVisible(false);
		pieChartData = FXCollections.observableArrayList();
		int y;
		int anz = 0;
		if (period.equals("last")) y = cal.get(Calendar.YEAR) - 1;
        else y = cal.get(Calendar.YEAR);
		for (ActivityType typ : activityTypeList) {
			boolean found = false;
			for (Activity act : activityList) {
				temp = act.dateProperty();
				if(act.getTypeString().equals(typ.getName()) && y == temp.get().getYear()) {
					anz++;
					found = true;
				}
			}
			if (found == true) pieChartData.add(new PieChart.Data(typ.getName(), anz));
        }
		activityOverviewChart.setData(pieChartData);
		absT.setText(String.valueOf(anz));
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
		setHmChart("act");
		setDistChart("act");
		setActivityOverviewChart("act");
	}

	/**
	 * Handles the navigation back to the main screen of the app.
	 */
	@FXML
	private void showHomepage() {
		mainApp.showHomepage();
	}
}
