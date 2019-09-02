/*
 * Testando a execução de um arquivo qualquer de logica fuzzy
 */
package models;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 *
 * @author igorb
 */

public class teste {
    public static void main(String[] args) throws Exception {
		String filename = "src\\logicafuzzy\\tipper.fcl";
		FIS fis = FIS.load(filename, true);

		if (fis == null) {
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}

		// Get default function block
		FunctionBlock fb = fis.getFunctionBlock(null);

		// Set inputs
		fb.setVariable("food", 8.5);
		fb.setVariable("service", 6.5);

		// Evaluate
		fb.evaluate();
                
		// Show output variable's chart
		fb.getVariable("tip").defuzzify();
                // Print ruleSet
		System.out.println(fb);
		System.out.println("Tip: " + fb.getVariable("tip").getValue()+"  "+fb.getVariables());
                
                
                JFuzzyChart.get().chart(fb);
                
                /*Geração dos graficos*/
                Variable tip = fb.getVariable("tip");
                JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true); 
    }
}
