package models;

/**
 *
 * @author igorb
 */
public class IdealTemperature {
    private String linguisticTerm;
    private float relevance;
    private float temperatureSetting;

    public IdealTemperature() {}
    
    public IdealTemperature(String linguisticTerm, float relevance, float temperatureSetting) {
        this.linguisticTerm = linguisticTerm;
        this.relevance = relevance;
        this.temperatureSetting = temperatureSetting;
    }

    public String getLinguisticTerm() {
        return linguisticTerm;
    }

    public float getRelevance() {
        return relevance;
    }

    public float getTemperatureSetting() {
        return temperatureSetting;
    }

    public void setLinguisticTerm(String linguisticTerm) {
        this.linguisticTerm = linguisticTerm;
    }

    public void setRelevance(float relevance) {
        this.relevance = relevance;
    }

    public void setTemperatureStting(float temperatureSetting) {
        this.temperatureSetting = temperatureSetting;
    } 
}
