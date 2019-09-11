package models;

import models.viewmodels.IdealTemperatureClassification;
import java.io.File;
import models.viewmodels.DimensionsRoomClassification;
import models.viewmodels.OcupationRoomClassification;
import models.viewmodels.TemperatureClassification;
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
        
        if(envConf.getNumberPeople() >= envConf.getLimInfPoucasPessoas() && envConf.getNumberPeople() < envConf.getLimSupPoucasPessoas())
            envConf.setClassificacaoQtdPessoas(0);
        else if(envConf.getNumberPeople() >= envConf.getLimInfPoucasPessoas() && envConf.getNumberPeople() < envConf.getLimSupNormal())
            envConf.setClassificacaoQtdPessoas(1);
        else if(envConf.getNumberPeople() >= envConf.getLimSupNormal() && envConf.getNumberPeople() < envConf.getLimSupMuitasPessoas())
            envConf.setClassificacaoQtdPessoas(2);
        
        fb = fis.getFunctionBlock(null);

        // Set inputs
        fb.setVariable("temperaturainterna", envConf.getInternTemp());
        fb.setVariable("tamanhosala", (envConf.getRoomDimension()));
        fb.setVariable("ocupacaosala", envConf.getClassificacaoQtdPessoas());
        // Evaluate
        fb.evaluate();

        // Show output variable's chart
        fb.getVariable("ajusteideal").defuzzify();
        
         // Show output variable's chart
        fb.getVariable("ajusteideal").defuzzify();
                
        float tempSetting;
        System.out.printf("ajusteideal:  %.2f \n\n", (tempSetting = (float)
                fb.getVariable("ajusteideal").getValue()));

    }
   
    public void setFis(FIS fis) {
        this.fis = fis;
    }
             
    public TemperatureClassification getTemperatureClassification(){ 
        String linguisticTerm = null;
        float relevance = 0;

        /*Geração dos graficos*/
        Variable classificacao = fb.getVariable("temperaturainterna");
        for (LinguisticTerm term : classificacao) {
            
            String termName = term.getTermName();            
            if(classificacao.getMembership(termName) > relevance) {
                relevance = (float) classificacao.getMembership(termName);
                linguisticTerm = termName;
            }
        }
        
        return (new TemperatureClassification(linguisticTerm,
           relevance, (float) fb.getVariable("temperaturainterna").getValue()));
    }
    
    
    public OcupationRoomClassification getOcupationRoomClassification(){
        
        String linguisticTerm = null;
        float relevance = 0;

        Variable classificacao = fb.getVariable("ocupacaosala");
        for (LinguisticTerm term : classificacao) {
            
            String termName = term.getTermName();            
            if(classificacao.getMembership(termName) > relevance) {
                relevance = (float) classificacao.getMembership(termName);
                linguisticTerm = termName;
            }
        }
        
        return (new OcupationRoomClassification(linguisticTerm,
           relevance, (float) envConf.getNumberPeople()));
    }
    
    
    public IdealTemperatureClassification getIdealTemperatureClassification(){
        
        String linguisticTerm = null;
        float relevance = 0;

        Variable classificacao = fb.getVariable("ajusteideal");
        for (LinguisticTerm term : classificacao) {
            
            String termName = term.getTermName();            
            if(classificacao.getMembership(termName) > relevance) {
                relevance = (float) classificacao.getMembership(termName);
                linguisticTerm = termName;
            }
        }
        
        return (new IdealTemperatureClassification(linguisticTerm,
           relevance, (float)fb.getVariable("ajusteideal").getValue()));
    }
    
    
    public DimensionsRoomClassification getDimensionsRoomClassification(){
        
        String linguisticTerm = null;
        float relevance = 0;

        Variable classificacao = fb.getVariable("tamanhosala");
        for (LinguisticTerm term : classificacao) {
            
            String termName = term.getTermName();            
            if(classificacao.getMembership(termName) > relevance) {
                relevance = (float) classificacao.getMembership(termName);
                linguisticTerm = termName;
            }
        }
        
        return (new DimensionsRoomClassification(linguisticTerm,
            relevance, (float)fb.getVariable("tamanhosala").getValue()));  
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
