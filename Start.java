import java.util.logging.Level;
import java.util.logging.Logger;




import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class Start extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		Application.launch(Start.class, (java.lang.String[])null);
		// TODO Auto-generated method stub

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		 try {
	            
			     Parent root = FXMLLoader.load(getClass().getResource("med1.fxml"));
	            primaryStage.setScene(new Scene(root));
	            primaryStage.setTitle("MedAbstract");
	            Image ico = new Image("file:/Users/joejacob4u/Desktop/medicon.png");
	            primaryStage.getIcons().add(ico);
	            primaryStage.show();
	}
		 catch (Exception ex) {
	            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
	        }
		
	}
}
