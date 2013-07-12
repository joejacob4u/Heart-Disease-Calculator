import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class Med7Controller implements Initializable {
	@FXML 
	Button newbutton;
	@FXML
	AnchorPane errorpane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		newbutton.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        @FXML
	        public void handle(ActionEvent event)  {
	            System.out.println("Going to med2.fxml!");
	            errorpane.getChildren().clear();
	            
	            	
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("med3.fxml"));
					 Med2Controller controller=(Med2Controller) fxmlLoader.getController();
	                  
					//Med2Controller med2=new Med2Controller();
					try {
						errorpane.getChildren().add((Node)fxmlLoader.load());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					         
					
				
	        }
	    });
	}

}
