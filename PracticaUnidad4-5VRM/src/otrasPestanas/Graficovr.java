package otrasPestanas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedAreaChart;
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
    private Button buttonBarChart;

    @FXML
    private Button buttonStackedAreaChart;

	   @FXML
	    private PieChart pieChart;

	   @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private BarChart<String, Number> barChart;
	    @FXML
	    private StackedAreaChart<Number, Number> stackedAreaChart;

	
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
	public ObservableList<XYChart.Series<String, Number>> loadDist1(){
		List<XYChart.Series<String, Number>> list = new ArrayList<XYChart.Series<String,Number>>();
	
		// Se crean dos series con datos
		XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
		series1.setName("Animales 1");
		  series1.setName("2021");
	        series1.getData().add(new XYChart.Data("Brasil", 25601.34));
	        series1.getData().add(new XYChart.Data("Canada", 20148.82));
	        series1.getData().add(new XYChart.Data("SriLanka", 10000));
	        series1.getData().add(new XYChart.Data("USA", 35407.15));
	        series1.getData().add(new XYChart.Data("Colombia", 11000));
        
		
		
		
		list.add(series1);
		
		
        return FXCollections.observableArrayList(list);
	}
	
	public ObservableList<XYChart.Series<Number, Number>> loadDist2(){
		List<XYChart.Series<Number, Number>> list = new ArrayList<XYChart.Series<Number,Number>>();
	
		// Se crean dos series con datos
		XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
		series1.setName("Web");
		series1.getData().add(new XYChart.Data<Number, Number>(2013, 5, 0.35));
		series1.getData().add(new XYChart.Data<Number, Number>(2014, 7, 0.35));
		series1.getData().add(new XYChart.Data<Number, Number>(2015, 6, 0.35));
		series1.getData().add(new XYChart.Data<Number, Number>(2016, 4, 0.25));
		series1.getData().add(new XYChart.Data<Number, Number>(2017, 8, 0.35));
		series1.getData().add(new XYChart.Data<Number, Number>(2018, 9, 0.35));
		series1.getData().add(new XYChart.Data<Number, Number>(2019, 3, 0.15));
		series1.getData().add(new XYChart.Data<Number, Number>(2020, 9, 0.5));
        
		// Se crean dos series con datos
		XYChart.Series<Number, Number> series2 = new XYChart.Series<Number, Number>();
		series2.setName("Multiplataforma");
		series2.getData().add(new XYChart.Data<Number, Number>(2013, 8, 0.35));
		series2.getData().add(new XYChart.Data<Number, Number>(2014, 5, 0.35));
		series2.getData().add(new XYChart.Data<Number, Number>(2015, 4, 0.25));
		series2.getData().add(new XYChart.Data<Number, Number>(2016, 7, 0.35));
		series2.getData().add(new XYChart.Data<Number, Number>(2017, 7, 0.35));
		series2.getData().add(new XYChart.Data<Number, Number>(2018, 5, 0.35));
		series2.getData().add(new XYChart.Data<Number, Number>(2019, 9, 0.5));
		series2.getData().add(new XYChart.Data<Number, Number>(2020, 4, 0.25));
		
		list.add(series1);
		list.add(series2);
		
        return FXCollections.observableArrayList(list);
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
	 @FXML
	    private void abrirBarChart(ActionEvent event) {
	    	try {
	    		// Se crea un nuevo diálogo para mostar el gráfico
	    		crearDialogo("/otrasPestanas/BarChart.fxml");

		        // Se pasa como parámetro el listado de calificaciones
		        Graficovr controller = ((FXMLLoader) this.loader).getController();
		        controller.setDist1(loadDist1());
		        controller.initBarChart();
		        
		        ((Stage) this.dialogStage).show();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	    }
	 @FXML
	    private void abrirStackedAreaChart(ActionEvent event) {
	    	try {
	    		// Se crea un nuevo diálogo para mostar el gráfico
	    		crearDialogo("/otrasPestanas/StackedAreaChart.fxml");

		        // Se pasa como parámetro el listado de calificaciones
		        Graficovr controller = ((FXMLLoader) this.loader).getController();
		        controller.setDist2(loadDist2());
		        controller.initStackedAreaChart();
		        
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
	 // Método para inicializar el BarChart
	    public void initBarChart() {
	    	barChart.setData(this.dist1);
	    }
	    
	 
	    
	    public void initStackedAreaChart() {
			stackedAreaChart.setData(this.dist2);
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
