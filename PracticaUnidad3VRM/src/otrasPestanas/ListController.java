package otrasPestanas;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;

public class ListController  extends Application{

    @FXML
    private ComboBox<String> combo1;
    
    @FXML
    private TableView<Person> table1;
    
    @FXML
    private TreeView<String> tree1;
    
    
    
   
    
    @FXML
     Button myButton;
    @FXML
    ImageView myimageView;
    
    Image Myimage = new Image(getClass().getResourceAsStream("/image/mono.jpg"));
    
    
    public void displayImage() {
        myimageView.setImage(Myimage);
        
    }
    
  
	@FXML
    private void initialize() {   
        // Controles de JavaFX a los que se añaden directamente los items 
    	// items del ChoiceBox
    
    	
        // items del ComboBox
        combo1.getItems().addAll("50€", "100€", "150€", "200€", "250€", "500€",
        		"1000€", "1500€", "2000€");
                
      
        
        // items para el TreeView
        // item raiz
        TreeItem<String> rootItem = new TreeItem<String>("ONG");

        // item de primer nivel
        TreeItem<String> webItem = new TreeItem<String>("Animales");
        webItem.getChildren().add(new TreeItem<String>("PANDA"));
        webItem.getChildren().add(new TreeItem<String>("El panda, es una especie de mamífero del orden de los carnívoros. "
        		+ "El estudio de su ADN lo engloba entre los miembros de la familia de los osos,siendo el oso de anteojos su pariente más cercano, "
        		+ "que pertenece a la subfamilia de los tremarctinos"));
        webItem.getChildren().add(new TreeItem<String>("MONO DORADO"));
        webItem.getChildren().add(new TreeItem<String>("El langur chato dorado es una especie de primate catarrino"
        		+ " de la familia Cercopithecidae endémica de China"));
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
  

	@Override
	public void start(Stage arg) throws Exception {
		// TODO Auto-generated method stub
		
	}
    
    
}

