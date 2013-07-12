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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;


public class Med3Controller implements Initializable {
@FXML
private TextArea patAbs;
@FXML
private Button docButton;
@FXML
private Label patTip;
@FXML
private AnchorPane med3pane;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		docButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
		    @Override public void handle(MouseEvent e) {
		        docButton.setText("Click to Upload!");
		        docButton.setStyle("-fx-background-color:#72EA9C");
		    }
		});
		docButton.setOnMouseExited(new EventHandler<MouseEvent>() {
		    @Override public void handle(MouseEvent e) {
		        docButton.setStyle("-fx-background-color:linear-gradient(#f0ff35, #a9ff00), radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);-fx-background-radius: 6, 5;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-text-fill: #395306;");
		    }
		});
		// TODO Auto-generated method stub
		docButton.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        @FXML
	        public void handle(ActionEvent event)  {
	        	patTip.setText("Please wait.This will take a minute.");
	        	String text=patAbs.getText();
	        	CoreNlp core=new CoreNlp();
	        	
	        	try {
					String res=core.addString(text, 1);
					if(res.contains("ok"))
					{
						patTip.setText("Good to go!");
						patTip.setTextFill(Color.web("#16CD41"));
						Weka weka=new Weka();
						double pred=weka.start();
						if(pred==1)
						{
							 med3pane.getChildren().clear();
					            
				            	
								FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("med7.fxml"));
								 //Med2Controller controller=(Med2Controller) fxmlLoader.getController();
				                  
								//Med2Controller med2=new Med2Controller();
								try {
									med3pane.getChildren().add((Node)fxmlLoader.load());
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						}
						else
						{
							med3pane.getChildren().clear();
				            
			            	
							FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("med8.fxml"));
							 //Med2Controller controller=(Med2Controller) fxmlLoader.getController();
			                  
							//Med2Controller med2=new Med2Controller();
							try {
								med3pane.getChildren().add((Node)fxmlLoader.load());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					if(res.contains("cholError"))
					{
						patTip.setText("Please enter a appropriate cholesterol range below:");
						patTip.setTextFill(Color.web("#E30141"));
					}
					if(res.contains("pressError"))
					{
						patTip.setText("Please enter a appropriate pressure range:");
						patTip.setTextFill(Color.web("#E30141"));
					}
					if(res.contains("sugarError"))
					{
						patTip.setText("Please enter a appropriate sugar range:");
						patTip.setTextFill(Color.web("#E30141"));
					}
					if(res.contains("ageNull"))
					{
						patTip.setText("You forgot to mention your age:");
						patTip.setTextFill(Color.web("#E30141"));
					}
					if(res.contains("sugarNull"))
					{
						patTip.setText("You forgot to mention your sugar level");
						patTip.setTextFill(Color.web("#E30141"));
					}
					if(res.contains("cholNull"))
					{
						patTip.setText("You forgot to mention your cholesterol level:");
						patTip.setTextFill(Color.web("#E30141"));
					}
					if(res.contains("pressNull"))
					{
						patTip.setText("You forgot to mention your pressure level:");
						patTip.setTextFill(Color.web("#E30141"));
					}
					
					if(res.contains("noSex"))
					{
						patTip.setText("You forgot to mention your sex:");
						patTip.setTextFill(Color.web("#E30141"));
					}
					if(res.contains("noAge"))
					{
						patTip.setText("You forgot to mention your age:");
						patTip.setTextFill(Color.web("#E30141"));
					}
					if(res.contains("heartNull"))
					{
						patTip.setText("You forgot to mention your heart beat rate:");
						patTip.setTextFill(Color.web("#E30141"));
					}
					if(res.contains("wrongBeat"))
					{
						patTip.setText("Please enter an appropriate beat rate:");
						patTip.setTextFill(Color.web("#E30141"));
					}
					if(res.contains("chestError"))
					{
						patTip.setText("Please enter your chest pain type:");
						patTip.setTextFill(Color.web("#E30141"));
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
					         
					
				
	        }
	    });
		
	}

}
