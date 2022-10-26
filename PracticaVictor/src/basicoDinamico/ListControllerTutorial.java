package basicoDinamico;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class ListControllerTutorial {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imagentutorial;

    @FXML
    private BorderPane rootLayout;

    @FXML
    void initialize() {
    
    }

    public void start(Stage arg) throws Exception {
		// TODO Auto-generated method stub
    	 Image image = new Image(new FileInputStream("/image/tutorial.PNG"));
    			 ImageView imageView = new ImageView(image); 
	}
    
}


