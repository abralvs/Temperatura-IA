package models;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 *
 * @author igorb
 */
public class ControleDeTemperatura {
    public static void main(String[] args) throws Exception {
		String filename = "src\\logicafuzzy\\logicaFuzzy.fcl";
		FIS fis = FIS.load(filename, true);

		if (fis == null) {
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}

		// Get default function block
		FunctionBlock fb = fis.getFunctionBlock(null);

		// Set inputs
		fb.setVariable("temperatura", 29.5);
		fb.setVariable("tamanhosala", 99.0);

		// Evaluate
		fb.evaluate();
                
		// Show output variable's chart
		fb.getVariable("tempeaturideal").defuzzify();
                // Print ruleSet
		System.out.println(fb);
		System.out.println("tempeaturideal: " + fb.getVariable("tempeaturideal").getValue());  
                
                JFuzzyChart.get().chart(fb);
                
                /*Geração dos graficos*/
                Variable tip = fb.getVariable("tempeaturideal");
                JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true); 
    }
}