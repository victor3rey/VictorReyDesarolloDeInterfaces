package otrasPestanas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.Chart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Graficovr {

	 private Object loader;
	private Object dialogStage;

	@FXML
		private void initialize() {
			
		}

    @FXML
    private Button PieChartButton;
	   @FXML
	    private PieChart pieChart;

	   @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	  

	
	public ObservableList<PieChart.Data> loadPieData(){
		// Rellenamos los datos del gráfico
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("DIW", 7),
                new PieChart.Data("DI", 6),
                new PieChart.Data("PSP", 8),
                new PieChart.Data("PDM", 5),
                new PieChart.Data("AD", 6),
                new PieChart.Data("SGE", 4),
                new PieChart.Data("DWEC", 10),
                new PieChart.Data("DWES", 3));
		
		return pieChartData;
	}
	
	 @FXML
	    private void abrirPieChart(ActionEvent event) {
	    	try {
	    		// Se crea un nuevo diálogo para mostar el gráfico
	    		crearDialogo("/otrasPestanas/PieChart.fxml");

		        // Se pasa como parámetro el listado de calificaciones
	    		 Graficovr controller = ((FXMLLoader) this.loader).getController();
		        controller.setPieData(loadPieData());
		        controller.initPieChart();
		        
		        ((Stage) this.dialogStage).show();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }    	
	    }

	 private void crearDialogo(String ruta) throws IOException {
	    	// Carga el fichero XML con el pop up de las estadísticas
	        this.loader = new FXMLLoader();
	        ((FXMLLoader) this.loader).setLocation(Graficovr.class.getResource(ruta));
	        
	        // Se carga el diálogo en el objeto Scene y posteriormente en Stage
	        AnchorPane page = (AnchorPane) ((FXMLLoader) loader).load();
	        this.dialogStage = new Stage();
	        ((Stage) this.dialogStage).setTitle("Estadísticas de calificaciones");
	        ((Stage) this.dialogStage).initModality(Modality.APPLICATION_MODAL);
	        
	        Scene scene = new Scene(page);
	        ((Stage) this.dialogStage).setScene(scene);    	
	    }
	 private ObservableList<PieChart.Data> pieData;
		private ObservableList<XYChart.Series<String, Number>> dist1;
		private ObservableList<XYChart.Series<Number, Number>> dist2;
		

		   
		

	    // Método para inicializar el PieChart
	    public void initPieChart() {
			pieChart.setData(pieData);
			
			// Se muestra en cada etiqueta el valor
			for (final PieChart.Data data : pieChart.getData()) {
			    data.setName(data.getName() + "=" + data.getPieValue());
			}
	    }
	    
	    
	               
		public ObservableList<PieChart.Data> getPieData() {
			return pieData;
		}


		public void setPieData(ObservableList<PieChart.Data> pieData) {
			this.pieData = pieData;
		}

		public ObservableList<XYChart.Series<String, Number>> getDist1() {
			return dist1;
		}

		public void setDist1(ObservableList<XYChart.Series<String, Number>> dist1) {
			this.dist1 = dist1;
		}

		public ObservableList<XYChart.Series<Number, Number>> getDist2() {
			return dist2;
		}

		public void setDist2(ObservableList<XYChart.Series<Number, Number>> dist2) {
			this.dist2 = dist2;
		}

		public PieChart getPieChart() {
			return pieChart;
		}

		public void setPieChart(PieChart pieChart) {
			this.pieChart = pieChart;
		}

	}
