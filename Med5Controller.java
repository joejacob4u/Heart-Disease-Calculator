import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;


public class Med5Controller implements Initializable {
	@FXML
	ProgressBar progress;
	FXMLLoader fxmlLoader;
   
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//final ProgressBar bar = new ProgressBar();
		
	  
	    
		new Thread(new Runnable() {
		    @Override public void run() {
		        for (int i=1; i<=1000000; i++) {
		            final int counter = i;
		            Platform.runLater(new Runnable() {
		                @Override public void run() {
		                    progress.setProgress(counter/1000000.0);
		                }
		            });
		        }
		    }
		}).start();
		// TODO Auto-generated method stub
		
	}

}
