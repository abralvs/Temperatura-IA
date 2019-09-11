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
public class OcupationRoomClassification {
    private String linguisticTerm;
    private float relevance;
    private float ocupationSetting;

    public OcupationRoomClassification(String linguisticTerm, float relevance, float ocupationSetting) {
        this.linguisticTerm = linguisticTerm;
        this.relevance = relevance;
        this.ocupationSetting = ocupationSetting;
    }

    public String getLinguisticTerm() {
        return linguisticTerm;
    }

    public float getRelevance() {
        return relevance;
    }

    public float getOcupationSetting() {
        return ocupationSetting;
    }

    public void setLinguisticTerm(String linguisticTerm) {
        this.linguisticTerm = linguisticTerm;
    }

    public void setRelevance(float relevance) {
        this.relevance = relevance;
    }

    public void setOcupationSetting(float ocupationSetting) {
        this.ocupationSetting = ocupationSetting;
    }
}
