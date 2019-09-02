/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.JSpinner;

/**
 *
 * @author igorb
 */
public class EnvironmentConfiguration {
    private float width;
    private float length;
    private float externTemp;
    private float internTemp;
    private int numberPeople;
    
    
    public EnvironmentConfiguration(){}

    public EnvironmentConfiguration(float width, float length, float externTemp, float internTemp, int numberPeople) {
        this.width = width;
        this.length = length;
        this.externTemp = externTemp;
        this.internTemp = internTemp;
        this.numberPeople = numberPeople;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void setExternTemp(float externTemp) {
        this.externTemp = externTemp;
    }

    public void setInternTemp(float internTemp) {
        this.internTemp = internTemp;
    }

    public void setNumberPeople(int numberPeople) {
        this.numberPeople = numberPeople;
    }   

    public float getWidth() {
        return width;
    }

    public float getLength() {
        return length;
    }

    public float getExternTemp() {
        return externTemp;
    }

    public float getInternTemp() {
        return internTemp;
    }

    public float getNumberPeople() {
        return numberPeople;
    } 

    public void setInternTemp(JSpinner jSpinnerTempSala) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
