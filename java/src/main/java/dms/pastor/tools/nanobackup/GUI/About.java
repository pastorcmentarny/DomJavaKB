package dms.pastor.tools.nanobackup.GUI;

import dms.pastor.tools.nanobackup.Constants;
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

import static dms.pastor.tools.nanobackup.Constants.DATA_PATH;
import static dms.pastor.tools.nanobackup.Constants.DEFAULT_COLUMNS_SIZE;
import static java.nio.charset.StandardCharsets.UTF_8;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

/**
 * Author Dominik Symonowicz
 * Created: 2009-10-31 at17:59:32
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * This is my first project after graduation in 2010. Do not expect too much :)
 */
@SuppressWarnings("MagicNumber") //TOO OLD PROJECT  TO TAKE CARE OF MAGIC NUMBERS
public class About extends javax.swing.JFrame {

    private static final Logger LOGGER = LoggerFactory.getLogger(About.class);
    private static final int DEFAULT_PREFERRED_SIZE = 613;
    private static final int DEFAULT_GAP_SIZE = 18;
    private final Properties properties = new Properties();
    private javax.swing.JTextArea changelogTextArea;
    private javax.swing.JTextArea eulaTextArea;
    private javax.swing.JScrollPane messagePanel;

    public About() {
        LOGGER.debug("Displaying About GUI.");
        setup();
        initComponents();
        LOGGER.debug("About GUI displayed.");
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new About().setVisible(true));
    }

    void closeWindow() {
        this.dispose();
    }

    @SuppressWarnings({"OverlyLongMethod"}) // GUI setup
    private void initComponents() {

        JTabbedPane aboutTabbedPanel = new JTabbedPane();
        JPanel aboutPanel = new JPanel();
        JLabel nameLabel = new JLabel();
        JLabel versionLabel = new JLabel();
        JLabel licenceLabel = new JLabel();
        JScrollPane jScrollPane5 = new JScrollPane();
        JTextArea jTextArea2 = new JTextArea();
        JLabel osLabel = new JLabel();
        JLabel jvmLabel = new JLabel();
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
                aboutTabbedPanelMouseClicked();
            }
        });

        nameLabel.setText("NAME: nanoBackup");

        versionLabel.setText(properties.getProperty("about.version"));

        licenceLabel.setText("FORM OF SOFTWARE DISTRIBUTION: Freeware");

        jScrollPane5.setEnabled(false);
        jScrollPane5.setFont(getDefaultFont());

        jTextArea2.setColumns(DEFAULT_COLUMNS_SIZE);
        jTextArea2.setFont(getDefaultFont());
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(Constants.DEFAULT_ROWS_SIZE);
        jTextArea2.setText(properties.getProperty("about.program"));
        jTextArea2.setWrapStyleWord(true);
        jScrollPane5.setViewportView(jTextArea2);

        osLabel.setText("OS: " + System.getProperty("os.name") + "[" + System.getProperty("os.version") + "/" + System.getProperty("os.arch") + "]");

        jvmLabel.setText("JAVA: " + System.getProperty("java.version"));

        javax.swing.GroupLayout aboutPanelLayout = new javax.swing.GroupLayout(aboutPanel);
        aboutPanel.setLayout(aboutPanelLayout);
        aboutPanelLayout.setHorizontalGroup(
                aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(aboutPanelLayout.createSequentialGroup()
                                .addGroup(aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nameLabel)
                                        .addComponent(versionLabel)
                                        .addComponent(licenceLabel)
                                        .addComponent(osLabel)
                                        .addComponent(jvmLabel)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
                                .addContainerGap())
        );
        aboutPanelLayout.setVerticalGroup(
                aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(aboutPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nameLabel)
                                .addPreferredGap(RELATED)
                                .addComponent(versionLabel)
                                .addPreferredGap(RELATED)
                                .addComponent(licenceLabel)
                                .addPreferredGap(RELATED, 14, Short.MAX_VALUE)
                                .addComponent(osLabel)
                                .addPreferredGap(RELATED)
                                .addComponent(jvmLabel)
                                .addPreferredGap(RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(DEFAULT_GAP_SIZE, DEFAULT_GAP_SIZE, DEFAULT_GAP_SIZE))
        );

        aboutTabbedPanel.addTab("About program", aboutPanel);

        changelogTextArea.setColumns(DEFAULT_COLUMNS_SIZE);
        changelogTextArea.setEditable(false);
        changelogTextArea.setFont(getDefaultFont());
        changelogTextArea.setLineWrap(true);
        changelogTextArea.setRows(Constants.DEFAULT_ROWS_SIZE);
        GroupLayout changelogPanelLayout = getGroupLayout(changelogPanel, jScrollPane2, changelogTextArea);
        changelogPanelLayout.setVerticalGroup(
                changelogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        aboutTabbedPanel.addTab("changelog", changelogPanel);

        authorLabel.setText("Author: Dominik Symonowicz");

        emailLabel.setText("Email:");

        emailField.setEditable(false);
        emailField.setText("Check on my home page");

        wwwLabel.setText("www:");

        www.setEditable(false);
        www.setText("https://dominiksymonowicz.com/welcome");

        messageTextArea.setColumns(DEFAULT_COLUMNS_SIZE);
        messageTextArea.setEditable(false);
        messageTextArea.setFont(getDefaultFont());
        messageTextArea.setLineWrap(true);
        messageTextArea.setRows(Constants.DEFAULT_ROWS_SIZE);
        messageTextArea.setText(properties.getProperty("about.me"));
        messagePanel.setViewportView(messageTextArea);

        goToButton.setText("Go to my page");
        goToButton.addActionListener(evt -> goToButtonActionPerformed());

        pictureOfMe.setIcon(new javax.swing.ImageIcon(DATA_PATH + "me.jpg"));

        javax.swing.GroupLayout aboutMePanelLayout = new javax.swing.GroupLayout(aboutMePanel);
        aboutMePanel.setLayout(aboutMePanelLayout);
        aboutMePanelLayout.setHorizontalGroup(
                aboutMePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(aboutMePanelLayout.createSequentialGroup()
                                .addGap(DEFAULT_GAP_SIZE, DEFAULT_GAP_SIZE, DEFAULT_GAP_SIZE)
                                .addComponent(pictureOfMe, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(DEFAULT_GAP_SIZE, DEFAULT_GAP_SIZE, DEFAULT_GAP_SIZE)
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
                                                .addPreferredGap(RELATED)
                                                .addComponent(goToButton)))
                                .addContainerGap())
        );
        aboutMePanelLayout.setVerticalGroup(
                aboutMePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(aboutMePanelLayout.createSequentialGroup()
                                .addGroup(aboutMePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(aboutMePanelLayout.createSequentialGroup()
                                                .addComponent(authorLabel)
                                                .addPreferredGap(RELATED)
                                                .addGroup(aboutMePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(emailLabel)
                                                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(RELATED)
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

        thanksTextArea.setColumns(DEFAULT_COLUMNS_SIZE);
        thanksTextArea.setEditable(false);
        thanksTextArea.setFont(getDefaultFont());
        thanksTextArea.setLineWrap(true);
        thanksTextArea.setRows(Constants.DEFAULT_ROWS_SIZE);
        thanksTextArea.setText(properties.getProperty("about.thanks"));
        GroupLayout thanksPanelLayout = getGroupLayout(thanksPanel, thanksScrollPanel, thanksTextArea);
        thanksPanelLayout.setVerticalGroup(
                thanksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(thanksScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, DEFAULT_PREFERRED_SIZE, Short.MAX_VALUE)
        );

        aboutTabbedPanel.addTab("Thanks", thanksPanel);

        eulaTextArea.setColumns(DEFAULT_COLUMNS_SIZE);
        eulaTextArea.setEditable(false);
        eulaTextArea.setFont(new java.awt.Font("Lucida Sans", Font.PLAIN, 14));
        eulaTextArea.setLineWrap(true);
        eulaTextArea.setRows(Constants.DEFAULT_ROWS_SIZE);
        jScrollPane1.setViewportView(eulaTextArea);

        javax.swing.GroupLayout eulaPanelLayout = new javax.swing.GroupLayout(eulaPanel);
        eulaPanel.setLayout(eulaPanelLayout);
        eulaPanelLayout.setHorizontalGroup(
                eulaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, DEFAULT_PREFERRED_SIZE, Short.MAX_VALUE)
        );
        eulaPanelLayout.setVerticalGroup(
                eulaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, DEFAULT_PREFERRED_SIZE, Short.MAX_VALUE)
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
                        .addComponent(aboutTabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, DEFAULT_PREFERRED_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private GroupLayout getGroupLayout(JPanel panel, JScrollPane scrollPanel, JTextArea textArea) {
        textArea.setWrapStyleWord(true);
        scrollPanel.setViewportView(textArea);

        GroupLayout groupLayout = new GroupLayout(panel);
        panel.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPanel, GroupLayout.DEFAULT_SIZE, DEFAULT_PREFERRED_SIZE, Short.MAX_VALUE)
        );
        return groupLayout
                ;
    }

    private Font getDefaultFont() {
        return new Font("Lucida Sans", Font.PLAIN, 12);
    }

    private void aboutTabbedPanelMouseClicked() {
        try {
            String changelog = FileUtils.readFileToString(new File(DATA_PATH + "changelog.txt"), UTF_8);
            changelogTextArea.setText(changelog);
            changelogTextArea.setCaretPosition(0);
            String eula = FileUtils.readFileToString(new File(DATA_PATH + File.separator + "eula.txt"), UTF_8);
            eulaTextArea.setText(eula);
            eulaTextArea.setCaretPosition(0);
        } catch (IOException ex) {
            LOGGER.warn("IOException occur during clicking on tab" + ex.getMessage());
        }
    }

    private void goToButtonActionPerformed() {
        try {
            java.awt.Desktop.getDesktop().browse(new URI("https://dominiksymonowicz.com/about/"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "It is something wrong with web address.\nPossible reasons:\nIt is possible that you have weird problem with internet connection.\nFirewall blocks Java to access to internet\nAddress is incorrect.", "BAD NEWS!", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void setup() {
        try (FileInputStream fis = new FileInputStream(DATA_PATH + "message.properties")) {
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
