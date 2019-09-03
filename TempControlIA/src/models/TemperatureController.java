package models;

import java.io.File;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 *
 * @author igorb
 */
public class TemperatureController {
    public static void main(String[] args) throws Exception { 
        
        String filename = "src" + File.separatorChar + "logicafuzzy" + File.separatorChar + "logicaFuzzy.fcl";
        FIS fis = FIS.load(filename, true);

        if (fis == null) {
            System.err.println("Can't load file: '" + filename + "'");
            System.exit(1);
        }

        // Get default function block
        FunctionBlock fb = fis.getFunctionBlock(null);

        // Set inputs
        fb.setVariable("temperatura", 19);
        fb.setVariable("tamanhosala", 50.0);

        // Evaluate
        fb.evaluate();

        // Show output variable's chart
        fb.getVariable("temperaturaideal").defuzzify();
                
        float tempSetting;
        System.out.printf("temperaturaideal:  %.2f \n\n", (tempSetting = (float)
                fb.getVariable("temperaturaideal").getValue()));

        
        String linguisticTerm = null;
        float relevance = 0;

        /*Geração dos graficos*/
        Variable classificacao = fb.getVariable("temperaturaideal");
        for (LinguisticTerm term : classificacao) {
            
            String termName = term.getTermName();            
            if(classificacao.getMembership(termName) > relevance) {
                relevance = (float) classificacao.getMembership(termName);
                linguisticTerm = termName;
            }
        }
        
         /** 
         * Guarda informações sobre a temperatura ideal(termo linguistico, 
         * quantidade de graus a serem atualizados pelo ar condicionado e 
         * grau de pertinencia) 
         **/
        IdealTemperature idealTemp = new IdealTemperature(linguisticTerm,relevance,tempSetting);
        
        
        System.out.println("\nTermo: "+idealTemp.getLinguisticTerm()
                         +"\nGrau de Pertinencia: "+idealTemp.getRelevance()
                         +"\nAjustar temperatura em: "+idealTemp.getTemperatureSetting()); 
                
        //JFuzzyChart.get().chart(fb);
        //JFuzzyChart.get().chart(classificacao, tip.getDefuzzifier(), true); 
    }
}
