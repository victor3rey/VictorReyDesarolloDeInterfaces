package otrasPestanas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class Graficvr2 {
	// Variables para representar los datos de los diferentes gráficos
	private ObservableList<PieChart.Data> pieData;
	private ObservableList<XYChart.Series<String, Number>> dist1;
	private ObservableList<XYChart.Series<Number, Number>> dist2;
	

	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private PieChart pieChart;
	

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
