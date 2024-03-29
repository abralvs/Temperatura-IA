/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author igorb
 */
public class EnvironmentConfiguration {
    private double roomDimension;
    private double internTemp;
    private double limInfPoucasPessoas;
    private double limSupPoucasPessoas; 
    private double limInfNormal;
    private double limSupNormal; 
    private double limInfMuitasPessoas; 
    private double limSupMuitasPessoas;
    private int classificacaoSala;
    private int numberPeople;
    private int classificacaoQtdPessoas;  // poucas pessoas =  0, normal = 1, muitas pesssoas = 2;
    

    public EnvironmentConfiguration(double roomDimension,double internTemp,
            int numberPeople) {
        this.roomDimension = roomDimension;
        this.internTemp = internTemp;
        this.numberPeople = numberPeople;
        configureLimits(); 
    }

    
    public void configureLimits(){
        limInfPoucasPessoas     = 0;
        limSupPoucasPessoas     = (roomDimension)*0.25;
        limInfNormal            = limSupPoucasPessoas;
        limSupNormal            = (roomDimension) * 0.5;
        limInfMuitasPessoas     = limSupNormal;
        limSupMuitasPessoas     = (roomDimension);
        classificacaoSala = -1; 
    } 

    public void setLimInfPoucasPessoas(double limInfPoucasPessoas) {
        this.limInfPoucasPessoas = limInfPoucasPessoas;
    }

    public void setLimSupPoucasPessoas(double limSupPoucasPessoas) {
        this.limSupPoucasPessoas = limSupPoucasPessoas;
    }

    public void setLimInfNormal(double limInfNormal) {
        this.limInfNormal = limInfNormal;
    }

    public void setLimSupNormal(double limSupNormal) {
        this.limSupNormal = limSupNormal;
    }

    public void setLimInfMuitasPessoas(double limInfMuitasPessoas) {
        this.limInfMuitasPessoas = limInfMuitasPessoas;
    }

    public void setLimSupMuitasPessoas(double limSupMuitasPessoas) {
        this.limSupMuitasPessoas = limSupMuitasPessoas;
    }

    public void setClassificacaoSala(int classificacaoSala) {
        this.classificacaoSala = classificacaoSala;
    }

    public void setClassificacaoQtdPessoas(int qtdPessoas) {
        this.classificacaoQtdPessoas = qtdPessoas;
    }
    
    
    
    public void setRoomDimension(double width) {
        this.roomDimension = width;
    }

    

    public void setInternTemp(double internTemp) {
        this.internTemp = internTemp;
    }

    public void setNumberPeople(int numberPeople) {
        this.numberPeople = numberPeople;
    }   

    public double getRoomDimension() {
        return roomDimension;
    }

    
    public double getInternTemp() {
        return internTemp;
    }

    public double getNumberPeople() {
        return numberPeople;
    }
    
    public double getLimInfPoucasPessoas() {
        return limInfPoucasPessoas;
    }

    public double getLimSupPoucasPessoas() {
        return limSupPoucasPessoas;
    }

    public double getLimInfNormal() {
        return limInfNormal;
    }

    public double getLimSupNormal() {
        return limSupNormal;
    }

    public double getLimInfMuitasPessoas() {
        return limInfMuitasPessoas;
    }

    public double getLimSupMuitasPessoas() {
        return limSupMuitasPessoas;
    }

    public int getClassificacaoSala() {
        return classificacaoSala;
    }

    public int getClassificacaoQtdPessoas() {
        return classificacaoQtdPessoas;
    }
}
