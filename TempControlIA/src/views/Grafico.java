package views;

import java.awt.Color;
import java.text.DecimalFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author igorb
 */

public class Grafico {
         

            
    public static DefaultCategoryDataset dsExterna;
    public static DefaultCategoryDataset dsInterna;
    public static CategoryPlot plotTempExterna;
    public static CategoryPlot plotTempInterna;
    public static int idTemp = 1;
    
     public ChartPanel geraGraficoTempExterna(DefaultCategoryDataset ds,String titulo){
        
        JFreeChart chart = ChartFactory.createLineChart(titulo, "", "", ds, PlotOrientation.VERTICAL, true, true, true);
        plotTempExterna = (CategoryPlot) chart.getPlot();
        
        // Colocando ponto no grafico
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plotTempExterna.getRenderer();
        renderer.setBaseShapesVisible(true);
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setBaseItemLabelsVisible(true);
        

        // Colocando numeração da temperatura no ponto do grafico
        final DecimalFormat format = new DecimalFormat("#0.##");
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", format));
       
        // Setando altura do grafico
        NumberAxis rangeAxis = (NumberAxis) plotTempExterna.getRangeAxis();
        rangeAxis.setRange(10, 50);
	rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        // setando cores do grafico
        plotTempExterna.setBackgroundPaint(Color.WHITE);
        //plot.setOutlinePaint(Color.WHITE);
        plotTempExterna.setRangeGridlinePaint(Color.WHITE);

     
        // criando o painel com o grafico de doencas
        ChartPanel panel = new ChartPanel(chart);
        panel.setBounds(280, 20, 350, 190);
        
        return panel;
    }
    
    
     public ChartPanel geraGraficoTempInterna(DefaultCategoryDataset ds,String titulo){
        
        JFreeChart chart = ChartFactory.createLineChart(titulo, "", "", ds, PlotOrientation.VERTICAL, true, true, true);
        plotTempInterna = (CategoryPlot) chart.getPlot();
        
        // Colocando ponto no grafico
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plotTempInterna.getRenderer();
        renderer.setBaseShapesVisible(true);
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setBaseItemLabelsVisible(true);
        

        // Colocando numeração da temperatura no ponto do grafico
        final DecimalFormat format = new DecimalFormat("#0.##");
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", format));
       
        // Setando altura do grafico
        NumberAxis rangeAxis = (NumberAxis) plotTempInterna.getRangeAxis();
        rangeAxis.setRange(10, 50);
	rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        // setando cores do grafico
        plotTempInterna.setBackgroundPaint(Color.WHITE);
        //plot.setOutlinePaint(Color.WHITE);
        plotTempInterna.setRangeGridlinePaint(Color.WHITE);
  
        // criando o painel com o grafico de doencas
        ChartPanel panel = new ChartPanel(chart);
        panel.setBounds(280, 50, 350, 190);
        
        return panel;
    }
}
