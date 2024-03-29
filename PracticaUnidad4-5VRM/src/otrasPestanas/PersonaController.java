package otrasPestanas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class PersonaController implements Initializable {

    @FXML
    private Button btnAgregar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtdonacion;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEdad;
    @FXML
    private TableView<Persona> tblPersonas;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidos;
    @FXML
    private TableColumn colEdad;
    @FXML
    private TableColumn colemail;
    @FXML
    private TableColumn coldonacion;

    private ObservableList<Persona> personas;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;

    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public void initialize(URL url, ResourceBundle rb) {
        personas = FXCollections.observableArrayList();

        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        this.colEdad.setCellValueFactory(new PropertyValueFactory("edad"));
        this.colemail.setCellValueFactory(new PropertyValueFactory("email"));
        this.coldonacion.setCellValueFactory(new PropertyValueFactory("donacion"));
        
    }
    private ObservableList<Persona> data = FXCollections.observableArrayList(
    	    new Persona("Victor", "Rey",24, "victorrey@hotmail.com", 150),
    	    new Persona("Fernando", "Alonso",43, "Falonso@hotmail.com", 1000),
    	    new Persona("Serena", "Williams",35, "Serena.williams@gmail.com", 2000),
    	    new Persona("Emma", "Jones",43, "emma.jones@outlook.com", 3000),
    	    new Persona("Michael", "b.Jordan",25, "michaelb.Jordan@gmail.com", 3500)
    	    
    	);
    
    
    @FXML
    private void agregarPersona(ActionEvent event) {

        try {

            // Obtengo los datos del formulario
            String nombre = this.txtNombre.getText();
            String apellidos = this.txtApellidos.getText();
            int edad = Integer.parseInt(this.txtEdad.getText());
            String email= this.txtemail.getText();
            int donacion = Integer.parseInt(this.txtdonacion.getText());

            // Creo una persona
            Persona p = new Persona(nombre, apellidos, edad,email,donacion);

            // Compruebo si la persona esta en el lista
            if (!this.personas.contains(p)) {
                // Lo a�ado a la lista
                this.personas.add(p);
                // Seteo los items
                this.tblPersonas.setItems(personas);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Info");
                alert.setContentText("Persona anadida");
                alert.showAndWait();
            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("La persona existe");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }

    }
    

    @FXML
    private void seleccionar(MouseEvent event) {

        // Obtengo la persona seleccionada
        Persona p = this.tblPersonas.getSelectionModel().getSelectedItem();

        // Sino es nula reseteo los campos
        if (p != null) {
            this.txtNombre.setText(p.getNombre());
            this.txtApellidos.setText(p.getApellidos());
            this.txtEdad.setText(p.getEdad() + "");
            this.txtemail.setText(p.getEmail());
            this.txtdonacion.setText(p.getDonacion()+"");
        }

    }

    @FXML
    private void modificar(ActionEvent event) {

        // Obtengo la persona seleccionada
        Persona p = this.tblPersonas.getSelectionModel().getSelectedItem();

        // Si la persona es nula, lanzo error
        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        } else {

            try {
                // Obtengo los datos del formulario
                String nombre = this.txtNombre.getText();
                String apellidos = this.txtApellidos.getText();
                int edad = Integer.parseInt(this.txtEdad.getText());
                String email= this.txtemail.getText();
                int donacion = Integer.parseInt(this.txtdonacion.getText());


                // Creo una persona
                Persona aux = new Persona(nombre, apellidos, edad,email,donacion);

                // Compruebo si la persona esta en el lista
                if (!this.personas.contains(aux)) {

                    // Modifico el objeto
                    p.setNombre(aux.getNombre());
                    p.setApellidos(aux.getApellidos());
                    p.setEdad(aux.getEdad());
                    p.setEmail(aux.getEmail());
                    p.setDonacion(aux.getDonacion());

                    // Refresco la tabla
                    this.tblPersonas.refresh();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Info");
                    alert.setContentText("Persona modificada");
                    alert.showAndWait();

                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("La persona existe");
                    alert.showAndWait();
                }
            } catch (NumberFormatException e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Formato incorrecto");
                alert.showAndWait();
            }
            

        }
    
        
        tblPersonas.setItems(data);    
    }

    @FXML
    private void eliminar(ActionEvent event) {

        // Obtengo la persona seleccionada
        Persona p = this.tblPersonas.getSelectionModel().getSelectedItem();

        // Si la persona es nula, lanzo error
        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        } else {

            // La elimino de la lista
            this.personas.remove(p);
            // Refresco la lista
            this.tblPersonas.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Persona eliminada");
            alert.showAndWait();

        }
      

    }

}