package otrasPestanas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class ListControllerTutorial {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane rootLayout;
    @FXML
    private TreeView<String> tr2;


    @FXML
    void initialize() {
    	  TreeItem<String> rootItem = new TreeItem<String>("Tutorial");

          // item de primer nivel
          TreeItem<String> webItem = new TreeItem<String>("Pantallas");
          webItem.getChildren().add(new TreeItem<String>("Primera Pantalla"));
          webItem.getChildren().add(new TreeItem<String>("En la PRIMERA PANTALLA veremos el logo de la empresa y \n debajo suyo un botón de registrarse que nos lleva a otra página"
          		+ "con un formulario, en el MENUBAR encontramos los botones DONAR, MIEMBROS y AYUDA"));
          webItem.getChildren().add(new TreeItem<String>("DONAR"));
          webItem.getChildren().add(new TreeItem<String>("En esta página podremos elegir el animal al que apoyar,"
          		+ "\n la cantidad que queremos donar e informacion extra vista en un treeView"
          		+ " \n Al darle al botón de enviar nos saltara la primera alerta de si estamos seguros de querer hacer esa donación y si aceptamos iremos a la siguiente pagina que es la de miembros"));
          rootItem.getChildren().add(webItem);
          webItem.getChildren().add(new TreeItem<String>("MIEMBROS"));
          webItem.getChildren().add(new TreeItem<String>("En el menú miembros veremos una tabla donde principalmente sale vacía pero podemos añadir,modificar y borrar a los miembros"
          		+ "\n En el caso de que nos equivoquemos(por ejemplo olvidandonos un dato, o repitiendo una persona)  nos saltaran alertas al igual que al añadir,modificar y borrar"
          		+ "\n si pulsamos el boton de modificar(cuando la tabla esta vacia) nos cargar una tabla de miembros posteriormente a la alerta de que seleccionemos a alguien  "));
         
          
          // Otro item de primer nivel
          TreeItem<String> javaItem = new TreeItem<String>("Eventos");
          javaItem.getChildren().add(new TreeItem<String>("He creado un  filtro de evento de manera general en el main para que nos indique sobre lo que estamos pulsando"));
          rootItem.getChildren().add(javaItem);
          
        
          tr2.setCellFactory(TextFieldTreeCell.forTreeView());
          
          // Expadimos por defecto el item raiz
          rootItem.setExpanded(true); 
          tr2.setRoot(rootItem); 
	}
    

    public void start(Stage arg) throws Exception {
    	
    
}
}

