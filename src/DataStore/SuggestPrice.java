/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;

/**
 *
 * @author Jacob
 */
public class SuggestPrice extends javax.swing.JDialog {
    Dinosaur insidebone;
    String str_current_price;
    String str_sugg_price;
    Float f_sugg_price;
    /**
     * Creates new form SuggestPrice
     */
    public SuggestPrice(java.awt.Frame parent, boolean modal, Dinosaur bone) {
        super(parent, modal);
        initComponents();
        
        insidebone = bone;
        f_sugg_price = insidebone.pricing(bone);
        str_current_price = String.valueOf(bone.price); 
        CurrentPriceField.setText(str_current_price);
        str_sugg_price = String.valueOf(f_sugg_price);
        SuggestedPriceField.setText(str_sugg_price);
        this.setVisible(modal);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SuggestedPriceField = new javax.swing.JLabel();
        CurrentPriceField = new javax.swing.JLabel();
        SelectCurrentPrice = new javax.swing.JButton();
        UseSuggestedPrice = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Suggested Price");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Current Price");

        SuggestedPriceField.setText("Sugg");

        CurrentPriceField.setText("Curren");

        SelectCurrentPrice.setText("Keep Current");
        SelectCurrentPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectCurrentPriceActionPerformed(evt);
            }
        });

        UseSuggestedPrice.setText("Use Suggested");
        UseSuggestedPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UseSuggestedPriceMouseClicked(evt);
            }
        });
        UseSuggestedPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UseSuggestedPriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(CurrentPriceField)
                .addGap(126, 126, 126)
                .addComponent(SuggestedPriceField)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(SelectCurrentPrice))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UseSuggestedPrice)
                    .addComponent(jLabel1))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CurrentPriceField)
                    .addComponent(SuggestedPriceField))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectCurrentPrice)
                    .addComponent(UseSuggestedPrice))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SelectCurrentPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectCurrentPriceActionPerformed
        // TODO add your handling code here
        this.dispose();
    }//GEN-LAST:event_SelectCurrentPriceActionPerformed

    private void UseSuggestedPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UseSuggestedPriceActionPerformed
        // TODO add your handling code here:
        insidebone.price = f_sugg_price;
        this.dispose();
    }//GEN-LAST:event_UseSuggestedPriceActionPerformed

    private void UseSuggestedPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UseSuggestedPriceMouseClicked
        // TODO add your handling code here:
        //insidebone.price = f_sugg_price;
        //this.dispose();
    }//GEN-LAST:event_UseSuggestedPriceMouseClicked

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
            java.util.logging.Logger.getLogger(SuggestPrice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuggestPrice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuggestPrice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuggestPrice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SuggestPrice dialog = new SuggestPrice(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CurrentPriceField;
    private javax.swing.JButton SelectCurrentPrice;
    private javax.swing.JLabel SuggestedPriceField;
    private javax.swing.JButton UseSuggestedPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
