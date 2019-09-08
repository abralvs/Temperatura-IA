package models;

import java.io.File;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 *
 * @author igorb
 */
public class TemperatureController {
    private EnvironmentConfiguration envConf;
    private FIS fis;
    private FunctionBlock fb;
    private Chart chart;
    
    public TemperatureController(EnvironmentConfiguration envConf) {
        this.fis = new FIS();
        this.envConf = envConf;
        this.chart = new Chart();
    }
    
    public void loadFile(){
        String filename = "src" + File.separatorChar + "logicafuzzy" + File.separatorChar + "logicaFuzzy.fcl";
        fis = FIS.load(filename, true);

        if (fis == null) {
            System.err.println("Can't load file: '" + filename + "'");
            System.exit(1);
        }
        
        if(envConf.getClassificacaoQtdPessoas() >= envConf.getLimInfPoucasPessoas() && envConf.getClassificacaoQtdPessoas() < envConf.getLimSupPoucasPessoas())
            envConf.setClassificacaoSala(0);
        else if(envConf.getClassificacaoQtdPessoas() >= envConf.getLimInfPoucasPessoas() && envConf.getClassificacaoQtdPessoas() < envConf.getLimSupNormal())
            envConf.setClassificacaoSala(1);
        else if(envConf.getClassificacaoQtdPessoas() >= envConf.getLimSupNormal() && envConf.getClassificacaoQtdPessoas() < envConf.getLimSupMuitasPessoas())
            envConf.setClassificacaoSala(2);
        
        fb = fis.getFunctionBlock(null);

        // Set inputs
        fb.setVariable("temperaturainterna", envConf.getInternTemp());
        fb.setVariable("tamanhosala", (envConf.getLength() * envConf.getWidth()));
        fb.setVariable("ocupacaosala", envConf.getClassificacaoSala());
        // Evaluate
        fb.evaluate();

        // Show output variable's chart
        fb.getVariable("temperaturaideal").defuzzify();
        
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
                
        //JFuzzyChart.get().chart(fb.getVariable("temperaturainterna"),true);
        //JFuzzyChart.get().chart(fb.getVariable("temperaturainterna"),true);
    }
   
    
        public void setFis(FIS fis) {
        this.fis = fis;
    }

    public void setEnvConf(EnvironmentConfiguration envConf) {
        this.envConf = envConf;
    }
    
    public void setFb(FunctionBlock fb) {
        this.fb = fb;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
    }

    public FIS getFis() {
        return fis;
    }

    public EnvironmentConfiguration getEnvConf() {
        return envConf;
    }

    public FunctionBlock getFb() {
        return fb;
    }

    public Chart getChart() {
        return chart;
    }
}
