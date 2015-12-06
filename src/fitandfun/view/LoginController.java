package fitandfun.view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

import fitandfun.MainApp;
import fitandfun.model.User;

public class LoginController {

    // Reference to the main application.
    private MainApp mainApp;

    @FXML
    private ListView<User> userList;
   
    private User selectedUser;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public LoginController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	userList.setCellFactory(new Callback<ListView<User>, ListCell<User>>(){
    		@Override
    		public ListCell<User> call(ListView<User> param) {
    			return new ListCell<User>() {
    				@Override
    				protected void updateItem(User item, boolean empty) {
    					super.updateItem(item, empty);
    					this.textProperty().unbind();
    					this.setText("");
    					if (item != null) {
    						this.textProperty().bind(item.usernameProperty());
    					}
    				}
    			};
    		}
    	});
    	
    	userList.setOnMouseClicked(new EventHandler<MouseEvent>(){
    		@Override
    		public void handle(MouseEvent click)
    		{
    			if(click.getClickCount() == 2)
    			{
    				selectedUser = userList.getSelectionModel().getSelectedItem();
    				mainApp.setActiveUser(selectedUser);
    				showHomepage();
    			}	
    		}
    	});
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
       // userList.setItems(mainApp.getUserData());
        ObservableList<User> oldUsers = FXCollections.observableArrayList();
        for(User u:mainApp.getUserData())
        {
        	if(!u.getIsNew())
        	{
        		oldUsers.add(u);
        	}
        }
        userList.setItems(oldUsers);
    }
    
    @FXML
    private void showHomepage() {
    	mainApp.showHomepage();
    }
}
