package models;

import java.io.File;
import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
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

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe a quantidade de pessoas na sala: ");
        int qtdPessoas = scan.nextInt();

        System.out.println("Informe o comprimento da sala (em metros): ");
        double cSala = scan.nextDouble();

        System.out.println("Informe a largura da sala (em metros): ");
        double lSala = scan.nextDouble();

        //--------------------------------------------------------------------------------------------------------------
        //                                             cálculo classificacao sala                                     //

        //limites inferiores e superiores da classficacao de sala, muitas pessoas, normal e poucas
        double limInfPoucasPessoas      = 0,
                limSupPoucasPessoas     = (lSala * cSala)*0.25,
                limInfNormal            = limSupPoucasPessoas,
                limSupNormal            = (lSala * cSala) * 0.5,
                limInfMuitasPessoas     = limSupNormal,
                limSupMuitasPessoas     = (lSala * cSala);

        int classificacaoSala = -1;  // poucas pessoas =  0, normal = 1, muitas pesssoas = 2;

        if(qtdPessoas >= limInfPoucasPessoas && qtdPessoas < limSupPoucasPessoas)
            classificacaoSala = 0;
        else if(qtdPessoas >= limInfPoucasPessoas && qtdPessoas < limSupNormal)
            classificacaoSala = 1;
        else if(qtdPessoas >= limSupNormal && qtdPessoas < limSupMuitasPessoas)
            classificacaoSala = 2;

        //--------------------------------------------------------------------------------------------------------------

        // Get default function block
        FunctionBlock fb = fis.getFunctionBlock(null);

        // Set inputs
        fb.setVariable("temperaturainterna", 25);
        fb.setVariable("tamanhosala", (cSala * lSala));
        fb.setVariable("ocupacaosala", classificacaoSala);
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
