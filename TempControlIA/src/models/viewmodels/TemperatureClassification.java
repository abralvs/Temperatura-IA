/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.viewmodels;

/**
 *
 * @author igorb
 */
public class TemperatureClassification {
    private String linguisticTerm;
    private double relevance;
    private double temperatureSetting;

    public TemperatureClassification(String linguisticTerm, double relevance, double temperatureSetting) {
        this.linguisticTerm = linguisticTerm;
        this.relevance = relevance;
        this.temperatureSetting = temperatureSetting;
    }

    public TemperatureClassification() {}

    public String getLinguisticTerm() {
        return linguisticTerm;
    }

    public double getRelevance() {
        return relevance;
    }

    public double getTemperatureSetting() {
        return temperatureSetting;
    }

    public void setLinguisticTerm(String linguisticTerm) {
        this.linguisticTerm = linguisticTerm;
    }

    public void setRelevance(double relevance) {
        this.relevance = relevance;
    }

    public void setTemperatureSetting(double temperatureSetting) {
        this.temperatureSetting = temperatureSetting;
    }   
}
