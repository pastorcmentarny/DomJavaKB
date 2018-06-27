package dms.pastor.tools.nanobackup.GUI;

import dms.pastor.tools.nanobackup.Constants;
import dms.pastor.tools.nanobackup.History;
import dms.pastor.tools.nanobackup.Messenger;
import dms.pastor.tools.nanobackup.Settings;
import dms.pastor.tools.nanobackup.backup.Backup;
import dms.pastor.tools.nanobackup.backup.Engine;
import dms.pastor.tools.nanobackup.tools.AppColor;
import dms.pastor.tools.nanobackup.tools.FileTools;
import dms.pastor.tools.nanobackup.tools.TaskUtils;
import dms.pastor.tools.nanobackup.tools.Tools;
import dms.pastor.utils.FileUtils;
import dms.pastor.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.JPopupMenu.Separator;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Properties;

import static java.awt.Font.BOLD;

/**
 * Author Dominik Symonowicz
 * Created 15-Nov-2010, 10:08:48
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * This is main window(GUI) of program .
 */
@SuppressWarnings({"MagicNumber", "unused", "ClassWithTooManyFields", "CyclicClassDependency", "ClassWithTooManyMethods", "OverlyComplexClass"})
//TOO OLD PROJECT  TO TAKE CARE OF MAGIC NUMBERS ,evt are not used as they are not needed blame Java
public class GUI extends javax.swing.JFrame {

    private static final Logger LOGGER = LoggerFactory.getLogger(GUI.class);
    private static final int LARGE_FONT_SIZE = 18;
    private static final Dimension PREVIOUS_DESTINATION_DIMENSION = new Dimension(300, 20);
    private final Settings settings = Settings.getSettings();
    private final History history = History.getHistoryGUI();
    private final Properties dom = new Properties();
    private final Messenger msg = new Messenger();
    public final Engine utilities = new Engine();
    private final Backup backup = Backup.getBackup();
    private String source;
    private String destination;
    private String[] srcList = new String[0];
    private String[] status = {"UNKNOWN"};
    private String[] recentSrcPaths = new String[0];
    private String[] recentDestPaths = new String[0];
    private JLabel InfoLabel;
    private JCheckBoxMenuItem QuickBackupCheckBoxMenuItem;
    private JButton addButton;
    private JCheckBoxMenuItem checkFreeSpaceBeforeBackupMenuItem;
    private JCheckBoxMenuItem confirmExitCheckBoxMenuItem;
    private JMenuItem createDefaultConfigMenuItem;
    private JButton createSourceFileButton;
    private JCheckBoxMenuItem deleteSourceCheckBoxMenuItem;
    private JTextField destinationField;
    private JButton doBackupButton;
    private JCheckBoxMenuItem domMode;
    private JCheckBoxMenuItem exitProgramAfterBackupMenuItem;
    private JCheckBoxMenuItem happyModeCheckBoxMenuItem;
    private JButton mergeButton;
    private JComboBox<String> previousDestPathComboBox;
    private JComboBox<String> previousSrcPathComboBox;
    private JRadioButtonMenuItem priority_max_radioItem;
    private JRadioButtonMenuItem priority_min_radioItem;
    private JRadioButtonMenuItem priority_normal_radioItem;
    private JButton removeButton;
    private JCheckBoxMenuItem saveAsEncryptedCheckBoxMenuItem;
    private JCheckBoxMenuItem saveAsZipCheckBoxMenuItem;
    private JCheckBoxMenuItem saveResultToFileCheckBoxMenuItem;
    private JButton selectSourceButton;
    private JCheckBoxMenuItem shutdownAfterBackupMenuItem;
    private JTextField sourceField;
    private JLabel sourceFileLabel;
    private javax.swing.JList<String> sourceList;
    private JCheckBoxMenuItem speedLightModeMenuItem;
    private JMenuItem statusMenuItem;
    private JButton swapDestinationFolderPathButton;
    private JButton swapSourceFolderPathButton;

