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
public class DimensionsRoomClassification {
    private String linguisticTerm;
    private double relevance;
    private double dimensionSetting;

    public DimensionsRoomClassification(String linguisticTerm, double relevance, double dimensionSetting) {
        this.linguisticTerm = linguisticTerm;
        this.relevance = relevance;
        this.dimensionSetting = dimensionSetting;
    }

    public DimensionsRoomClassification() {}
    
    

    public String getLinguisticTerm() {
        return linguisticTerm;
    }

    public double getRelevance() {
        return relevance;
    }

    public double getDimensionSetting() {
        return dimensionSetting;
    }

    public void setLinguisticTerm(String linguisticTerm) {
        this.linguisticTerm = linguisticTerm;
    }

    public void setRelevance(double relevance) {
        this.relevance = relevance;
    }

    public void setDimensionSetting(double dimensionSetting) {
        this.dimensionSetting = dimensionSetting;
    }  
}
