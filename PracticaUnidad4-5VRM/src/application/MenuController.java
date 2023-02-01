package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class MenuController {
	  
	
	// Pantalla principal en la que se añade o quita contenido
	private BorderPane rootLayout;
  
    @FXML
    private void initialize() {
        
    }
    
    @FXML
    private Button ButtonMenu;
  
     
    	  
    	 
    @FXML
    private void abrirFormulario(ActionEvent event) {    	
    	try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/otrasPestanas/pagina1.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    private void abrirFormulario2(ActionEvent event) {    	
    	try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/otrasPestanas/pagina2.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    private void abrirFormulario3(ActionEvent event) {    	
    	try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/otrasPestanas/pagina3.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    private void abrirFormulario4(ActionEvent event) {    	
    	try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/otrasPestanas/Tutorial.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    private void abrirFormulario5(ActionEvent event) {    	
    	try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/otrasPestanas/pagina4.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    private void cerrarListado(ActionEvent event) {    	
    	// Se elimina el contenido del nodo central
    	rootLayout.setCenter(null);	
    }

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}	
    
	void esconderControl (Control control) {
        control.setVisible(false);
        control.setManaged(false);
}
void mostrarControl (Control control) {
        control.setVisible(true);
        control.setManaged(true);
}
}
