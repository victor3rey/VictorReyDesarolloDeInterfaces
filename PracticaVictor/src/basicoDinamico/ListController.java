package basicoDinamico;

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
    private TableColumn<Person, String> firstNameCol;

    @FXML
    private TableColumn<Person, String> lastNameCol;

    @FXML
    private TableColumn<Person, String> emailCol;
    
    @FXML
    private TableColumn<Person, Integer> ageColumn;
    
    @FXML
    private TreeView<String> tree1;
    
    
    
   
     // Lista auxiliar para TableView
    private ObservableList<Person> data = FXCollections.observableArrayList(
    	    new Person("Victor", "Rey", "victorrey@hotmail.com", 150),
    	    new Person("Fernando", "Alonso", "Falonso@hotmail.com", 1000),
    	    new Person("Serena", "Williams", "Serena.williams@gmail.com", 2000),
    	    new Person("Emma", "Jones", "emma.jones@outlook.com", 3000),
    	    new Person("Michael", "b.Jordan", "michaelb.Jordan@gmail.com", 3500)
    	);
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
                
       
        
     
        
       
        
        
       
       
        // Asociamos cada columna del TableView a una propiedad de la clase Person 
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person,String>("Nombre"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person,String>("Apellido"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Person,String>("email"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Person,Integer>("Donacion"));
        // Se rellena la tabla con objetos de la clase Person
        table1.setItems(data);     
        
        
        // items para el TreeView
        // item raiz
        TreeItem<String> rootItem = new TreeItem<String>("ONG");

        // item de primer nivel
        TreeItem<String> webItem = new TreeItem<String>("Animales");
        webItem.getChildren().add(new TreeItem<String>("Panda"));
        webItem.getChildren().add(new TreeItem<String>("Mono Dorado"));
        rootItem.getChildren().add(webItem);
        
        // Otro item de primer nivel
        TreeItem<String> javaItem = new TreeItem<String>("Socios");
        javaItem.getChildren().add(new TreeItem<String>("extras de ser socios"));
        javaItem.getChildren().add(new TreeItem<String>("donaciones"));
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

