package basicoDinamico;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTreeCell;

public class ListController {

    
  

    @FXML
    private ListView<String> list1;
    
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
    	    new Person("Victor", "Rey", "victorrey@hotmail.com", 30),
    	    new Person("Fernando", "Alonso", "Falonso@hotmail.com", 40),
    	    new Person("Serena", "Williams", "Serena.williams@gmail.com", 50),
    	    new Person("Emma", "Jones", "emma.jones@outlook.com", 61),
    	    new Person("Michael", "b.Jordan", "michaelb.Jordan@gmail.com", 34)
    	);

    @FXML
    private void initialize() {   
        // Controles de JavaFX a los que se a�aden directamente los items 
    	// items del ChoiceBox
    
        // items del ComboBox
        combo1.getItems().addAll("Combo1", "Combo2", "Combo3", "Combo4", "Combo5", "Combo6",
        		"Combo7", "Combo8", "Combo9");
                
        // items del ListView (con la segunda linea se asigna un CellFactory para permitir que sean editables)
        list1.getItems().addAll("Lista1", "Lista2", "Lista3");
        list1.setCellFactory(TextFieldListCell.forListView());
        // Para seleccionar mas de un item a la vez
        list1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        // Asociamos cada columna del TableView a una propiedad de la clase Person 
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person,String>("Nombre"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person,String>("Apellido"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Person,String>("email"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Person,Integer>("Edad"));
        // Se rellena la tabla con objetos de la clase Person
        table1.setItems(data);     
        
        
        // items para el TreeView
        // item raiz
        TreeItem<String> rootItem = new TreeItem<String>("Tutorials");

        // item de primer nivel
        TreeItem<String> webItem = new TreeItem<String>("Web Tutorials");
        webItem.getChildren().add(new TreeItem<String>("HTML  Tutorial"));
        webItem.getChildren().add(new TreeItem<String>("HTML5 Tutorial"));
        webItem.getChildren().add(new TreeItem<String>("CSS Tutorial"));
        webItem.getChildren().add(new TreeItem<String>("SVG Tutorial"));
        rootItem.getChildren().add(webItem);
        
        // Otro item de primer nivel
        TreeItem<String> javaItem = new TreeItem<String>("Java Tutorials");
        javaItem.getChildren().add(new TreeItem<String>("Java Language"));
        javaItem.getChildren().add(new TreeItem<String>("Java Collections"));
        javaItem.getChildren().add(new TreeItem<String>("Java Concurrency"));
        rootItem.getChildren().add(javaItem);
        
        // Para que sea editable necesitamos especificar un CellFactory con el tipo que corresponda
        tree1.setCellFactory(TextFieldTreeCell.forTreeView());
        
        // Expadimos por defecto el item raiz
        rootItem.setExpanded(true); 
        tree1.setRoot(rootItem);               
    }
    
}
