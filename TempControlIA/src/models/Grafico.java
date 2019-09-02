package models;

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
    private DefaultCategoryDataset dsTemp;
    private CategoryPlot plotTemp;
    private int idTemp = 1;
    private JFreeChart chart;
    
    
    public Grafico(){
        dsTemp = new DefaultCategoryDataset();
        
    }

    public void setDsTemp(DefaultCategoryDataset dsTemp) {
        this.dsTemp = dsTemp;
    }

    public void setPlotTemp(CategoryPlot plotTemp) {
        this.plotTemp = plotTemp;
    }

    public void setIdTemp(int idTemp) {
        this.idTemp = idTemp;
    }  
    
    public  DefaultCategoryDataset getDsTemp() {
        return dsTemp;
    }

    public CategoryPlot getPlotTemp() {
        return plotTemp;
    }

    public int getIdTemp() {
        return idTemp;
    }
     
    public ChartPanel generateChart(String title, int x, int y){
        
        chart = ChartFactory.createLineChart(title, "", "", dsTemp, PlotOrientation.VERTICAL, true, true, true);
        plotTemp = (CategoryPlot) chart.getPlot();
        
        // Colocando ponto no grafico
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plotTemp.getRenderer();
        renderer.setBaseShapesVisible(true);
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setBaseItemLabelsVisible(true);
        

        // Colocando numeração da temperatura no ponto do grafico
        final DecimalFormat format = new DecimalFormat("#0.##");
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", format));
       
        // Setando altura do grafico
        NumberAxis rangeAxis = (NumberAxis) plotTemp.getRangeAxis();
        rangeAxis.setRange(10, 50);
	rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        // setando cores do grafico
        plotTemp.setBackgroundPaint(Color.WHITE);
        //plot.setOutlinePaint(Color.WHITE);
        plotTemp.setRangeGridlinePaint(Color.WHITE);

     
        // criando o painel com o grafico de doencas
        ChartPanel panel = new ChartPanel(chart);
        panel.setBounds(x, y, 350, 190);
        
        return panel;
    } 
}
