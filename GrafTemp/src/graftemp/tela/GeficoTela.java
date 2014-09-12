/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graftemp.tela;

import graftemp.logica.Formula;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Anderson
 */
public class GeficoTela extends javax.swing.JFrame {

    DefaultCategoryDataset dataset;

    /**
     * Creates new form GeficoTela
     */
    public GeficoTela() {
//        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        initComponents();
        dataset = new DefaultCategoryDataset();
        calcular();

    }

    public void calcular() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dataset = new DefaultCategoryDataset();
                criaGraficoPeloLocal(dataset);
                Formula formula = new Formula(20, 50, 1);
                ArrayList<Double> valores;
                int x = 0;
                int tempo1 = 0;

                //Temperatura 50 em 50
                for (int i = 6; i > 0; i--) {
                    x = 0;
                    tempo1 = (i * 50);
                    valores = formula.temperaturaEmRelacaoX(1000, tempo1, 50);
                    imprimirTempo(valores, tempo1);
                    for (Double val : valores) {
                        dataset.addValue(val, "" + tempo1, "" + x);
                        x++;
                    }
                    criaGraficoPeloLocal(dataset);
                }
                x = 0;
                tempo1 = 20;
                valores = formula.temperaturaEmRelacaoX(1000, tempo1, 50);
                imprimirTempo(valores, tempo1);
                for (Double val : valores) {
                    dataset.addValue(val, "" + tempo1, "" + x);
                    x++;
                }
                criaGraficoPeloLocal(dataset);

                x = 0;
                tempo1 = 10;
                valores = formula.temperaturaEmRelacaoX(1000, tempo1, 50);
                imprimirTempo(valores, tempo1);
                for (Double val : valores) {
                    dataset.addValue(val, "" + tempo1, "" + x);
                    x++;
                }
                criaGraficoPeloLocal(dataset);
                x = 0;
                tempo1 = 0;
                valores = formula.temperaturaEmRelacaoX(1000, tempo1, 50);
                imprimirTempo(valores, tempo1);
                for (Double val : valores) {
                    dataset.addValue(val, "" + tempo1, "" + x);
                    x++;
                }
                criaGraficoPeloLocal(dataset);

                dataset = new DefaultCategoryDataset();
                criaGraficoPeloTempo(dataset);
                int posicao = 0;
                //Posicao 5 em 5
                for (int i = 1; i <= 5; i++) {
                    x = 0;
                    posicao = (i * 5);
                    valores = formula.temperaturaEmRelacaoT(1000, 500, posicao);
                    imprimirPosicao(valores, posicao);
                    for (Double val : valores) {
                        dataset.addValue(val, "" + posicao, "" + x);
                        x++;
                    }
                    criaGraficoPeloTempo(dataset);
                }

            }
        }).start();
    }

    public void criaGraficoPeloLocal(CategoryDataset cds) {
        String titulo = "Gráfico de Temperatura por posição";
        String eixoy = "Temperatura";
        String txt_legenda = "Posição";
        boolean legenda = true;
        boolean tooltips = true;
        boolean urls = true;
//        JFreeChart graf = ChartFactory.createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
        JFreeChart graf = ChartFactory.createLineChart(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
        ChartPanel myChartPanel = new ChartPanel(graf, true);
        myChartPanel.setSize(jPanel1.getWidth(), jPanel1.getHeight());
        myChartPanel.setVisible(true);
        jPanel1.removeAll();
        jPanel1.add(myChartPanel);
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    public void criaGraficoPeloTempo(CategoryDataset cds) {
        String titulo = "Gráfico de Temperatura por tempo";
        String eixoy = "Temperatura";
        String txt_legenda = "Tempo";
        boolean legenda = true;
        boolean tooltips = true;
        boolean urls = true;
//        JFreeChart graf = ChartFactory.createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
        JFreeChart graf = ChartFactory.createLineChart(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
        ChartPanel myChartPanel = new ChartPanel(graf, true);
        myChartPanel.setSize(jPanel2.getWidth(), jPanel2.getHeight());
        myChartPanel.setVisible(true);
        jPanel2.removeAll();
        jPanel2.add(myChartPanel);
        jPanel2.revalidate();
        jPanel2.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void imprimirTempo(ArrayList<Double> valores, double tempo) {
        String newline = "\n";
        int pos = 0;
        for (Double double1 : valores) {
            jTextArea1.append("Posição " + pos + ", Temperatura " + Math.round(double1) + " Tempo " + tempo + newline);
            pos++;
        }
        jTextArea1.append("Posição " + newline);
    }

    public void imprimirPosicao(ArrayList<Double> valores, double posicao) {
        String newline = "\n";
        int pos = 0;
        for (Double double1 : valores) {
            jTextArea1.append("Tempo " + pos + ", Temperatura " + Math.round(double1) + " Posicao " + posicao + newline);
            pos++;
        }
        jTextArea1.append("Tempo " + newline);
    }

    public boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

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
            java.util.logging.Logger.getLogger(GeficoTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeficoTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeficoTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeficoTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeficoTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
