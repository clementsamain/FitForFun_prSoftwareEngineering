package fitandfun.view;

import java.io.File;
import java.util.ArrayList;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.LatLongBounds;
import com.lynden.gmapsfx.javascript.object.MVCArray;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.shapes.Polyline;
import com.lynden.gmapsfx.shapes.PolylineOptions;
import fitandfun.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import net.divbyzero.gpx.GPX;
import net.divbyzero.gpx.Track;
import net.divbyzero.gpx.TrackSegment;
import net.divbyzero.gpx.Waypoint;
import net.divbyzero.gpx.parser.JDOM;
import net.divbyzero.gpx.parser.ParsingException;
import netscape.javascript.JSObject;

/**
 * Controller Class for the MapMenu, shows a list with activities where a card
 * is available link to the map
 * 
 * @author Marco Maihofer, Viktoria Jechsmayr
 * @version 1.0
 *
 */
public class MapController {

	private MainApp mainApp;

	@FXML
	private Label actUserLabel;

	@FXML
	private BorderPane mapPane;

	@FXML
	private Button btnZoomIn;

	@FXML
	private Button btnToomOut;

	@FXML
	private ComboBox<MapTypeIdEnum> mapTypeCombo;

	LatLong[] ary;

	protected GoogleMapView mapComponent;
	protected GoogleMap map;
	private String gpxName;

	public MapController() {
	}

	@FXML
	private void initialize() {

	}

	private void init() {
		gpxName = mainApp.getGPXName();
		startMap();
		initMap();
	}

	@FXML
	private void ZoomOut() {
		map.zoomProperty().set(map.getZoom() - 2);
	}

	@FXML
	private void ZoomIn() {
		map.zoomProperty().set(map.getZoom() + 2);
	}

	@FXML
	private void selectMapType() {
		map.setMapType(mapTypeCombo.getSelectionModel().getSelectedItem());
	}

	private void startMap() {
		mapComponent = new GoogleMapView();
		// mapComponent.addMapInializedListener(this);
		
		mapComponent.addMapInializedListener(new MapComponentInitializedListener() {
			@Override
			public void mapInitialized() {
				// TODO Auto-generated method stub
				initMap();
			}
		});

		mapTypeCombo.getItems().addAll(MapTypeIdEnum.ALL);
		try {
			map.setMapType(MapTypeIdEnum.HYBRID);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		mapPane.setCenter(mapComponent);
	}

	/**
	 * initializes the map with the route (GPX file is analyzed)
	 */
	private void initMap() {
		// Once the map has been loaded by the Webview, initialize the map
		// details.
		LatLong center = new LatLong(48.3058789, 14.2865628);

		MapOptions options = new MapOptions();
		options.center(center).mapMarker(true).zoom(5).overviewMapControl(false).panControl(false).rotateControl(false)
				.scaleControl(false).streetViewControl(false).zoomControl(false).mapType(MapTypeIdEnum.TERRAIN);

		map = mapComponent.createMap(options);
		map.setZoom(8);

		map.setHeading(123.2);

		ArrayList<Track> tracks = new ArrayList<Track>();
		GPX gpx = new GPX();
		JDOM p = new JDOM();
		double tempDist = 0;
		int tempAsc = 0;
		File selFile = new File(gpxName);

		if (selFile != null) {
			try {
				gpx = p.parse(selFile);
			} catch (ParsingException e) {
				e.printStackTrace();
			}

			tracks = gpx.getTracks();
			
			double lat = tracks.get(0).getSegments().get(0).getWaypoints().get(0).getCoordinate().getLatitude() - 0.3;
			double lon = tracks.get(0).getSegments().get(0).getWaypoints().get(0).getCoordinate().getLongitude() + 0.2;
			
			map.setCenter(new LatLong(lat, lon));
			
			for (Track t : tracks) {

				ArrayList<TrackSegment> trackSegments = t.getSegments();

				for (TrackSegment v : trackSegments) {

					ArrayList<Waypoint> waypoints = v.getWaypoints(); // get all
																		// the
																		// waypoints
																		// of a
																		// track

					MarkerOptions markerOptions = new MarkerOptions();

					ary = new LatLong[waypoints.size()];

					for (int i = 0; i < waypoints.size(); i++) {

						LatLong markerLatLong1 = new LatLong(waypoints.get(i).getCoordinate().getLatitude(),
								waypoints.get(i).getCoordinate().getLongitude());

						ary[i] = markerLatLong1; // save coordinates in an array
					}

					LatLong markerLatLong = new LatLong(waypoints.get(0).getCoordinate().getLatitude(),
							waypoints.get(0).getCoordinate().getLongitude());

					Marker myMarker = new Marker(markerOptions);
					map.addMarker(myMarker); // add the first position as start
												// marker

					myMarker = new Marker(markerOptions);
					map.addMarker(myMarker); // add the latest position as end
												// marker

					MVCArray mvc = new MVCArray(ary); // converts the waypoints
														// array in a path

					PolylineOptions polyOpts = new PolylineOptions() // print
																		// path
																		// on
																		// the
																		// map
							.path(mvc).strokeColor("red").strokeWeight(3);

					Polyline poly = new Polyline(polyOpts);
					map.addMapShape(poly);
					map.addUIEventHandler(poly, UIEventType.click, (JSObject obj) -> {
						map.fitBounds(new LatLongBounds(markerLatLong, center));
					});

					tempDist = tempDist + (t.length() / 1000);
					tempAsc = tempAsc + (int) t.cumulativeAscent();
				}
			}
		}
	}

	/**
	 * Sets up the mainApp and gets the active user information and the users
	 * activities (as an observable list) from the main app.
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		actUserLabel.setText(mainApp.getActiveUser().getUsername());
		init();
	}

	/**
	 * import a gpx to show the card, file is not saved
	 */
	@FXML
	public void importMap() {

		FileChooser fc = new FileChooser();
		File selFile = fc.showOpenDialog(null);
		mainApp.showMap(selFile.getAbsolutePath());
	}

	/**
	 * Handles the navigation back to the main screen of the app.
	 */
	@FXML
	private void showHomepage() {
		mainApp.showHomepage();
	}
}
