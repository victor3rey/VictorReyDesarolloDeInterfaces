package otrasPestanas;

import java.io.IOException;
import java.util.Optional;



import application.MenuController;
import javafx.application.Application;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ListController  extends Application{

    @FXML
    private ComboBox<String> combo1;
    
    @FXML
    private TableView<Person> table1;
    
    @FXML
    private TreeView<String> tree1;
    
    @FXML
  	private BorderPane rootLayout;

    @FXML
	private Text resultado;
    @FXML
	private TextField textField;
    
    @FXML
     Button myButton;
    @FXML
    ImageView myimageView;
    @FXML
    private Button botonenviame;
    
    Image Myimage = new Image(getClass().getResourceAsStream("/image/mono.jpg"));
    
    
    public void displayImage() {
        myimageView.setImage(Myimage);
        
    }
  
	
  
	@FXML
    private void initialize() {   
        // Controles de JavaFX a los que se a�aden directamente los items 
    	// items del ChoiceBox
		     
		
    	
        // items del ComboBox
        combo1.getItems().addAll("50", "100", "150", "200", "250", "500",
        		"1000", "1500", "2000");
                
      
    	
        // items para el TreeView
        // item raiz
        TreeItem<String> rootItem = new TreeItem<String>("ONG");

        // item de primer nivel
        TreeItem<String> webItem = new TreeItem<String>("Animales");
        webItem.getChildren().add(new TreeItem<String>("PANDA"));
        webItem.getChildren().add(new TreeItem<String>("El panda, es una especie de mamifero del orden de los carnivoros. "
        		+ "El estudio de su ADN lo engloba entre los miembros de la familia de los osos,siendo el oso de anteojos su pariente mas cercano, "
        		+ "que pertenece a la subfamilia de los tremarctinos"));
        webItem.getChildren().add(new TreeItem<String>("MONO DORADO"));
        webItem.getChildren().add(new TreeItem<String>("El langur chato dorado es una especie de primate catarrino"
        		+ " de la familia Cercopithecidae endimica de China"));
        rootItem.getChildren().add(webItem);
        
        // Otro item de primer nivel
        TreeItem<String> javaItem = new TreeItem<String>("Socios");
        javaItem.getChildren().add(new TreeItem<String>("extras de ser socios: se le permite la visita a las reservas donde estos animales estan protegidos"));
        rootItem.getChildren().add(javaItem);
        
        // Para que sea editable necesitamos especificar un CellFactory con el tipo que corresponda
        tree1.setCellFactory(TextFieldTreeCell.forTreeView());
        
        // Expadimos por defecto el item raiz
        rootItem.setExpanded(true); 
        tree1.setRoot(rootItem); 
        
        
    }
	
	@FXML
	private void enviardonacion() {
		
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmar donaci�n?");
		alert.setHeaderText("Responda la siguiente pregunta");
		alert.setContentText("�Esta seguro que quiere donar esta cantidad para este animal?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			// Cargamos el archivo Controles Dinamicos
			try {
				// Cargamos el archivo Controles Dinamicos
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MenuController.class.getResource("/otrasPestanas/pagina3.fxml"));
				BorderPane listadoControles = (BorderPane) loader.load();

				
				// Se situa en el centro del diseno principal
				rootLayout.setCenter(listadoControles);
			} catch (IOException e) {
				e.printStackTrace();
			}
		    // ... user chose OK
		} else {
		    // ... user chose CANCEL or closed the dialog
		}
		
	}

	@Override
	public void start(Stage arg) throws Exception {
		// TODO Auto-generated method stub
		
	}
    
    
}

