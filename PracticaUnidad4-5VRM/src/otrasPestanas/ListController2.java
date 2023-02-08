package otrasPestanas;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.MenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class ListController2 {
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button myButton;

    @FXML
    private ImageView myimageView;

    @FXML
    private Button registrarsebutton;
    @FXML
	private BorderPane rootLayout;

    @FXML
    private void abrirFormulario(ActionEvent event)  {
    	
    	try {
			// Cargamos el archivo Controles Dinamicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/otrasPestanas/pagina1.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();

			// Se situa en el centro del diseno principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    	

    @FXML
    void displayImage(ActionEvent event) {
    	 Image Myimage = new Image(getClass().getResourceAsStream("/image/icono2.png"));
    	 myimageView.setImage(Myimage);  
    	    
    }

    @FXML
    void initialize() {
    
    }
    public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}	
    
}


