import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;




import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Med1Controller implements Initializable {
	@FXML
	private TextField hospname;
	@FXML
	private TextField docketno;
	@FXML
	private Button docVerify;
	@FXML
	private AnchorPane bp;
	@FXML
	private AnchorPane dp;
	@FXML
	private TextArea patientAbs;
	@FXML
	private Button patUpload;
	@FXML
	private Button patVerify;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	
	

	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		assert docVerify != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
		assert patUpload != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
		// TODO Auto-generated method stub
		
	
	docVerify.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        @FXML
        public void handle(ActionEvent event)  {
        	String user=username.getText();
        	String pass=password.getText();
        	if(user.equals("joejacob4u")&&pass.equals("joe250156"))
        	{
        		
        		
        		System.out.println("Going to med2.fxml!");
                 bp.getChildren().clear();
            
            	
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("med2.fxml"));
				 Med2Controller controller=(Med2Controller) fxmlLoader.getController();
                  
				//Med2Controller med2=new Med2Controller();
				try {
					bp.getChildren().add((Node)fxmlLoader.load());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        	}
        	else
        	{
        		DialogFX dialog = new DialogFX();
		        dialog.setTitleText("Login Error!");
		        dialog.setMessage("Please check your username name and password.");
		        dialog.showDialog();

        	}
				         
				
			
        }
    });
	patVerify.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        @FXML
        public void handle(ActionEvent event)  {
        	String str=hospname.getText();
        	String str2=docketno.getText();
        	if(str.equalsIgnoreCase("St Johns Hospital") && str2.equals("0000"))
        	{
        		 System.out.println("Going to med2.fxml!");
                 dp.getChildren().clear();
                 
                 	
     				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("med3.fxml"));
     				 //Med2Controller controller=(Med2Controller) fxml2Loader.getController();
                       
     				//Med2Controller med2=new Med2Controller();
     				try {
     					dp.getChildren().add((Node)fxmlLoader.load());
     				} catch (IOException e) {
     					// TODO Auto-generated catch block
     					e.printStackTrace();
     				}
        	}
           
        	else
        	{
        		DialogFX dialog = new DialogFX();
		        dialog.setTitleText("Login Error!");
		        dialog.setMessage("Please check your hospital name and docket number.");
		        dialog.showDialog();
        	}
				
			
        }
    });
	
	

}}
