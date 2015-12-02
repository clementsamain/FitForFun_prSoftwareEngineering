package fitandfun.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import fitandfun.MainApp;

public class UserAdministrationController {

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public UserAdministrationController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	loadUserXML();
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
    
    @FXML
    private void showCreateNewUser() {
    	mainApp.showCreateNewUser();
    }
    
    private void loadUserXML()
    {
    	Alert a = new Alert(null);
    	a.show();
    }
}
