package dms.pastor.tools.nanobackup.GUI;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;

/**
 * Author Dominik Symonowicz
 * Created: 2009-10-31 at17:59:32
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class About extends javax.swing.JFrame {

    private static final Logger LOGGER = LoggerFactory.getLogger(About.class);
    private final Properties properties = new Properties();
    private javax.swing.JTextArea changelogTextArea;
    private javax.swing.JTextArea eulaTextArea;
    private javax.swing.JScrollPane messagePanel;

    public About() {
        setup();
        initComponents();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new About().setVisible(true));
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        JTabbedPane aboutTabbedPanel = new JTabbedPane();
        JPanel aboutPanel = new JPanel();
        JLabel nameLabel = new JLabel();
        JLabel versionLabel = new JLabel();
        JLabel licenceLabel = new JLabel();
        JScrollPane jScrollPane5 = new JScrollPane();
        JTextArea jTextArea2 = new JTextArea();
        JLabel OSLabel = new JLabel();
        JLabel JVLabel = new JLabel();
        JPanel changelogPanel = new JPanel();
        JScrollPane jScrollPane2 = new JScrollPane();
        changelogTextArea = new javax.swing.JTextArea();
        JPanel aboutMePanel = new JPanel();
        JLabel authorLabel = new JLabel();
        JLabel emailLabel = new JLabel();
        JTextField emailField = new JTextField();
        JLabel wwwLabel = new JLabel();
        JTextField www = new JTextField();
        messagePanel = new javax.swing.JScrollPane();
        JTextArea messageTextArea = new JTextArea();
        JButton goToButton = new JButton();
        JLabel pictureOfMe = new JLabel();
        JPanel thanksPanel = new JPanel();
        JScrollPane thanksScrollPanel = new JScrollPane();
        JTextArea thanksTextArea = new JTextArea();
        JPanel eulaPanel = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        eulaTextArea = new javax.swing.JTextArea();

        setTitle("ABOUT ME");
        setAlwaysOnTop(true);
        setName("about"); 
        setResizable(false);

        aboutTabbedPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AboutTabbedPanelMouseClicked(evt);
            }
        });

        nameLabel.setText("NAME: nanoBackup");

        versionLabel.setText(properties.getProperty("about.version"));

        licenceLabel.setText("FORM OF SOFTWARE DISTRIBUTION: Freeware");

        jScrollPane5.setEnabled(false);
        jScrollPane5.setFont(getDefaultFont()); 

        jTextArea2.setColumns(20);
        jTextArea2.setFont(getDefaultFont()); 
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText(properties.getProperty("about.program"));
        jTextArea2.setWrapStyleWord(true);
        jScrollPane5.setViewportView(jTextArea2);

        OSLabel.setText("OS: " + System.getProperty("os.name") + "[" + System.getProperty("os.version") + "/" + System.getProperty("os.arch") + "]");

        JVLabel.setText("JAVA: " + System.getProperty("java.version"));

        javax.swing.GroupLayout aboutPanelLayout = new javax.swing.GroupLayout(aboutPanel);
        aboutPanel.setLayout(aboutPanelLayout);
        aboutPanelLayout.setHorizontalGroup(
                aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(aboutPanelLayout.createSequentialGroup()
                                .addGroup(aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nameLabel)
                                        .addComponent(versionLabel)
                                        .addComponent(licenceLabel)
                                        .addComponent(OSLabel)
                                        .addComponent(JVLabel)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
                                .addContainerGap())
        );
        aboutPanelLayout.setVerticalGroup(
                aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(aboutPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(versionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(licenceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(OSLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JVLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83))
        );

        aboutTabbedPanel.addTab("About program", aboutPanel);

        changelogTextArea.setColumns(20);
        changelogTextArea.setEditable(false);
        changelogTextArea.setFont(getDefaultFont()); 
        changelogTextArea.setLineWrap(true);
        changelogTextArea.setRows(5);
        changelogTextArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(changelogTextArea);

        javax.swing.GroupLayout changelogPanelLayout = new javax.swing.GroupLayout(changelogPanel);
        changelogPanel.setLayout(changelogPanelLayout);
        changelogPanelLayout.setHorizontalGroup(
                changelogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );
        changelogPanelLayout.setVerticalGroup(
                changelogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        aboutTabbedPanel.addTab("changelog", changelogPanel);

        authorLabel.setText("Author: Dominik Symonowicz");

        emailLabel.setText("Email:");

        emailField.setEditable(false);
        emailField.setText("dmspastor@gmail.com");

        wwwLabel.setText("www:");

        www.setEditable(false);
        www.setText("http://pastor.ovh.org");

        messageTextArea.setColumns(20);
        messageTextArea.setEditable(false);
        messageTextArea.setFont(getDefaultFont()); 
        messageTextArea.setLineWrap(true);
        messageTextArea.setRows(5);
        messageTextArea.setText(properties.getProperty("about.me"));
        messagePanel.setViewportView(messageTextArea);

        goToButton.setText("Go to my page");
        goToButton.addActionListener(this::goToButtonActionPerformed);

        pictureOfMe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanobackup/me.jpg"))); 

        javax.swing.GroupLayout aboutMePanelLayout = new javax.swing.GroupLayout(aboutMePanel);
        aboutMePanel.setLayout(aboutMePanelLayout);
        aboutMePanelLayout.setHorizontalGroup(
                aboutMePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(aboutMePanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(pictureOfMe, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(aboutMePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(authorLabel)
                                        .addGroup(aboutMePanelLayout.createSequentialGroup()
                                                .addComponent(emailLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                                        .addComponent(messagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                                        .addGroup(aboutMePanelLayout.createSequentialGroup()
                                                .addComponent(wwwLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(www, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(goToButton)))
                                .addContainerGap())
        );
        aboutMePanelLayout.setVerticalGroup(
                aboutMePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(aboutMePanelLayout.createSequentialGroup()
                                .addGroup(aboutMePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(aboutMePanelLayout.createSequentialGroup()
                                                .addComponent(authorLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(aboutMePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(emailLabel)
                                                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(aboutMePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(aboutMePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(www, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(goToButton))
                                                        .addComponent(wwwLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(messagePanel))
                                        .addComponent(pictureOfMe, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        aboutTabbedPanel.addTab("About me", aboutMePanel);

        thanksTextArea.setColumns(20);
        thanksTextArea.setEditable(false);
        thanksTextArea.setFont(getDefaultFont()); 
        thanksTextArea.setLineWrap(true);
        thanksTextArea.setRows(5);
        thanksTextArea.setText(properties.getProperty("about.thanks"));
        thanksTextArea.setWrapStyleWord(true);
        thanksScrollPanel.setViewportView(thanksTextArea);

        javax.swing.GroupLayout thanksPanelLayout = new javax.swing.GroupLayout(thanksPanel);
        thanksPanel.setLayout(thanksPanelLayout);
        thanksPanelLayout.setHorizontalGroup(
                thanksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(thanksScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );
        thanksPanelLayout.setVerticalGroup(
                thanksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(thanksScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        aboutTabbedPanel.addTab("Thanks", thanksPanel);

        eulaTextArea.setColumns(20);
        eulaTextArea.setEditable(false);
        eulaTextArea.setFont(new java.awt.Font("Lucida Sans", 0, 14)); 
        eulaTextArea.setLineWrap(true);
        eulaTextArea.setRows(5);
        jScrollPane1.setViewportView(eulaTextArea);

        javax.swing.GroupLayout eulaPanelLayout = new javax.swing.GroupLayout(eulaPanel);
        eulaPanel.setLayout(eulaPanelLayout);
        eulaPanelLayout.setHorizontalGroup(
                eulaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );
        eulaPanelLayout.setVerticalGroup(
                eulaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        aboutTabbedPanel.addTab("eula", eulaPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(aboutTabbedPanel)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(aboutTabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Font getDefaultFont() {
        return new Font("Lucida Sans", 0, 12);
    }

    private void AboutTabbedPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutTabbedPanelMouseClicked
        try {
            String changelog = FileUtils.readFileToString(new File("data" + System.getProperty("file.separator") + "changelog.txt"));
            changelogTextArea.setText(changelog);
            changelogTextArea.setCaretPosition(0);
            String eula = FileUtils.readFileToString(new File("data" + System.getProperty("file.separator") + "eula.txt"));
            eulaTextArea.setText(eula);
            eulaTextArea.setCaretPosition(0);
        } catch (IOException ex) {
            LOGGER.warn("IOException occur during clicking on tab" + ex.getMessage());
        }
    }//GEN-LAST:event_AboutTabbedPanelMouseClicked

    private void goToButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToButtonActionPerformed
        try {
            java.awt.Desktop.getDesktop().browse(new URI("http://pastor.ovh.org"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "It is something wrong with web address.\nPossible reasons:\nIt is possible that you have weird problem with internet connection.\nFirewall blocks Java to access to internet\nAddress is incorrect.", "BAD NEWS!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_goToButtonActionPerformed
    // End of variables declaration//GEN-END:variables

    private void setup() {
        try (FileInputStream fis = new FileInputStream("data" + System.getProperty("file.separator") + "message.properties")) {
            properties.load(fis);
        } catch (FileNotFoundException ex) {
            LOGGER.warn("Unexpected error due load properties for About." + ex.getCause() + ("\n" + ex.getMessage()));
            JOptionPane.showMessageDialog(rootPane, messagePanel, "WHOOPS", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        } catch (IOException ex) {
            LOGGER.warn("Unexpected error due load properties for About." + ex.getCause() + ("\n" + ex.getMessage()));
            this.dispose();
        }
    }
}
