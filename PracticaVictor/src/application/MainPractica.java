package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class MainPractica extends Application {
	private BorderPane rootLayout;	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el diseño del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainPractica.class.getResource("Menu.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Pasamos al controlador de menu el objeto con el BorderPane principal
			MenuController menuController = loader.getController();
			menuController.setRootLayout(rootLayout);

			// Mostramos la escena del BorderPane de la variable rootLayot
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ejemplo sobre controles");
			primaryStage.show();
			
			  StackPane root = new StackPane();
		        root.setId("pane");
		        scene.getStylesheets().addAll(this.getClass().getResource("Style.css").toExternalForm());
		        primaryStage.setScene(scene);
		        primaryStage.show();
		        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
