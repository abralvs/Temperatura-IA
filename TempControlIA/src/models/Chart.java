/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Color;
import java.text.DecimalFormat;
import net.sourceforge.jFuzzyLogic.defuzzifier.Defuzzifier;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierContinuous;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionDiscrete;
import net.sourceforge.jFuzzyLogic.plot.PlotWindow;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author igorb
 */
public class Chart {
    private DefaultCategoryDataset dsTemp;
    private CategoryPlot plotTemp;
    private int idTemp = 1;
    private JFreeChart chart;    
        
    public Chart(){  dsTemp = new DefaultCategoryDataset(); }
      
      
    public ChartPanel getChartInternTemp(Variable var){return pyramidChartCreate(var,5,5,410,210); }
    public ChartPanel getChartExternTemp(Variable var){return pyramidChartCreate(var,5,5,410,210);}
    public ChartPanel getChartRoomDimensions(Variable var){return pyramidChartCreate(var,5,5,410,210);}
    public ChartPanel getChartRoomOcupation(Variable var){return pyramidChartCreate(var,5,5,410,210);}
    public ChartPanel getChartDefuzzify(Variable var){return pyramidChartCreate(var,20,10,500,250);}
    
    
    private ChartPanel pyramidChartCreate(Variable var, int x, int y, int w, int l) {
		boolean discrete = true;
		boolean plotDefuzz = false;

		// Sanity check
		var.estimateUniverse();
		int numberOfPoints = PlotWindow.DEFAULT_CHART_NUMBER_OF_POINTS;
		double step = (var.getUniverseMax() - var.getUniverseMin()) / (numberOfPoints);

		// Create a data set
		XYSeriesCollection xyDataset = new XYSeriesCollection();

		//---
		// Current value
		//---
		double value = var.getValue();
		if (!Double.isNaN(value)) {
			XYSeries seriesValue = new XYSeries("Value");
			seriesValue.add(value - 2 * step, 0);
			seriesValue.add(value - step, 1);
			seriesValue.add(value, 1);
			seriesValue.add(value + step, 1);
			seriesValue.add(value + 2 * step, 0);
			xyDataset.addSeries(seriesValue);
		}

		//---
		// Plot deffuzyfier values (if any)
		//---
		Defuzzifier defuzzifier = var.getDefuzzifier();
		if ((defuzzifier != null) && (defuzzifier instanceof DefuzzifierContinuous)) {
			DefuzzifierContinuous def = (DefuzzifierContinuous) defuzzifier;

			// Title
			String title = String.format("%s:%2.2f (%s)", var.getName(), var.getLatestDefuzzifiedValue(), defuzzifier.getName());

			// Data points
			XYSeries series = new XYSeries(title);
			double values[] = def.getValues();
			numberOfPoints = values.length;
			double xx = def.getMin();
			step = (def.getMax() - def.getMin()) / (numberOfPoints);

			// Calculate values
			for (int i = 0; i < numberOfPoints; i++, xx += step)
				series.add(xx, values[i]);

			// Add serie to dataSet
			xyDataset.addSeries(series);
			plotDefuzz = true;
		}

		for (LinguisticTerm lt : var) {
			// Add this linguistic term to dataset
			MembershipFunction membershipFunction = lt.getMembershipFunction();
			discrete &= membershipFunction.isDiscrete();

			// Create a series and add points
			XYSeries series = new XYSeries(lt.getTermName());
			if (membershipFunction.isDiscrete()) {
				// Discrete case: Evaluate membership function and add points to dataset
				MembershipFunctionDiscrete membershipFunctionDiscrete = (MembershipFunctionDiscrete) membershipFunction;
				numberOfPoints = membershipFunctionDiscrete.size();
				for (int i = 0; i < numberOfPoints; i++)
					series.add(membershipFunctionDiscrete.valueX(i), membershipFunctionDiscrete.membership(i));
			} else {
				// Continuous case: Add every membershipfunction's point 
				numberOfPoints = PlotWindow.DEFAULT_CHART_NUMBER_OF_POINTS;
				double xx = var.getUniverseMin();
				for (int i = 0; i < numberOfPoints; i++, xx += step)
					series.add(xx, membershipFunction.membership(xx));
			}

			// Add serie to dataSet
			xyDataset.addSeries(series);
		}

		// Create chart and show it
		JFreeChart chart;
		if (!discrete) chart = ChartFactory.createXYAreaChart(var.getName(), "x", "Membership", xyDataset, PlotOrientation.VERTICAL, true, true, false);
		else chart = ChartFactory.createScatterPlot(var.getName(), "x", "Membership", xyDataset, PlotOrientation.VERTICAL, true, true, false);

		// Set 'Value' color to BLACK 
		XYPlot plot = chart.getXYPlot();
		plot.getRenderer().setSeriesPaint(0, Color.BLACK);
		// Set 'deffuzifier' color to GREY 
		if (plotDefuzz) plot.getRenderer().setSeriesPaint(1, Color.gray);

		// Show chart
		// if (showIt) DialogGraph.execute(chart);
                
                ChartPanel panel = new ChartPanel(chart);
                panel.setBounds(x,y,w,l); 
                 
                return panel;
    } 
     
    public ChartPanel lineChartCreate(String title, int x, int y){
        
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
}
