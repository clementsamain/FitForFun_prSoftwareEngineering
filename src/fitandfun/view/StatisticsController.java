package fitandfun.view;

import fitandfun.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import java.util.Arrays;

public class StatisticsController {

	// Reference to the main application.
	private MainApp mainApp;

	@FXML
	private BarChart<String, Integer> distChart;
	@FXML
	private CategoryAxis distX;
	@FXML
	private BarChart<String, Integer> hmChart;
	@FXML
	private CategoryAxis hmX;

	private ObservableList<String> monthNames = FXCollections.observableArrayList();

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
		//Allgemeine init.
		String[] months = {"Jan", "Feb", "Mar", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"};
		monthNames.addAll(Arrays.asList(months));

		//Statistik zurückgelegte Distanz
		distX.setCategories(monthNames);
		setDistChart();

		//Statistik zurückgelegte Distanz
		hmX.setCategories(monthNames);
		setHmChart();
	}

	public void setDistChart() {
        int[] monthCounter = {12,24,16,3,34,45,14,19,33,12,8,4};
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        for (int i = 0; i < monthCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
        }
        distChart.setLegendVisible(false);
        distChart.getData().add(series);
    }

	public void setHmChart() {
        int[] monthCounter = {250,120,1300,3400,6005,2300,1900,805,777,120,45,50};
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        for (int i = 0; i < monthCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
        }
        hmChart.setLegendVisible(false);
        hmChart.getData().add(series);
    }

	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}

	@FXML
	private void showHomepage() {
		mainApp.showHomepage();
	}
}
