/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfcheckoutsystem;

import java.net.URL;

/**
 *
 * @author mintlaptop
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public LoginForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents()
   {

      enterPatronID = new javax.swing.JTextField();
      goButton = new javax.swing.JButton();
      LoginScreenTextArea = new javax.swing.JTextArea();
      backgroundImage = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setPreferredSize(new java.awt.Dimension(640, 480));
      setSize(new java.awt.Dimension(640, 480));
      getContentPane().setLayout(null);
      getContentPane().add(enterPatronID);
      enterPatronID.setBounds(66, 244, 227, 25);

      goButton.setText("Go");
      goButton.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            goButtonActionPerformed(evt);
         }
      });
      getContentPane().add(goButton);
      goButton.setBounds(299, 242, 67, 29);

      LoginScreenTextArea.setColumns(20);
      LoginScreenTextArea.setRows(5);
      LoginScreenTextArea.setText("Enter user ID #");
      getContentPane().add(LoginScreenTextArea);
      LoginScreenTextArea.setBounds(20, 10, 480, 75);

      backgroundImage.setMaximumSize(new java.awt.Dimension(640, 480));
      backgroundImage.setMinimumSize(new java.awt.Dimension(640, 480));
      getContentPane().add(backgroundImage);
      backgroundImage.setBounds(0, 0, 610, 510);

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        // TODO add your handling code here:
        userID = enterPatronID.getText();
        this.setVisible(false);
    }//GEN-LAST:event_goButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
    
    public String getUserID()
    {
        return userID;
    }
    
   public void setBackground(String filename)
   {
      URL fileurl = LanguageSelectionForm.class.getResource("/selfcheckoutsystem/images/" + filename);
      if (fileurl != null)
      {
         backgroundImage.setIcon(new javax.swing.ImageIcon(fileurl)); // NOI18N
      }
   }
   
   public void setText(String text)
   {
      LoginScreenTextArea.setText(text);
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextArea LoginScreenTextArea;
   private javax.swing.JLabel backgroundImage;
   private javax.swing.JTextField enterPatronID;
   private javax.swing.JButton goButton;
   // End of variables declaration//GEN-END:variables
    private String userID;
}
