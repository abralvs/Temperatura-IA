    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import models.Chart;
import models.EnvironmentConfiguration;
import models.TemperatureController;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author igorb
 */
public final class FrameControl extends javax.swing.JFrame {
    /**
     * Creates new form FrameControl
     */
    public  static Chart graficoTempInterna;
    public  static Chart graficoTempExterna;
    public static TemperatureController tempControl;
    public DefaultCategoryDataset dsTempInterna;
    public DefaultCategoryDataset dsTempExterna;
        
    public FrameControl(TemperatureController  tempControl)  {
        initComponents();
        setResizable(false); 
        
        /*Configuracoes do ambiente*/
        this.tempControl = tempControl;
        
        /* exectando fuzzificação e defuzzificação*/
        this.tempControl.loadFile();
        
        /*Objeto que gera os graficos*/
        graficoTempInterna = new Chart();
        graficoTempExterna = new Chart();
         
        /*PLOTANDO PRIMEIRO GRAFICO*/
        pTemExterna.add(graficoTempExterna.lineChartCreate("temperatura Externa",200,20));
        
        /*PLOTANDO SEGUNDO GRAFICO*/
        dsTempInterna = new DefaultCategoryDataset();
        dsTempInterna.addValue(40.5, "temperatura", "t1");
        dsTempInterna.addValue(38.2, "temperatura", "t2");
        dsTempInterna.addValue(37.3, "temperatura", "t3");
        dsTempInterna.addValue(31.5, "temperatura", "t4"); 
        graficoTempInterna.setDsTemp(dsTempInterna); 
        pTempInterna.add(graficoTempInterna.lineChartCreate("Temperatura Interna",200,20));
        
        
        ImageIcon icon = new ImageIcon("src\\tempcontrolia\\images\\termometro.png");
        jLabelTerm.setIcon(icon);
        jLabelTerm1.setIcon(icon);
        
        setTemperaturaFicticia();  
    } 
    
    
    
    /*Thread que gera valores aleatorios de temperatura externa*/
    public static void setTemperaturaFicticia(){
         Random gerador = new Random();
         new Thread(){
          @Override
          public void run() {   
              while(true){
                  try {
                    Thread.sleep(2000); 
                  } catch (InterruptedException ex) {
                    Logger.getLogger(FrameControl.class.getName()).log(Level.SEVERE, null, ex);
                  }
              
                  if (graficoTempExterna.getDsTemp().getColumnCount() >= 4)
                       graficoTempExterna.getDsTemp().removeColumn(0);
                  
                  graficoTempExterna.getDsTemp().addValue((gerador.nextDouble() * 35)+10,"temperatura","t"+graficoTempExterna.getIdTemp());
                  graficoTempExterna.getPlotTemp().setDataset(graficoTempExterna.getDsTemp());          
                  graficoTempExterna.setIdTemp((graficoTempExterna.getIdTemp()+1));
              }
           }
        }.start();
    }
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pTemExterna = new javax.swing.JPanel();
        jLabelTerm = new javax.swing.JLabel();
        pTempInterna = new javax.swing.JPanel();
        jLabelTerm1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuChart = new javax.swing.JMenu();
        jRadioButtonChartFuzzify = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonDefuzzify = new javax.swing.JRadioButtonMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(820, 720));

        pTemExterna.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pTemExternaLayout = new javax.swing.GroupLayout(pTemExterna);
        pTemExterna.setLayout(pTemExternaLayout);
        pTemExternaLayout.setHorizontalGroup(
            pTemExternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTemExternaLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabelTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(436, Short.MAX_VALUE))
        );
        pTemExternaLayout.setVerticalGroup(
            pTemExternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTemExternaLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabelTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pTempInterna.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pTempInternaLayout = new javax.swing.GroupLayout(pTempInterna);
        pTempInterna.setLayout(pTempInternaLayout);
        pTempInternaLayout.setHorizontalGroup(
            pTempInternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTempInternaLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabelTerm1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pTempInternaLayout.setVerticalGroup(
            pTempInternaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTempInternaLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabelTerm1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tempcontrolia/images/ar-cond.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel1)
                .addContainerGap(215, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pTemExterna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pTempInterna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pTemExterna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pTempInterna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuChart.setText("Charts");

        jRadioButtonChartFuzzify.setSelected(true);
        jRadioButtonChartFuzzify.setText("Fuzzify");
        jRadioButtonChartFuzzify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonChartFuzzifyActionPerformed(evt);
            }
        });
        jMenuChart.add(jRadioButtonChartFuzzify);

        jRadioButtonDefuzzify.setSelected(true);
        jRadioButtonDefuzzify.setText("Defuzzify");
        jRadioButtonDefuzzify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDefuzzifyActionPerformed(evt);
            }
        });
        jMenuChart.add(jRadioButtonDefuzzify);

        jMenuBar1.add(jMenuChart);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonChartFuzzifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonChartFuzzifyActionPerformed
        FrameFuzzifyChart frameFuzzifyChart = new FrameFuzzifyChart(tempControl);
        frameFuzzifyChart.setVisible(true);
    }//GEN-LAST:event_jRadioButtonChartFuzzifyActionPerformed

    private void jRadioButtonDefuzzifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDefuzzifyActionPerformed
        
    }//GEN-LAST:event_jRadioButtonDefuzzifyActionPerformed

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
            java.util.logging.Logger.getLogger(FrameControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    new FrameControl(tempControl).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTerm;
    private javax.swing.JLabel jLabelTerm1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuChart;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonChartFuzzify;
    private javax.swing.JRadioButtonMenuItem jRadioButtonDefuzzify;
    private javax.swing.JPanel pTemExterna;
    private javax.swing.JPanel pTempInterna;
    // End of variables declaration//GEN-END:variables
}
