package fitandfun.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.Animation;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
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
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.divbyzero.gpx.GPX;
import net.divbyzero.gpx.Track;
import net.divbyzero.gpx.TrackSegment;
import net.divbyzero.gpx.Waypoint;
import net.divbyzero.gpx.parser.JDOM;
import net.divbyzero.gpx.parser.ParsingException;
import netscape.javascript.JSObject;

/**
 * class shows the map with the route from the gpx File
 * 
 * @author Marco Maihofer
 * @version 1.0
 */
public class Map implements MapComponentInitializedListener {
	protected GoogleMapView mapComponent;
	protected GoogleMap map;

	private Button btnZoomIn;
	private Button btnZoomOut;
	private Button startseite;
	private ImageView home;
	private ComboBox<MapTypeIdEnum> mapTypeCombo;
	LatLong[] ary;
	private MainApp mainApp;
	private String gpxName;

	public Map(String gpxName) {

		this.gpxName = gpxName;
	}

	/**
	 * starts the representation of the map, defines the different buttons on the
	 * screen
	 * 
	 * @param stage
	 * @throws Exception
	 */
	public void startMap(Stage stage) throws Exception {

		mapComponent = new GoogleMapView();
		mapComponent.addMapInializedListener(this);

		BorderPane bp = new BorderPane();
		ToolBar tb = new ToolBar();

		btnZoomIn = new Button("Zoom In");
		btnZoomIn.setOnAction(e -> {
			map.zoomProperty().set(map.getZoom() + 2);		
		});
		btnZoomIn.setDisable(false);

		btnZoomOut = new Button("Zoom Out");
		btnZoomOut.setOnAction(e -> {
			map.zoomProperty().set(map.getZoom() - 2);
		});
		btnZoomOut.setDisable(false);

		startseite = new Button("Startseite");
		startseite.setDisable(false);
		startseite.setOnAction(e -> {
			mainApp.showHomepage();			// does not work!
		});
		
		mapTypeCombo = new ComboBox<>();
		mapTypeCombo.setOnAction(e -> {
			map.setMapType(mapTypeCombo.getSelectionModel().getSelectedItem());
		});

		mapTypeCombo.setDisable(false);
		mapTypeCombo.getItems().addAll(MapTypeIdEnum.ALL);

		Button btnType = new Button("Map type");
		btnType.setOnAction(e -> {
			map.setMapType(MapTypeIdEnum.HYBRID);
		});

		tb.getItems().addAll(startseite, btnZoomIn, btnZoomOut, mapTypeCombo);

		bp.setTop(tb);
		bp.setCenter(mapComponent);

		Scene scene = new Scene(bp);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * initializes the map with the route (GPX file is analyzed)
	 */
	@Override
	public void mapInitialized() {
		// Once the map has been loaded by the Webview, initialize the map
		// details.
		LatLong center = new LatLong(48.3058789, 14.2865628);

		MapOptions options = new MapOptions();
		options.center(center).mapMarker(true).zoom(5).overviewMapControl(false).panControl(false).rotateControl(false)
				.scaleControl(false).streetViewControl(false).zoomControl(false).mapType(MapTypeIdEnum.TERRAIN);

		map = mapComponent.createMap(options);

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

						ary[i] = markerLatLong1; 		// save coordinates in an array
					}

					LatLong markerLatLong = new LatLong(waypoints.get(0).getCoordinate().getLatitude(),
							waypoints.get(0).getCoordinate().getLongitude());

					Marker myMarker = new Marker(markerOptions);
					map.addMarker(myMarker); 			// add the first position as start
														// marker

					myMarker = new Marker(markerOptions);
					map.addMarker(myMarker); 			// add the latest position as end
														// marker

					MVCArray mvc = new MVCArray(ary);	 // converts the waypoints
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
	 * reference back to the mainApp
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {

		this.mainApp = mainApp;
	}
}
