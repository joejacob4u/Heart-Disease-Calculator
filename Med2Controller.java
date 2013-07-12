import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;


import com.asprise.util.ocr.OCR;
import com.sun.media.jfxmedia.logging.Logger;
import com.sun.prism.paint.Paint.Type;



import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.concurrent.Task;

public class Med2Controller implements Initializable {
	@FXML
	private TextArea patientAbs;
	@FXML
	private Button patUpload;
	@FXML
	private Button file;
	@FXML
	private Button Camera;
	@FXML
	public Label patLabel;
	@FXML
	public ProgressIndicator pi=new ProgressIndicator();
	@FXML
	AnchorPane patPane;
	public void setLabel(String str)
	{
		this.patLabel.setText(str);
	}
	Stage primaryStage;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TODO Auto-generated method stub
		patUpload.setOnMouseEntered(new EventHandler<MouseEvent>() {
		    @Override public void handle(MouseEvent e) {
		        patUpload.setText("Click to Upload!");
		        patUpload.setStyle("-fx-background-color:#72EA9C");
		    }
		});
		patUpload.setOnMouseExited(new EventHandler<MouseEvent>() {
		    @Override public void handle(MouseEvent e) {
		        patUpload.setStyle("-fx-background-color:linear-gradient(#f0ff35, #a9ff00), radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);-fx-background-radius: 6, 5;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-text-fill: #395306;");
		    }
		});
       
    
   
    
    
		    
		
		patUpload.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        @FXML
	        public void handle(ActionEvent event)  {
	            	
	           	
	        	
				//pi.progressProperty().bind(task.progressProperty());
				//new Thread(task).start();
				
	            	
	            	
					String abs=patientAbs.getText();
					if(abs.length()>0)
					{ 
					
						
					
						CoreNlp nlp=new CoreNlp();
						try {
							
							String res=nlp.addString(abs,0);
							
							if(res.contains("ok"))
							{
								DialogFX dialog = new DialogFX();
						        dialog.setTitleText("Thanks");
						        dialog.setMessage("Successfully stored in the database!");
						        dialog.showDialog();
						        patientAbs.setText("");
							}
							if(res.contains("cholError"))
							{
								patLabel.setText("Please enter a appropriate cholesterol range below:");
								patLabel.setTextFill(Color.web("#E30141"));
							}
							if(res.contains("pressError"))
							{
								patLabel.setText("Please enter a appropriate pressure range:");
								patLabel.setTextFill(Color.web("#E30141"));
							}
							if(res.contains("sugarError"))
							{
								patLabel.setText("Please enter a appropriate sugar range:");
								patLabel.setTextFill(Color.web("#E30141"));
							}
							if(res.contains("sugarNull"))
							{
								patLabel.setText("You forgot to mention your sugar level");
								patLabel.setTextFill(Color.web("#E30141"));
							}
							if(res.contains("cholNull"))
							{
								patLabel.setText("You forgot to mention your cholesterol level:");
								patLabel.setTextFill(Color.web("#E30141"));
							}
							if(res.contains("ageNull"))
							{
								patLabel.setText("You forgot to mention your age:");
								patLabel.setTextFill(Color.web("#E30141"));
							}
							if(res.contains("pressNull"))
							{
								patLabel.setText("You forgot to mention your pressure level:");
								patLabel.setTextFill(Color.web("#E30141"));
							}
							
							if(res.contains("noSex"))
							{
								patLabel.setText("You forgot to mention your sex:");
								patLabel.setTextFill(Color.web("#E30141"));
							}
							if(res.contains("noAge"))
							{
								patLabel.setText("You forgot to mention your age:");
								patLabel.setTextFill(Color.web("#E30141"));
							}
							if(res.contains("heartNull"))
							{
								patLabel.setText("You forgot to mention your heart beat rate:");
								patLabel.setTextFill(Color.web("#E30141"));
							}
							if(res.contains("wrongBeat"))
							{
								patLabel.setText("Please enter an appropriate beat rate:");
								patLabel.setTextFill(Color.web("#E30141"));
							}
							if(res.contains("chestError"))
							{
								patLabel.setText("Please enter your chest pain type:");
								patLabel.setTextFill(Color.web("#E30141"));
							}
							if(res.contains("diseaseNull"))
							{
								patLabel.setText("Please enter test result::");
								patLabel.setTextFill(Color.web("#E30141"));
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					else
					{
						DialogFX dialog = new DialogFX();
				        dialog.setTitleText("No Abstract");
				        dialog.setMessage("Please write something about yourself.");
				        dialog.showDialog();
						

						
					}  
	        }
	    });
		file.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        @FXML
	        public void handle(ActionEvent event)  {
	        	FileChooser fileChooser = new FileChooser();
                
                //Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                 
                //Show save file dialog
                File file = fileChooser.showOpenDialog(primaryStage);
                if(file != null){
                    patientAbs.setText(readFile(file));
	        }
	        }});
		Camera.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        @FXML
	        public void handle(ActionEvent event)  {
	        	Camera cam=new Camera();
	        	try {
					boolean bool=cam.setStart();
					if(bool==true)
					{
						String result=readOCR();
						patLabel.setText(result);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	       
	        }
		          
		          
	        });
		}
	
	    private String readOCR() throws IOException
	    {
	    	BufferedImage image = ImageIO.read(new File("/Users/joejacob4u/Box/Box Documents/Projects/MedAbstract/test1.jpg"));
			
			 // recognizes both characters and barcodes
			String s = new OCR().recognizeCharacters(image);
			
			 // prints the results.
			System.out.println("RESULTS: \n"+ s);
			return s;
	    }
		
		private String readFile(File file){
	        StringBuilder stringBuffer = new StringBuilder();
	        BufferedReader bufferedReader = null;
	         
	        try {
	 
	            bufferedReader = new BufferedReader(new FileReader(file));
	             
	            String text;
	            while ((text = bufferedReader.readLine()) != null) {
	                stringBuffer.append(text);
	            }
	 
	        } catch (FileNotFoundException ex) {
	            
	        } catch (IOException ex) {
	            
	        } finally {
	            try {
	                bufferedReader.close();
	            } catch (IOException ex) {
	                
	            }
	        } 
	         
	        return stringBuffer.toString();
	    }
	
	
	
	
	
}
