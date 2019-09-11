/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import models.Chart;
import models.EnvironmentConfiguration;
import models.TemperatureController;
import models.viewmodels.DimensionsRoomClassification;
import models.viewmodels.IdealTemperatureClassification;
import models.viewmodels.OcupationRoomClassification;
import models.viewmodels.TemperatureClassification;

/**
 *
 * @author igorb
 */
public class FrameIdealTemperature extends javax.swing.JFrame {

    /**
     * Creates new form FrameIdealTemperature
     */
    private static EnvironmentConfiguration envConfig;
    private TemperatureController tempControl;
    private DimensionsRoomClassification dimensionsRoom;
    private IdealTemperatureClassification idealTemp;
    private OcupationRoomClassification ocupationRoom;
    private TemperatureClassification temp;
    private Chart chart;

    
    
    public FrameIdealTemperature(EnvironmentConfiguration envConfig) {
        initComponents();
        setResizable(false);
        
        
        if (envConfig != null)
            this.envConfig = envConfig;
        else
            setAlatoryConfiguration();    

        
        
        tempControl = new TemperatureController(envConfig);
        
        tempControl.loadFile();
        
        setDados();
        setChart(); 
    }
    
    
    public void setChart(){
        chart = new Chart(); 
        jPanelChart.add(chart.pyramidChartCreate(
                tempControl.getFb().getVariable("ajusteideal"),0,0,441,230));
    }
    
    
    public void setAlatoryConfiguration(){
    
    
    
    }
    
    
    public void setDados(){        
       dimensionsRoom = tempControl.getDimensionsRoomClassification();
       idealTemp = tempControl.getIdealTemperatureClassification();
       ocupationRoom = tempControl.getOcupationRoomClassification();
       temp = tempControl.getTemperatureClassification();
        
       valorTempIntera.setText("Value: "+temp.getTemperatureSetting()+" ºC");
       TermoLinguisticoTempInterna.setText("Term: "+temp.getLinguisticTerm());
       grauPertinenciaTempinterna.setText("Relevance: "+String.format(" %.2f",temp.getRelevance()));
       
       
       valorTamanhoSala.setText("Value: "+dimensionsRoom.getDimensionSetting() + " m²");
       TermoTamanhoSala.setText("Term: "+dimensionsRoom.getLinguisticTerm());
       GrauPertinenciaTamanhoSala.setText("Relevance: "+ String.format(" %.2f",dimensionsRoom.getRelevance()));
    
       
       ValorNivelOcupacao.setText("Value: "+ ocupationRoom.getOcupationSetting());
       TermoNivelOcupacao.setText("Term: "+ ocupationRoom.getLinguisticTerm());
       GrauNivelOcupacao.setText("Relevance: "+ String.format(" %.2f",ocupationRoom.getRelevance()));
       
       if (idealTemp.getTemperatureSetting() > 0 )
        tempAjuste.setText("Ajustar Temperatura Em: +"+String.format("%.2f",idealTemp.getTemperatureSetting())+"ºC");
       else
        tempAjuste.setText("Ajustar Temperatura Em: "+String.format("%.2f",idealTemp.getTemperatureSetting())+"ºC");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        valorTempIntera = new javax.swing.JLabel();
        TermoLinguisticoTempInterna = new javax.swing.JLabel();
        grauPertinenciaTempinterna = new javax.swing.JLabel();
        TermoTamanhoSala = new javax.swing.JLabel();
        GrauPertinenciaTamanhoSala = new javax.swing.JLabel();
        ValorNivelOcupacao = new javax.swing.JLabel();
        TermoNivelOcupacao = new javax.swing.JLabel();
        GrauNivelOcupacao = new javax.swing.JLabel();
        jPanelChart = new javax.swing.JPanel();
        tempAjuste = new javax.swing.JLabel();
        valorTamanhoSala = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonSetUpEnvonment = new javax.swing.JRadioButtonMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(580, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(580, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Grau de Pertinencia dos Valores Informados");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Temperatura Interna");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tamanho da Sala");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nivel de Ocupacao");

        valorTempIntera.setText("Valor: ");

        TermoLinguisticoTempInterna.setText("Termo:");

        grauPertinenciaTempinterna.setText("Grau:");

        TermoTamanhoSala.setText("Termo:");

        GrauPertinenciaTamanhoSala.setText("Grau");

        ValorNivelOcupacao.setText("Valor:");

        TermoNivelOcupacao.setText("Termo:");

        GrauNivelOcupacao.setText("Grau:");

        jPanelChart.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelChartLayout = new javax.swing.GroupLayout(jPanelChart);
        jPanelChart.setLayout(jPanelChartLayout);
        jPanelChartLayout.setHorizontalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );
        jPanelChartLayout.setVerticalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );

        tempAjuste.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tempAjuste.setText("Ajustar Temperatura Em: ");

        valorTamanhoSala.setText("Valor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TermoLinguisticoTempInterna)
                            .addComponent(grauPertinenciaTempinterna))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GrauPertinenciaTamanhoSala)
                            .addComponent(TermoTamanhoSala)
                            .addComponent(valorTamanhoSala))
                        .addGap(107, 107, 107))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(valorTempIntera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GrauNivelOcupacao)
                    .addComponent(ValorNivelOcupacao)
                    .addComponent(jLabel4)
                    .addComponent(TermoNivelOcupacao))
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jPanelChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tempAjuste)
                .addGap(171, 171, 171))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorTempIntera)
                    .addComponent(ValorNivelOcupacao)
                    .addComponent(valorTamanhoSala))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TermoLinguisticoTempInterna)
                    .addComponent(TermoNivelOcupacao)
                    .addComponent(TermoTamanhoSala, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grauPertinenciaTempinterna)
                    .addComponent(GrauPertinenciaTamanhoSala)
                    .addComponent(GrauNivelOcupacao))
                .addGap(19, 19, 19)
                .addComponent(jPanelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tempAjuste)
                .addGap(30, 30, 30))
        );

        jMenu1.setText("Options");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("Charts");
        jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem1);

        jRadioButtonSetUpEnvonment.setSelected(true);
        jRadioButtonSetUpEnvonment.setText("Set Up Environment");
        jRadioButtonSetUpEnvonment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSetUpEnvonmentActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonSetUpEnvonment);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed
        FrameFuzzifyChart frameFuzzifyChart = new FrameFuzzifyChart(tempControl);
        frameFuzzifyChart.setVisible(true);
    }//GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

    private void jRadioButtonSetUpEnvonmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSetUpEnvonmentActionPerformed
        FrameConfiguration config = new FrameConfiguration();
        config.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jRadioButtonSetUpEnvonmentActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameIdealTemperature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameIdealTemperature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameIdealTemperature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameIdealTemperature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameIdealTemperature(envConfig).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GrauNivelOcupacao;
    private javax.swing.JLabel GrauPertinenciaTamanhoSala;
    private javax.swing.JLabel TermoLinguisticoTempInterna;
    private javax.swing.JLabel TermoNivelOcupacao;
    private javax.swing.JLabel TermoTamanhoSala;
    private javax.swing.JLabel ValorNivelOcupacao;
    private javax.swing.JLabel grauPertinenciaTempinterna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelChart;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonSetUpEnvonment;
    private javax.swing.JLabel tempAjuste;
    private javax.swing.JLabel valorTamanhoSala;
    private javax.swing.JLabel valorTempIntera;
    // End of variables declaration//GEN-END:variables
}