    public GUI() {
        LOGGER.info("Starting a program.");
        boot();
        initComponents();
        addonsForInitComponents();
        setup();
        setGui();
        LOGGER.info("Program started.");

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new GUI().setVisible(true));
    }

    void closeWindow() {
        this.dispose();
    }

    @SuppressWarnings("OverlyLongMethod") //UI setup
    private void initComponents() {

        JLabel jLabel1 = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        sourceList = new javax.swing.JList<>();
        JLabel jLabel2 = new JLabel();
        destinationField = new JTextField();
        addButton = new JButton();
        removeButton = new JButton();
        JButton selectDestinationButton = new JButton();
        doBackupButton = new JButton();
        sourceField = new JTextField();
        sourceFileLabel = new JLabel();
        selectSourceButton = new JButton();
        InfoLabel = new JLabel();
        createSourceFileButton = new JButton();
        mergeButton = new JButton();
        previousDestPathComboBox = new JComboBox<>();
        JLabel jLabel3 = new JLabel();
        swapDestinationFolderPathButton = new JButton();
        previousSrcPathComboBox = new JComboBox<>();
        swapSourceFolderPathButton = new JButton();
        JMenuBar jMenuBar1 = new JMenuBar();
        JMenu statusMenu = new JMenu();
        JMenuItem aboutMenuItem = new JMenuItem();
        JMenuItem exitMenuItem = new JMenuItem();
        statusMenuItem = new JMenuItem();
        JMenu settingsMenu = new JMenu();
        exitProgramAfterBackupMenuItem = new JCheckBoxMenuItem();
        deleteSourceCheckBoxMenuItem = new JCheckBoxMenuItem();
        QuickBackupCheckBoxMenuItem = new JCheckBoxMenuItem();
        confirmExitCheckBoxMenuItem = new JCheckBoxMenuItem();
        shutdownAfterBackupMenuItem = new JCheckBoxMenuItem();
        saveAsZipCheckBoxMenuItem = new JCheckBoxMenuItem();
        saveAsEncryptedCheckBoxMenuItem = new JCheckBoxMenuItem();
        saveResultToFileCheckBoxMenuItem = new JCheckBoxMenuItem();
        checkFreeSpaceBeforeBackupMenuItem = new JCheckBoxMenuItem();
        speedLightModeMenuItem = new JCheckBoxMenuItem();
        Separator jSeparator2 = new Separator();
        happyModeCheckBoxMenuItem = new JCheckBoxMenuItem();
        domMode = new JCheckBoxMenuItem();
        JMenu jMenu7 = new JMenu();
        priority_max_radioItem = new JRadioButtonMenuItem();
        priority_normal_radioItem = new JRadioButtonMenuItem();
        priority_min_radioItem = new JRadioButtonMenuItem();
        JMenu jMenu5 = new JMenu();
        createDefaultConfigMenuItem = new JMenuItem();
        JMenuItem clearSourceMenuItem = new JMenuItem();
        JMenuItem removeDuplicatesMenuItem = new JMenuItem();
        JMenuItem jMenuItem2 = new JMenuItem();
        JMenu tbpMenu = new JMenu();
        JMenu jMenu3 = new JMenu();
        JMenuItem workStartMenu = new JMenuItem();
        JMenuItem workEndMenu = new JMenuItem();
        Separator jSeparator1 = new Separator();
        JMenu jMenu4 = new JMenu();
        JMenuItem lap2USBMenu = new JMenuItem();
        JMenuItem lap2HDDMenu = new JMenuItem();
        JMenu jMenu6 = new JMenu();
        JMenuItem lap2ArchMenu = new JMenuItem();
        JMenuItem usb2LapMenu = new JMenuItem();
        JMenu jMenu1 = new JMenu();
        JMenuItem saveSettingsMenuItem = new JMenuItem();
        JMenuItem loadSettingsMenuItem = new JMenuItem();
        JMenuItem refreshSettingsMenuItem = new JMenuItem();
        JMenu jMenu2 = new JMenu();
        JMenuItem faqMenuItem = new JMenuItem();
        JMenuItem tutorialMenuItem = new JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("nanoBackup by Pastor Cmentarny");
        setFont(new Font("Corbel", BOLD, LARGE_FONT_SIZE));
        setMinimumSize(new java.awt.Dimension(444, 444));
        setName("main GUI frame");
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("What items (files and/or folders should be in backup?");

        sourceList.setModel(new SourceListModel());
        sourceList.setToolTipText("Source items");
        sourceList.setMaximumSize(getSourceItemsDimensionSize());
        sourceList.setMinimumSize(getSourceItemsDimensionSize());
        sourceList.setPreferredSize(getSourceItemsDimensionSize());
        jScrollPane1.setViewportView(sourceList);

        jLabel2.setText("Destination folder where backup will be stored:");

        destinationField.setToolTipText("destination folder");
        destinationField.setEnabled(false);
        destinationField.setMaximumSize(getDefaultFieldDimension());
        destinationField.setMinimumSize(getDefaultFieldDimension());
        destinationField.setPreferredSize(getDefaultFieldDimension());

        addButton.setText("Add");
        addButton.addActionListener(this::addButtonActionPerformed);

        removeButton.setText("Remove");
        removeButton.addActionListener(this::removeButtonActionPerformed);

        selectDestinationButton.setText("Change");
        selectDestinationButton.addActionListener(this::selectDestinationButtonActionPerformed);

        doBackupButton.setFont(new Font("Tahoma", BOLD, 14));
        doBackupButton.setText("Make Backup");
        doBackupButton.setPreferredSize(new java.awt.Dimension(128, 96));
        doBackupButton.setRolloverEnabled(false);
        doBackupButton.addActionListener(this::doBackupButtonActionPerformed);

        sourceField.setEditable(false);
        sourceField.setToolTipText("source file");
        sourceField.setMaximumSize(getDefaultFieldDimension());
        sourceField.setMinimumSize(getDefaultFieldDimension());
        sourceField.setPreferredSize(getDefaultFieldDimension());

        sourceFileLabel.setText("Source file that with folders to backup:");
        sourceFileLabel.setMaximumSize(getDefaultFieldDimension());
        sourceFileLabel.setMinimumSize(getDefaultFieldDimension());
        sourceFileLabel.setPreferredSize(getDefaultFieldDimension());
        sourceFileLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        selectSourceButton.setText("Change");
        selectSourceButton.addActionListener(this::selectSourceButtonActionPerformed);

        InfoLabel.setForeground(Color.RED);
        InfoLabel.setText("InfoBar");
        InfoLabel.setMaximumSize(new java.awt.Dimension(395, 14));
        InfoLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infoLabelMouseClicked(evt);
            }
        });

        createSourceFileButton.setText("Create new");
        createSourceFileButton.addActionListener(this::createSourceFileButtonActionPerformed);

        mergeButton.setText("Merge");
        mergeButton.addActionListener(this::mergeButtonActionPerformed);

        previousDestPathComboBox.setModel(new DefaultComboBoxModel<>(recentDestPaths));
        previousDestPathComboBox.setMaximumSize(PREVIOUS_DESTINATION_DIMENSION);
        previousDestPathComboBox.setMinimumSize(PREVIOUS_DESTINATION_DIMENSION);
        previousDestPathComboBox.setPreferredSize(PREVIOUS_DESTINATION_DIMENSION);

        jLabel3.setText("Swap destinations with  one of resent destination paths:");

        swapDestinationFolderPathButton.setText("Swap");
        swapDestinationFolderPathButton.addActionListener(this::swapDestinationFolderPathButtonActionPerformed);

        previousSrcPathComboBox.setModel(new DefaultComboBoxModel<>(recentSrcPaths));

        swapSourceFolderPathButton.setText("Swap");
        swapSourceFolderPathButton.addActionListener(this::swapSourceFolderPathButtonActionPerformed);

        statusMenu.setText("Program");

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        aboutMenuItem.setText("About");
        aboutMenuItem.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutMenuItemMouseClicked(evt);
            }
        });
        aboutMenuItem.addActionListener(this::aboutMenuItemActionPerformed);
        statusMenu.add(aboutMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(this::exitMenuItemActionPerformed);
        statusMenu.add(exitMenuItem);

        statusMenuItem.setText("STATUS:" + status[0] + "\n");
        statusMenuItem.addActionListener(this::statusMenuItemActionPerformed);
        statusMenu.add(statusMenuItem);

        jMenuBar1.add(statusMenu);

        settingsMenu.setText("Settings");

        exitProgramAfterBackupMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.ALT_DOWN_MASK));
        exitProgramAfterBackupMenuItem.setSelected(settings.isExitAfterBackup());
        exitProgramAfterBackupMenuItem.setText("Exit program after backup");
        exitProgramAfterBackupMenuItem.setToolTipText("If is selected,program will exit after finish backup (in all cases)");
        exitProgramAfterBackupMenuItem.addActionListener(this::exitProgramAfterBackupMenuItemActionPerformed);
        settingsMenu.add(exitProgramAfterBackupMenuItem);

        deleteSourceCheckBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_DOWN_MASK));
        deleteSourceCheckBoxMenuItem.setText("Clear source after backup");
        deleteSourceCheckBoxMenuItem.setSelected(settings.isDeleteSourceAfterBackup());
        deleteSourceCheckBoxMenuItem.addActionListener(this::deleteSourceCheckBoxMenuItemActionPerformed);
        settingsMenu.add(deleteSourceCheckBoxMenuItem);

        QuickBackupCheckBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.ALT_DOWN_MASK));
        QuickBackupCheckBoxMenuItem.setText("Quick Backup Only");
        QuickBackupCheckBoxMenuItem.setSelected(settings.isQuickBackup());
        QuickBackupCheckBoxMenuItem.addActionListener(this::quickBackupCheckBoxMenuItemActionPerformed);
        settingsMenu.add(QuickBackupCheckBoxMenuItem);

        confirmExitCheckBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        confirmExitCheckBoxMenuItem.setText("Confirm on exit");
        confirmExitCheckBoxMenuItem.setSelected(settings.isConfirmOnExit());
        confirmExitCheckBoxMenuItem.addActionListener(this::confirmExitCheckBoxMenuItemActionPerformed);
        settingsMenu.add(confirmExitCheckBoxMenuItem);

        shutdownAfterBackupMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.ALT_DOWN_MASK));
        shutdownAfterBackupMenuItem.setForeground(AppColor.DARK_ORANGE);
        shutdownAfterBackupMenuItem.setText("Shutdown a PC after backup(beta!)");
        shutdownAfterBackupMenuItem.setEnabled(false);
        settingsMenu.add(shutdownAfterBackupMenuItem);

        saveAsZipCheckBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.ALT_DOWN_MASK));
        saveAsZipCheckBoxMenuItem.setSelected(settings.isSaveAsZip());
        saveAsZipCheckBoxMenuItem.setText("Save a zip file (beta!)");
        saveAsZipCheckBoxMenuItem.setForeground(AppColor.DARK_ORANGE);
        saveAsZipCheckBoxMenuItem.addActionListener(this::saveAsZipCheckBoxMenuItemActionPerformed);
        settingsMenu.add(saveAsZipCheckBoxMenuItem);

        saveAsEncryptedCheckBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.event.InputEvent.ALT_DOWN_MASK));
        saveAsEncryptedCheckBoxMenuItem.setSelected(settings.isSaveAsEncrypted());
        saveAsZipCheckBoxMenuItem.setForeground(AppColor.DARK_ORANGE);
        saveAsEncryptedCheckBoxMenuItem.setText("Save as paranoid encrypted zip file");
        saveAsEncryptedCheckBoxMenuItem.setEnabled(false);
        saveAsEncryptedCheckBoxMenuItem.addActionListener(this::saveAsEncryptedCheckBoxMenuItemActionPerformed);
        settingsMenu.add(saveAsEncryptedCheckBoxMenuItem);

        saveResultToFileCheckBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, java.awt.event.InputEvent.ALT_DOWN_MASK));
        saveResultToFileCheckBoxMenuItem.setSelected(settings.isSaveResultsToFile());
        saveResultToFileCheckBoxMenuItem.setText("Save results to file");
        saveResultToFileCheckBoxMenuItem.addActionListener(this::saveResultToFileCheckBoxMenuItemActionPerformed);
        settingsMenu.add(saveResultToFileCheckBoxMenuItem);

        checkFreeSpaceBeforeBackupMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.event.InputEvent.ALT_DOWN_MASK));
        checkFreeSpaceBeforeBackupMenuItem.setSelected(settings.isCheckFreeSpaceBeforeBackup());
        checkFreeSpaceBeforeBackupMenuItem.setText("Check free space before backup");
        checkFreeSpaceBeforeBackupMenuItem.addActionListener(this::checkFreeSpaceBeforeBackupMenuItemActionPerformed);
        settingsMenu.add(checkFreeSpaceBeforeBackupMenuItem);

        speedLightModeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9, java.awt.event.InputEvent.ALT_DOWN_MASK));
        speedLightModeMenuItem.setText("Speed Light mode");
        speedLightModeMenuItem.setForeground(AppColor.DARK_ORANGE);
        speedLightModeMenuItem.setSelected(settings.isSpeedLightMode());
        speedLightModeMenuItem.addActionListener(this::speedLightModeMenuItemActionPerformed);
        settingsMenu.add(speedLightModeMenuItem);
        settingsMenu.add(jSeparator2);

        happyModeCheckBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        happyModeCheckBoxMenuItem.setText("happy mode");
        happyModeCheckBoxMenuItem.setSelected(settings.isHappyMode());
        happyModeCheckBoxMenuItem.addActionListener(this::happyModeCheckBoxMenuItemActionPerformed);
        settingsMenu.add(happyModeCheckBoxMenuItem);

        domMode.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        domMode.setText("dom mode");
        domMode.addItemListener(this::domModeItemStateChanged);
        settingsMenu.add(domMode);

        jMenu7.setText("Backup priority");

        priority_max_radioItem.setMnemonic('1');
        priority_max_radioItem.setText("MAX");
        priority_max_radioItem.addActionListener(this::priorityMaxRadioItemActionPerformed);
        jMenu7.add(priority_max_radioItem);

        priority_normal_radioItem.setSelected(true);
        priority_normal_radioItem.setText("NORMAL");
        priority_normal_radioItem.addActionListener(this::priorityNormalRadioItemActionPerformed);
        jMenu7.add(priority_normal_radioItem);

        priority_min_radioItem.setText("MIN");
        priority_min_radioItem.addActionListener(this::priorityMinRadioItemActionPerformed);
        jMenu7.add(priority_min_radioItem);

        settingsMenu.add(jMenu7);

        jMenuBar1.add(settingsMenu);

        jMenu5.setText("Task");

        createDefaultConfigMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.ALT_DOWN_MASK));
        createDefaultConfigMenuItem.setText("Create default config");
        createDefaultConfigMenuItem.setEnabled(!settings.isQuickBackup());
        createDefaultConfigMenuItem.addActionListener(this::createDefaultConfigMenuItemActionPerformed);
        jMenu5.add(createDefaultConfigMenuItem);

        clearSourceMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.ALT_DOWN_MASK));
        clearSourceMenuItem.setText("Clear non exist files");
        clearSourceMenuItem.addActionListener(this::clearSourceMenuItemActionPerformed);
        jMenu5.add(clearSourceMenuItem);

        removeDuplicatesMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, java.awt.event.InputEvent.ALT_DOWN_MASK));
        removeDuplicatesMenuItem.setText("Remove duplicates");
        removeDuplicatesMenuItem.addActionListener(this::removeDuplicatesMenuItemActionPerformed);
        jMenu5.add(removeDuplicatesMenuItem);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem2.setText("TaskEditor");
        jMenuItem2.setEnabled(false);
        jMenu5.add(jMenuItem2);

        tbpMenu.setText("domTBP");
        tbpMenu.setEnabled(false);

        jMenu3.setText("Work");

        workStartMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        workStartMenu.setText("Work(Start)");
        workStartMenu.addActionListener(this::workStartMenuActionPerformed);
        jMenu3.add(workStartMenu);

        workEndMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        workEndMenu.setText("Work(End)");
        workEndMenu.addActionListener(this::workEndMenuActionPerformed);
        jMenu3.add(workEndMenu);

        tbpMenu.add(jMenu3);
        tbpMenu.add(jSeparator1);

        jMenu4.setText("Home(Laptop)");

        lap2USBMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        lap2USBMenu.setText("To USB");
        lap2USBMenu.addActionListener(this::lap2USBMenuActionPerformed);
        jMenu4.add(lap2USBMenu);

        lap2HDDMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        lap2HDDMenu.setText("To HDD");
        lap2HDDMenu.addActionListener(this::lap2HDDMenuActionPerformed);
        jMenu4.add(lap2HDDMenu);

        tbpMenu.add(jMenu4);

        jMenu6.setText("Home(USB)");

        lap2ArchMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        lap2ArchMenu.setText("To Archive");
        lap2ArchMenu.addActionListener(this::lap2ArchMenuActionPerformed);
        jMenu6.add(lap2ArchMenu);

        usb2LapMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        usb2LapMenu.setText("ToLaptop");
        usb2LapMenu.addActionListener(this::usb2LapMenuActionPerformed);
        jMenu6.add(usb2LapMenu);

        tbpMenu.add(jMenu6);

        jMenu5.add(tbpMenu);

        jMenu1.setText("Save/Load settings");

        saveSettingsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, java.awt.event.InputEvent.ALT_DOWN_MASK));
        saveSettingsMenuItem.setText("save settings (beta!)");
        saveSettingsMenuItem.setForeground(AppColor.DARK_ORANGE);
        saveSettingsMenuItem.addActionListener(this::saveSettingsMenuItemActionPerformed);
        jMenu1.add(saveSettingsMenuItem);

        loadSettingsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, java.awt.event.InputEvent.ALT_DOWN_MASK));
        loadSettingsMenuItem.setText("load settings(beta!)");
        loadSettingsMenuItem.addActionListener(this::loadSettingsMenuItemActionPerformed);
        jMenu1.add(loadSettingsMenuItem);

        refreshSettingsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, java.awt.event.InputEvent.ALT_DOWN_MASK));
        refreshSettingsMenuItem.setText("refresh settings(beta!)");
        refreshSettingsMenuItem.setEnabled(false);
        refreshSettingsMenuItem.addActionListener(this::refreshSettingsMenuItemActionPerformed);
        jMenu1.add(refreshSettingsMenuItem);

        jMenu5.add(jMenu1);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Help");

        faqMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_DOWN_MASK));
        faqMenuItem.setText("FAQ");
        faqMenuItem.addActionListener(this::fAQMenuItemActionPerformed);
        jMenu2.add(faqMenuItem);

        tutorialMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.ALT_DOWN_MASK));
        tutorialMenuItem.setText("Tutorial");
        tutorialMenuItem.addActionListener(this::tutorialMenuItemActionPerformed);
        jMenu2.add(tutorialMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(InfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 57, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(sourceFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(sourceField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(previousSrcPathComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(destinationField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(previousDestPathComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(swapDestinationFolderPathButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(selectDestinationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(swapSourceFolderPathButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(mergeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(selectSourceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(createSourceFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(doBackupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(addButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mergeButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(removeButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(doBackupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(createSourceFileButton)
                                        .addComponent(sourceFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(selectSourceButton)
                                        .addComponent(sourceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(previousSrcPathComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(swapSourceFolderPathButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(destinationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectDestinationButton))
                                .addGap(1, 1, 1)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(previousDestPathComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(swapDestinationFolderPathButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(InfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private Dimension getDefaultFieldDimension() {
        return new Dimension(280, 20);
    }

    private Dimension getSourceItemsDimensionSize() {
        return new Dimension(280, 160);
    }

    @SuppressWarnings("unused") //don't need evt in this context
    private void doBackupButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_doBackupButtonActionPerformed
        if (backup.isInProgress()) {
            utilities.setInfoLabel(AppColor.DARK_ORANGE, "Another backup in progress.Please wait until previous backup is done", InfoLabel);
        } else {
            LOGGER.debug("Doing backup using:\n\tsource file:" + sourceField.getText() + "\n\tdestination folder:" + destinationField.getText());
            backup.backupGui(utilities.makeList(sourceField.getText()), destinationField.getText(), this);
            this.toBack();
            utilities.setInfoLabel(Color.BLUE, "Backup task ended.(See BackupTask window for details)", InfoLabel);
            setGui();
        }
    }

    private void selectSourceButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_selectSourceButtonActionPerformed
        String tempSource = utilities.chooseFileToLoad();
        if (FileUtils.isFileExists(tempSource)) {
            sourceField.setText(tempSource);
            srcList = utilities.makeList(tempSource);
            srcList = TaskUtils.removeNonExistsItems(srcList);
            settings.setSourceFilePath(tempSource);
            settings.setProperties(true);
            recentSrcPaths = utilities.updateRecentFolderPaths(recentSrcPaths, tempSource);
            FileUtils.saveListToFile(recentSrcPaths, Constants.RECENT_SRC_PATHS_FILE);
            utilities.setInfoLabel(AppColor.DARK_GREEN, "Source file set to " + tempSource, InfoLabel);
        } else {
            utilities.setInfoLabel(Color.RED, "Action cancelled", InfoLabel);
        }
        refreshContent();
        setGui();

    }

    private void selectDestinationButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_selectDestinationButtonActionPerformed
        String tempSource = FileTools.chooseDirToLoad();
        if (tempSource != null) {
            destinationField.setText(tempSource);
            settings.setDestinationFolderPath(tempSource);
            settings.setProperties(true);
            recentDestPaths = utilities.updateRecentFolderPaths(recentDestPaths, tempSource);
            FileUtils.saveListToFile(recentDestPaths, Constants.RECENT_DEST_PATHS_FILE);

            InfoLabel.setForeground(AppColor.DARK_GREEN);
            InfoLabel.setText("Destination folder is set to: " + tempSource);
        } else {
            InfoLabel.setForeground(Color.RED);
            InfoLabel.setText("Destination folder is not changed.");
        }
        refreshContent();
        setGui();

    }

    private void createDefaultConfigMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_createDefaultConfigMenuItemActionPerformed
        if (settings.createDefaultSettings()) {
            sourceField.setText(settings.getSourceFilePath());
            srcList = utilities.makeList(settings.getSourceFilePath());
            destinationField.setText(settings.getDestinationFolderPath());
            destination = settings.getDestinationFolderPath();
            utilities.setInfoLabel(AppColor.DARK_GREEN, "Default config was used to create source/destination path.", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.RED, "Unable to create default config.Please reinstall program!", InfoLabel);
        }
        refreshContent();
        setGui();
    }

    private void exitMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        settings.setProperties(true);
        utilities.shutdown("exitByUser");
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_AboutMenuItemActionPerformed
        new About().setVisible(true);
    }//GEN-LAST:event_AboutMenuItemActionPerformed

    private void addButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String[] addFileResult = utilities.addItemsToItemsList(srcList, sourceField, "item");
        if (addFileResult != null) {
            srcList = addFileResult;
            if (FileUtils.saveListToFile(srcList, sourceField.getText())) {
                InfoLabel.setText("List was saved to file.");
            } else {
                InfoLabel.setText("List was NOT saved to file.");
                JOptionPane.showMessageDialog(null, msg.getMsg("error.createFile"), "Whoops!", JOptionPane.ERROR_MESSAGE);
            }
            refreshContent();
            setGui();
            InfoLabel.setForeground(AppColor.DARK_GREEN);
            if (addFileResult.length == 1) {
                InfoLabel.setText("Item added." + InfoLabel.getText());
            } else {
                InfoLabel.setText("Items added." + InfoLabel.getText());
            }
        } else {
            utilities.setInfoLabel(Color.RED, "I'm afraid.Item(s) were NOT added.", InfoLabel);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void fAQMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_FAQMenuItemActionPerformed
        FaqGUI faq = new FaqGUI();
        faq.setVisible(true);
    }//GEN-LAST:event_FAQMenuItemActionPerformed

    private void removeButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        String[] temp = srcList;
        srcList = utilities.removeItemsFromList(srcList, sourceList);
        if (srcList != null) {
            //change ?
            FileUtils.saveListToFile(srcList, sourceField.getText());
            removeButton.setEnabled(true);
            refreshContent();
            setGui();
        }

        if (Arrays.equals(temp, srcList)) {
            utilities.setInfoLabel(AppColor.DARK_ORANGE, "Nothing was removed.", InfoLabel);
        } else {
            utilities.setInfoLabel(AppColor.DARK_GREEN, "Item(s) was removed from list.", InfoLabel);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void domModeItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_domModeItemStateChanged
        if (domMode.isSelected()) {
            utilities.setInfoLabel(Tools.getRandomColor(), "dom Mode activated.", InfoLabel);
        } else {
            utilities.setInfoLabel(Tools.getRandomColor(), "dom Mode deactivated.", InfoLabel);
        }
        setGui();
    }//GEN-LAST:event_domModeItemStateChanged

    private void workEndMenuActionPerformed(ActionEvent evt) {//GEN-FIRST:event_workEndMenuActionPerformed
        utilities.setInfoLabel(Color.BLACK, "WORK.END: doing backup...", InfoLabel);
        backup.backupGui(utilities.makeList(dom.getProperty("dom.source.work.end")), dom.getProperty("dom.destination.word.end"), this);
        utilities.setInfoLabel(Color.BLACK, "WORK.END backup task ended.", InfoLabel);
        InfoLabel.setText("");

    }//GEN-LAST:event_workEndMenuActionPerformed

    private void lap2ArchMenuActionPerformed(ActionEvent evt) {//GEN-FIRST:event_Lap2ArchMenuActionPerformed
        utilities.setInfoLabel(Color.BLACK, "USB2HDD: doing backup", InfoLabel);
        backup.backupGui(utilities.makeList(dom.getProperty("dom.source.usb.hdd")), dom.getProperty("dom.destination.usb.hdd"), this);
        utilities.setInfoLabel(Color.BLACK, "USB2HDD backup task ended.", InfoLabel);
    }//GEN-LAST:event_Lap2ArchMenuActionPerformed

    private void lap2USBMenuActionPerformed(ActionEvent evt) {//GEN-FIRST:event_Lap2USBMenuActionPerformed
        utilities.setInfoLabel(Color.BLACK, "LAP2USB: doing backup", InfoLabel);
        backup.backupGui(utilities.makeList(dom.getProperty("dom.source.lap.usb")), dom.getProperty("dom.destination.lap.usb"), this);
        utilities.setInfoLabel(Color.BLACK, "LAP2USB backup task ended.", InfoLabel);
    }//GEN-LAST:event_Lap2USBMenuActionPerformed

    private void workStartMenuActionPerformed(ActionEvent evt) {//GEN-FIRST:event_WorkStartMenuActionPerformed
        utilities.setInfoLabel(Color.BLACK, "WORK.START: job started.", InfoLabel);
        settings.setDomJobs(dom.getProperty("dom.source.work.start.before"), dom.getProperty("dom.source.work.start.after"));
        backup.backupGui(utilities.makeList(dom.getProperty("dom.source.work.start")), dom.getProperty("dom.destination.work.start"), this);
        utilities.setInfoLabel(Color.BLACK, "WORK.START  job ended.", InfoLabel);
    }

    private void tutorialMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_tutorialMenuItemActionPerformed
        JOptionPane.showMessageDialog(null, msg.getMsg("tutorial"), "Tutorial", JOptionPane.INFORMATION_MESSAGE);
    }

    private void createSourceFileButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_createSourceFileButtonActionPerformed
        String result = FileTools.createSourceFile(Settings.SRC_FILE_ENDING);
        if (result == null) {
            utilities.setInfoLabel(Color.RED, "File was NOT created.", InfoLabel);
        } else {
            utilities.setInfoLabel(AppColor.DARK_GREEN, "Source file: " + result + " was created.", InfoLabel);
            recentSrcPaths = utilities.updateRecentFolderPaths(recentSrcPaths, sourceField.getText());
            FileUtils.saveListToFile(recentSrcPaths, Constants.RECENT_SRC_PATHS_FILE);
            sourceField.setText(result);
            settings.setSourceFilePath(result);
            settings.setProperties(true);
            srcList = new String[0];
        }
        refreshContent();
        setGui();
    }//GEN-LAST:event_createSourceFileButtonActionPerformed

    private void lap2HDDMenuActionPerformed(ActionEvent evt) {//GEN-FIRST:event_Lap2HDDMenuActionPerformed
        InfoLabel.setForeground(Color.BLACK);
        InfoLabel.setText("LAP2HDD: doing backup");
        boolean result = FileTools.copyFolder(new File(dom.getProperty("dom.source.lap.hdd")), new File(dom.getProperty("dom.destination.lap.hdd")), null);
        if (result) {
            utilities.setInfoLabel(AppColor.DARK_GREEN, "LAP2HDD backup was done successfully.", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.RED, "Program was unable to create backup", InfoLabel);
        }
    }//GEN-LAST:event_Lap2HDDMenuActionPerformed

    private void usb2LapMenuActionPerformed(ActionEvent evt) {//GEN-FIRST:event_USB2LapMenuActionPerformed
        InfoLabel.setText("USB2LAP: doing backup");
        //TODO CHANGE IT!
        String tempResponse = backup.doClassicBackup(utilities.makeList(dom.getProperty("dom.source.usb.lap")), dom.getProperty("dom.destination.usb.lap"), null);
        JOptionPane.showMessageDialog(null, tempResponse, "Results", JOptionPane.INFORMATION_MESSAGE);
        utilities.setInfoLabel(AppColor.DARK_GREEN, "USB2LAP backup was done successfully.", InfoLabel);
    }//GEN-LAST:event_USB2LapMenuActionPerformed

    private void aboutMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutMenuItemMouseClicked
        new About().setVisible(true);
    }//GEN-LAST:event_AboutMenuItemMouseClicked

    private void clearSourceMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_clearSourceMenuItemActionPerformed
        srcList = TaskUtils.removeNonExistsItems(srcList);
        FileUtils.saveListToFile(srcList, sourceField.getText());
        removeButton.setEnabled(true);
        refreshContent();
        setGui();
        utilities.setInfoLabel(Color.BLUE, "Source list is cleaned from non existing files/folders.", InfoLabel);
    }//GEN-LAST:event_clearSourceMenuItemActionPerformed

    private void exitProgramAfterBackupMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_exitProgramAfterBackupMenuItemActionPerformed
        settings.setExitAfterBackup(exitProgramAfterBackupMenuItem.isSelected());
        settings.setProperties(true);
        if (exitProgramAfterBackupMenuItem.isSelected()) {
            setGui();
            utilities.setInfoLabel(Color.BLUE, "Program will exit when backup is finished.", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.BLUE, "Program will back to this screen when backup is finished.", InfoLabel);
        }
    }

    private void removeDuplicatesMenuItemActionPerformed(ActionEvent evt) {
        srcList = TaskUtils.removeDuplicateLines(srcList);
        FileUtils.saveListToFile(srcList, source);
        utilities.setInfoLabel(AppColor.DARK_GREEN, "Duplicate lines in source file are removed.", InfoLabel);
        refreshContent();
        setGui();
    }//GEN-LAST:event_removeDuplicatesMenuItemActionPerformed

    private void quickBackupCheckBoxMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_QuickBackupCheckBoxMenuItemActionPerformed
        settings.setQuickBackup(QuickBackupCheckBoxMenuItem.isSelected());
        if (quickBackupMode(QuickBackupCheckBoxMenuItem.isSelected())) {
            utilities.setInfoLabel(Color.BLUE, "Quick backup enabled.(Source file is NOT needed to make Backup)", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.DARK_GRAY, "Quick backup disabled.(Source file is  needed to make Backup)", InfoLabel);
        }
        refreshContent();
        setGui();
    }//GEN-LAST:event_QuickBackupCheckBoxMenuItemActionPerformed

    private void deleteSourceCheckBoxMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_deleteSourceCheckBoxMenuItemActionPerformed
        settings.setDeleteSourceAfterBackup(deleteSourceCheckBoxMenuItem.isSelected());
        settings.setProperties(true);
        if (deleteSourceCheckBoxMenuItem.isSelected()) {
            utilities.setInfoLabel(AppColor.DARK_ORANGE, "Source item(s) will be deleted after backup.(It cannot be undone!)", InfoLabel);
        } else {
            utilities.setInfoLabel(AppColor.DARK_GREEN, "Source item(s) will stay untouched after backup.", InfoLabel);
        }
    }//GEN-LAST:event_deleteSourceCheckBoxMenuItemActionPerformed

    private void confirmExitCheckBoxMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_confirmExitCheckBoxMenuItemActionPerformed
        settings.setConfirmOnExit(confirmExitCheckBoxMenuItem.isSelected());
        settings.setProperties(true);
        if (exitProgramAfterBackupMenuItem.isSelected()) {
            utilities.setInfoLabel(Color.BLUE, "Program will exit when backup is finished.", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.BLUE, "Program will back to this screen when backup is finished.", InfoLabel);
        }
    }

    private void happyModeCheckBoxMenuItemActionPerformed(ActionEvent evt) {
        InfoLabel.setForeground(AppColor.DARK_GREEN);
        settings.setHappyMode(happyModeCheckBoxMenuItem.isSelected());
        settings.setProperties(true);
        if (happyModeCheckBoxMenuItem.isSelected()) {
            utilities.setInfoLabel(Color.BLUE, "happy mode is activated.(It works only if speed light mode is disabled)", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.DARK_GRAY, "Happy mode is deactivated.", InfoLabel);
        }

    }

    private void mergeButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_mergeButtonActionPerformed
        String[] itemsList = utilities.merge2Source(srcList);
        if (itemsList != null) {
            srcList = TaskUtils.removeDuplicateLines(itemsList);
            FileUtils.saveListToFile(srcList, sourceField.getText());
            settings.setProperties(true);
            utilities.setInfoLabel(AppColor.DARK_GREEN, "Selected source file was merged into item list.", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.RED, "Action cancelled.", InfoLabel);
        }
        refreshContent();
        setGui();
    }//GEN-LAST:event_mergeButtonActionPerformed

    private void statusMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_statusMenuItemActionPerformed
        Tools.showStatus(status);
    }//GEN-LAST:event_statusMenuItemActionPerformed

    private void formWindowClosing(WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //log.debug();
        utilities.shutdown("");
    }//GEN-LAST:event_formWindowClosing

    private void saveAsZipCheckBoxMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_saveAsZipCheckBoxMenuItemActionPerformed
        settings.setSaveAsZip(saveAsZipCheckBoxMenuItem.isSelected());
        settings.setProperties(true);
        if (deleteSourceCheckBoxMenuItem.isSelected()) {
            utilities.setInfoLabel(AppColor.DARK_GREEN, "Backup will be saved as compressed zip file.", InfoLabel);
            //TODO; remove below dialog when zip feature will be completely implemented
            JOptionPane.showMessageDialog(null, "This is beta feature!\nIt has some known issues,which cause disasters! See changelog .. ", "WARNING", JOptionPane.INFORMATION_MESSAGE);
        } else {
            utilities.setInfoLabel(AppColor.DARK_GREEN, "Backup will be saved as folder.", InfoLabel);
        }
    }//GEN-LAST:event_saveAsZipCheckBoxMenuItemActionPerformed

    private void swapDestinationFolderPathButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_swapDestinationFolderPathButtonActionPerformed
        if (Objects.nonNull(previousDestPathComboBox) && Objects.nonNull(previousDestPathComboBox.getSelectedItem())) {
            String temp = previousDestPathComboBox.getSelectedItem().toString();
            if (FileUtils.isDirectoryExists(temp)) {
                utilities.swapDestFolderPaths(recentDestPaths, temp, destinationField.getText());
                destinationField.setText(previousDestPathComboBox.getSelectedItem().toString());
                settings.setDestinationFolderPath(previousDestPathComboBox.getSelectedItem().toString());
                settings.setProperties(true);
                refreshContent();
                setGui();
                utilities.setInfoLabel(AppColor.DARK_GREEN, "Destination folder path is swapped.", InfoLabel);
            } else {
                utilities.setInfoLabel(Color.RED, "Selected destination path doesn't exist.", InfoLabel);
            }
        } else {
            utilities.setInfoLabel(Color.RED, "Selected destination path doesn't exist.", InfoLabel);
        }
    }//GEN-LAST:event_swapDestinationFolderPathButtonActionPerformed

    private void saveResultToFileCheckBoxMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_saveResultToFileCheckBoxMenuItemActionPerformed
        settings.setSaveResultsToFile(saveResultToFileCheckBoxMenuItem.isSelected());
        settings.setProperties(true);
        if (saveResultToFileCheckBoxMenuItem.isSelected()) {
            utilities.setInfoLabel(Color.BLUE, "Program will save results to file.", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.BLUE, "Program will NOT save results to file.", InfoLabel);
        }
    }//GEN-LAST:event_saveResultToFileCheckBoxMenuItemActionPerformed

    private void infoLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InfoLabelMouseClicked
        history.showHistoryOfMessages();
    }//GEN-LAST:event_InfoLabelMouseClicked

    private void checkFreeSpaceBeforeBackupMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_checkFreeSpaceBeforeBackupMenuItemActionPerformed
        settings.setCheckFreeSpaceBeforeBackup(checkFreeSpaceBeforeBackupMenuItem.isSelected());
        settings.setProperties(true);
        if (checkFreeSpaceBeforeBackupMenuItem.isSelected()) {
            utilities.setInfoLabel(Color.BLUE, "Program will check free space before backup.(Takes more time).", InfoLabel);
        } else {
            utilities.setInfoLabel(AppColor.DARK_ORANGE, "Program will NOT check free space before backup.(Quicker backup).", InfoLabel);
        }
    }//GEN-LAST:event_checkFreeSpaceBeforeBackupMenuItemActionPerformed

    private void saveSettingsMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_saveSettingsMenuItemActionPerformed
        String result = settings.saveSettingsWithDestSelection();
        if (result != null) {
            settings.setProperties(true);
            settings.saveProperties();
            refreshContent();
            setGui();
            utilities.setInfoLabel(AppColor.DARK_GREEN, "Setting file: " + result + " was saved.", InfoLabel);

        } else {
            utilities.setInfoLabel(AppColor.DARK_ORANGE, "Unable to save.", InfoLabel);
        }


    }//GEN-LAST:event_saveSettingsMenuItemActionPerformed

    private void speedLightModeMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_speedLightModeMenuItemActionPerformed
        settings.setSpeedLightMode(speedLightModeMenuItem.isSelected());
        settings.setProperties(true);
        settings.saveProperties();
        if (speedLightModeMenuItem.isSelected()) {
            utilities.setInfoLabel(Color.BLUE, "Speed light mode activated.", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.BLUE, "Speed light mode deactivated.", InfoLabel);        // TODO add your handling code here:
        }
    }//GEN-LAST:event_speedLightModeMenuItemActionPerformed

    private void swapSourceFolderPathButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_swapSourceFolderPathButtonActionPerformed
        if (Objects.nonNull(previousSrcPathComboBox) && Objects.nonNull(previousSrcPathComboBox.getSelectedItem())) {
            String temp = previousSrcPathComboBox.getSelectedItem().toString();
            if (FileUtils.isFileExists(temp)) {
                utilities.swapDestFolderPaths(recentSrcPaths, temp, sourceField.getText());
                sourceField.setText(previousSrcPathComboBox.getSelectedItem().toString());
                srcList = utilities.makeList(previousSrcPathComboBox.getSelectedItem().toString());
                srcList = TaskUtils.removeNonExistsItems(srcList);
                recentSrcPaths = utilities.updateRecentFolderPaths(recentSrcPaths, previousSrcPathComboBox.getSelectedItem().toString());
                settings.setSourceFilePath(previousSrcPathComboBox.getSelectedItem().toString());
                settings.setProperties(true);
                refreshContent();
                setGui();
                utilities.setInfoLabel(AppColor.DARK_GREEN, "Source folder path is swapped.", InfoLabel);
            } else {
                utilities.setInfoLabel(Color.RED, "Selected Source path doesn't exist.", InfoLabel);
            }
        } else {
            utilities.setInfoLabel(Color.RED, "Selected Source path doesn't exist.", InfoLabel);
        }
    }//GEN-LAST:event_swapSourceFolderPathButtonActionPerformed

    private void loadSettingsMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_loadSettingsMenuItemActionPerformed
        //TODO test it!
        String path = FileTools.chooseFileToLoad();
        if (path != null) {
            if (settings.loadSettings(path, rootPaneCheckingEnabled)) {
                if (StringUtils.isNotBlank(sourceField.getText())) {
                    settings.setSourceFilePath(sourceField.getText());
                }

                if (StringUtils.isNotBlank(destinationField.getText())) {
                    settings.setDestinationFolderPath(destinationField.getText());
                }

                recentDestPaths = utilities.makeList(Constants.RECENT_DEST_PATHS_FILE);
                settings.setProperties(true);
                settings.saveProperties();
                refreshContent();
                setGui();
                utilities.setInfoLabel(AppColor.DARK_ORANGE, "Settings loaded and set.", InfoLabel);
            } else {
                utilities.setInfoLabel(AppColor.DARK_ORANGE, "Unable to load settings due error.", InfoLabel);
            }

        } else {
            utilities.setInfoLabel(AppColor.DARK_ORANGE, "Load settings was cancelled", InfoLabel);
        }
    }//GEN-LAST:event_loadSettingsMenuItemActionPerformed

    private void refreshSettingsMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_refreshSettingsMenuItemActionPerformed

        boolean loaded = settings.loadSettings(true);
        if (loaded) {
            settings.validateProperties(true);
            refreshContent();
            setGui();        // TODO add your handling code here:
            utilities.setInfoLabel(AppColor.DARK_GREEN, "Settings refreshed.", InfoLabel);
        } else {
            utilities.setInfoLabel(AppColor.DARK_ORANGE, "Unable to refresh settings!", InfoLabel);
        }

    }//GEN-LAST:event_refreshSettingsMenuItemActionPerformed

    private void saveAsEncryptedCheckBoxMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_saveAsEncryptedCheckBoxMenuItemActionPerformed
        settings.setSaveAsEncrypted(saveAsEncryptedCheckBoxMenuItem.isSelected());
        settings.setProperties(true);
        if (saveAsEncryptedCheckBoxMenuItem.isSelected()) {
            JOptionPane.showMessageDialog(null, "CAUTION!\nUse this only for file (few files).\n Keep in mind,that it will take ages to finish this backup.\n\n This mode is designed only for ", "WARNING!", JOptionPane.ERROR_MESSAGE);
            utilities.setInfoLabel(AppColor.DARK_GREEN, "Backup will be saved as compressed zip file.", InfoLabel);
            //TODO; remove below dialog when zip feature will be completely implemented
            JOptionPane.showMessageDialog(null, "This is beta feature!\nIt has some known issues,which cause disasters! See changelog .. ", "WARNING", JOptionPane.INFORMATION_MESSAGE);
        } else {
            utilities.setInfoLabel(AppColor.DARK_GREEN, "Backup will be saved as encrypted archive file.", InfoLabel);
        }
    }//GEN-LAST:event_saveAsEncryptedCheckBoxMenuItemActionPerformed

    private void priorityMaxRadioItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_priority_max_radioItemActionPerformed
        settings.setCpuPriority(2);
        settings.setProperties(true);
        utilities.setInfoLabel(AppColor.DARK_BLUE, "Backup will used highest cpu priority.", InfoLabel);
    }//GEN-LAST:event_priority_max_radioItemActionPerformed

    private void priorityNormalRadioItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_priority_normal_radioItemActionPerformed
        settings.setCpuPriority(1);
        settings.setProperties(true);
        utilities.setInfoLabel(AppColor.DARK_BLUE, "Backup will used normal cpu priority.", InfoLabel);
    }//GEN-LAST:event_priority_normal_radioItemActionPerformed

    private void priorityMinRadioItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_priority_min_radioItemActionPerformed
        settings.setCpuPriority(0);
        settings.setProperties(true);
        utilities.setInfoLabel(AppColor.DARK_BLUE, "Backup will used lowest priority.", InfoLabel);
    }//GEN-LAST:event_priority_min_radioItemActionPerformed


    private void refreshContent() {
        LOGGER.debug("refreshing GUI content...");
        //SOURCE LIST
        sourceList.setModel(new SourceListModel());

        //SOURCE AND DESTINATION PATHS LIST
        previousSrcPathComboBox.setModel(new DefaultComboBoxModel<>(recentSrcPaths));
        previousDestPathComboBox.setModel(new DefaultComboBoxModel<>(recentDestPaths));

        //SETTINGS        
        exitProgramAfterBackupMenuItem.setSelected(settings.isExitAfterBackup());
        deleteSourceCheckBoxMenuItem.setSelected(settings.isDeleteSourceAfterBackup());
        QuickBackupCheckBoxMenuItem.setSelected(settings.isQuickBackup());
        confirmExitCheckBoxMenuItem.setSelected(settings.isConfirmOnExit());
        shutdownAfterBackupMenuItem.setSelected(settings.isShutdownAfterBackup());
        saveAsZipCheckBoxMenuItem.setSelected(settings.isSaveAsZip());
        saveAsEncryptedCheckBoxMenuItem.setSelected(settings.isSaveAsEncrypted());
        saveResultToFileCheckBoxMenuItem.setSelected(settings.isSaveResultsToFile());
        checkFreeSpaceBeforeBackupMenuItem.setSelected(settings.isCheckFreeSpaceBeforeBackup());
        speedLightModeMenuItem.setSelected(settings.isSpeedLightMode());
        happyModeCheckBoxMenuItem.setSelected(settings.isHappyMode());


    }

    private void setGui() {

        //CREATE DEFAULT 
        createDefaultConfigMenuItem.setEnabled(!settings.isQuickBackup());

        //ADD/MERGE BUTTON

        boolean enabled = sourceField == null || StringUtils.isStringEmpty(sourceField.getText());
        addButton.setEnabled(enabled);
        mergeButton.setEnabled(enabled);

        removeButton.setEnabled(srcList.length != 0);

        //QUICK BACKUP MODE
        if (QuickBackupCheckBoxMenuItem.isSelected()) {
            sourceField.setVisible(false);
            createSourceFileButton.setVisible(false);
            selectSourceButton.setVisible(false);
            sourceFileLabel.setVisible(false);
        } else {
            sourceField.setVisible(true);
            createSourceFileButton.setVisible(true);
            selectSourceButton.setVisible(true);
            sourceFileLabel.setVisible(true);
        }

        //SWAP BUTTONS
        if (previousSrcPathComboBox.getModel().getSize() == 0) {
            swapSourceFolderPathButton.setEnabled(false);
        } else {
            swapSourceFolderPathButton.setEnabled(true);
        }
        if (previousDestPathComboBox.getModel().getSize() == 0) {
            swapDestinationFolderPathButton.setEnabled(false);
        } else {
            swapDestinationFolderPathButton.setEnabled(true);
        }

        //DO BACKUP BUTTON
        if (StringUtils.isStringBlank(destinationField.getText()) || sourceList.getModel().getSize() == 0) {
            doBackupButton.setEnabled(false);
        } else {
            if (QuickBackupCheckBoxMenuItem.isSelected()) {
                doBackupButton.setEnabled(true);
            } else {
                if (StringUtils.isStringBlank(sourceField.getText())) {
                    doBackupButton.setEnabled(false);
                } else {
                    doBackupButton.setEnabled(true);
                }
            }
        }
    }

    private void boot() {
        LOGGER.debug("Program starting:\tSetup in progress...");
        status = utilities.itselfHealthScan();
        if ("ERROR".equals(status[0])) {
            LOGGER.warn("Program is damaged.");
        }

        if (!FileUtils.isFileExists(Constants.SETTINGS_PATH)) {
            settings.createDefaultSettings();
        }

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage() + "\n\n" + ex.getCause());
            JOptionPane.showMessageDialog(null, msg.getMsg("error.abnormalExit"), "Disaster", JOptionPane.ERROR_MESSAGE);
        }


        settings.loadSettings(true);

        if (settings.getSourceFilePath() != null && FileUtils.isFileExists(settings.getSourceFilePath())) {
            source = settings.getSourceFilePath();
            srcList = utilities.makeList(source);
        } else {
            source = "";
        }
        if (settings.getDestinationFolderPath() != null &&
                new File(settings.getDestinationFolderPath()).exists()) {
            destination = settings.getDestinationFolderPath();
        } else {
            destination = "";
        }


        if (FileUtils.isFileExists(Constants.RECENT_SRC_PATHS_FILE)) {
            recentSrcPaths = utilities.makeList(Constants.RECENT_SRC_PATHS_FILE);
        } else {
            FileTools.createAFile(Constants.RECENT_SRC_PATHS_FILE);
        }

        if (FileUtils.isFileExists(Constants.RECENT_DEST_PATHS_FILE)) {
            recentDestPaths = utilities.makeList(Constants.RECENT_DEST_PATHS_FILE);
        } else {
            FileTools.createAFile(Constants.RECENT_DEST_PATHS_FILE);
        }
    }


    private boolean quickBackupMode(boolean activate) {
        if (activate) {
            LOGGER.debug("Activating quick backup mode.");
            settings.setNonQuickPath(sourceField.getText());
            if (!FileTools.createAFile(Constants.QUICK_MODE_FILENAME)) {
                return false;
            }
            source = new File(Constants.QUICK_MODE_FILENAME).getAbsolutePath();
            sourceField.setText(source);
            srcList = new String[0];
            srcList = utilities.makeList(source);
            settings.setSourceFilePath(source);
            settings.setProperties(true);
            return true;

        } else {
            LOGGER.debug("Deactivating quick backup mode.");
            if (new File(Constants.QUICK_MODE_FILENAME).exists()) {
                FileTools.delete(new File(Constants.QUICK_MODE_FILENAME).getAbsolutePath());
            }
            source = settings.getNonQuickPath();
            sourceField.setText(source);
            srcList = utilities.makeList(source);
            settings.setSourceFilePath(source);
            settings.setProperties(true);
        }
        return false;

    }

    private void setup() {
        LOGGER.debug("Program starting:\tSetup in progress...");
        setStatusForDomMode();
        setDomMode();
        setOsDependedSettings();
        setQuickBackupMode();

        sourceField.setText(source);
        destinationField.setText(destination);
        utilities.setInfoLabel(Tools.getRandomColor(), source, InfoLabel);


        checkSourcePath();
        checkDestinationPath();
        setCpuPriority();
    }

    private void setCpuPriority() {
        //set radio button with priority
        //TODO Improve this code
        switch (settings.getCpuPriority()) {
            case 0:
                priority_min_radioItem.setSelected(true);
                break;
            case 1:
                priority_normal_radioItem.setSelected(true);
                break;
            case 2:
                priority_max_radioItem.setSelected(true);
                break;
            default:
                priority_normal_radioItem.setSelected(true);
                break;

        }
    }

    private void checkDestinationPath() {
        if (StringUtils.isStringBlank(destination)) {
            for (String recentDestPath : recentDestPaths) {
                if (FileUtils.isDirectoryExists(recentDestPath)) {
                    destination = recentDestPath;
                    destinationField.setText(destination);
                }
                InfoLabel.setForeground(AppColor.DARK_BLUE);
                InfoLabel.setText("Destination path doesn't exist.Program will use one of them from recent destinations list.");
            }
        }
    }

    private void checkSourcePath() {
        if (StringUtils.isStringBlank(source)) {
            for (String recentSrcPath : recentSrcPaths) {
                if (FileUtils.isFileExists(recentSrcPath)) {
                    source = recentSrcPath;
                    sourceField.setText(source);
                }
                InfoLabel.setForeground(AppColor.DARK_BLUE);
                InfoLabel.setText("Source path doesn't exist.Program will use one of them from recent source list.");
            }
        }
    }

    private void setQuickBackupMode() {
        //Quick backup
        if (settings.isQuickBackup()) {
            utilities.activateQuickBackupMode(sourceField);
            source = Constants.QUICK_MODE_FILENAME;
            srcList = utilities.makeList(source);
        }
    }

    private void setOsDependedSettings() {
        //OS depended setup
        if (System.getProperty("os.name").startsWith("Windows")) {
            shutdownAfterBackupMenuItem.setEnabled(true);
        } else {
            shutdownAfterBackupMenuItem.setEnabled(true);
            shutdownAfterBackupMenuItem.setSelected(false);
        }
    }

    private void setDomMode() {
        //dom mode
        try {
            dom.load(new FileInputStream(System.getProperty("user.dir") + File.separator + "dom.properties"));
            domMode.setSelected(true);
        } catch (IllegalArgumentException | IOException ex) {
            LOGGER.debug("dom mode deactivated:" + ex.getCause());
            domMode.setVisible(false);
            domMode.setEnabled(false);
            domMode.setSelected(false);
        }
    }

    private void setStatusForDomMode() {
        //STATUS for dom mode
        if (status[0] == null) {
            statusMenuItem.setForeground(AppColor.DARK_ORANGE);
            statusMenuItem.setText("STATUS: UNKNOWN");
        } else if ("ERROR".equalsIgnoreCase(status[0])) {
            statusMenuItem.setForeground(Color.RED);
        } else if ("WARNING".equalsIgnoreCase(status[0])) {
            statusMenuItem.setForeground(AppColor.DARK_ORANGE);
        } else if ("OK".equalsIgnoreCase(status[0])) {
            statusMenuItem.setForeground(AppColor.DARK_GREEN);
        } else {
            statusMenuItem.setForeground(Color.DARK_GRAY);
        }
    }

    private void addonsForInitComponents() {
        //sets radio group for priority
        ButtonGroup group = new ButtonGroup();
        group.add(priority_max_radioItem);
        group.add(priority_normal_radioItem);
        group.add(priority_min_radioItem);
    }

    @SuppressWarnings("CyclicClassDependency")
    private class SourceListModel extends AbstractListModel<String> {
        final String[] strings = srcList;

        public int getSize() {
            return strings.length;
        }

        public String getElementAt(int element) {
            return strings[element];
        }
    }
}
