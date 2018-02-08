/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FaqGUI.java
 *
 * Created on 2011-10-24, 21:25:24
 */
package dms.pastor.tools.nanobackup.GUI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;


/**
 * @author Pastor
 */
public class FaqGUI extends javax.swing.JFrame {
    private static final Logger LOGGER = LoggerFactory.getLogger(FaqGUI.class);
    private final Properties properties = new Properties();
    private String[] questions = {"Why I don't see FAQ?"};
    private String[] answers = {"It seems like file message.properties was missing , damaged or author of this program forgot update FAQ sections."};
    private javax.swing.JTextArea answersField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox questionComboBox;

    /**
     * Creates new form FaqGUI
     */
    public FaqGUI() {
        setup();
        initComponents();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | javax.swing.UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            LOGGER.error("Unable to start application due " + ex.getMessage());
        }
        java.awt.EventQueue.invokeLater(() -> new FaqGUI().setVisible(true));
    }

    private void initComponents() {

        questionComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        answersField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FAQ");
        setName("faqFrame"); // NOI18N

        questionComboBox.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        questionComboBox.setModel(new javax.swing.DefaultComboBoxModel(questions));
        questionComboBox.setToolTipText("Place,where you can select question");
        questionComboBox.addActionListener(this::questionComboBoxActionPerformed);

        jLabel1.setText("Choose question to see answer:");

        answersField.setColumns(20);
        answersField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        answersField.setLineWrap(true);
        answersField.setRows(5);
        answersField.setText(answers[0]);
        answersField.setToolTipText("Place ,where answer are displayed");
        answersField.setWrapStyleWord(true);
        jScrollPane1.setViewportView(answersField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                        .addComponent(questionComboBox, 0, 589, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(questionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void questionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionComboBoxActionPerformed
        answersField.setText(answers[questionComboBox.getSelectedIndex()]);
    }

    private void setup() {
        ArrayList<String> question = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();

        final String path = "data" + System.getProperty("file.separator") + "message.properties";
        try (FileInputStream fis = new FileInputStream(path)) {
            properties.load(fis);
            for (int i = 0; i < Integer.parseInt(properties.getProperty("faq.counter")); i++) {
                if (properties.getProperty("faq.q." + i) != null && properties.getProperty("faq.a." + i) != null) {
                    question.add(properties.getProperty("faq.q." + i));
                    answer.add(properties.getProperty("faq.a." + i));
                } else {
                    break;
                }

            }
            String[] sq = new String[question.size()];
            String[] sa = new String[answer.size()];
            questions = question.toArray(sq);
            answers = answer.toArray(sa);
        } catch (NumberFormatException ex) {
            LOGGER.warn("Error cause due author screwed up update faq section in message.properties or somebody \"innocent\" had crap idea to mess up with message.properties");
            this.dispose();
        } catch (IOException ex) {
            LOGGER.warn("Unexpected error due load properties for About." + ex.getCause() + ("\n" + ex.getMessage()));
            this.dispose();
        }
    }

    //TODO implement this method!
    private void validateFAQ() {
        throw new UnsupportedOperationException("Not yet implemented");
    }


}
