package dms.pastor.tools.nanobackup.GUI;

import dms.pastor.tools.nanobackup.History;
import dms.pastor.tools.nanobackup.Messenger;
import dms.pastor.tools.nanobackup.Settings;
import dms.pastor.tools.nanobackup.backup.Backup;
import dms.pastor.tools.nanobackup.backup.Engine;
import dms.pastor.tools.nanobackup.tools.AppColor;
import dms.pastor.tools.nanobackup.tools.FileTools;
import dms.pastor.tools.nanobackup.tools.TaskUtils;
import dms.pastor.tools.nanobackup.tools.Tools;
import dms.pastor.utils.StringUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

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
public class GUI extends javax.swing.JFrame {

    private static final Logger LOGGER = LoggerFactory.getLogger(GUI.class);
    private final Settings settings = Settings.getSettings();
    private final History history = History.getHistoryGUI();
    private final Properties dom = new Properties();
    private final Messenger msg = new Messenger();
    public Engine utilities = new Engine();
    public Backup backup = Backup.getBackup();
    private ButtonGroup group;
    private String source;
    private String destination;
    private String[] srcList = new String[0];
    private String[] status = {"UNKNOWN"};
    private String[] recentSrcPaths = new String[0];
    private String[] recentDestPaths = new String[0];
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutMenuItem;
    private javax.swing.JMenuItem FAQMenuItem;
    private javax.swing.JLabel InfoLabel;
    private javax.swing.JMenuItem Lap2ArchMenu;
    private javax.swing.JMenuItem Lap2HDDMenu;
    private javax.swing.JMenuItem Lap2USBMenu;
    private javax.swing.JCheckBoxMenuItem QuickBackupCheckBoxMenuItem;
    private javax.swing.JMenuItem USB2LapMenu;
    private javax.swing.JMenuItem WorkStartMenu;
    private javax.swing.JButton addButton;
    private javax.swing.JCheckBoxMenuItem checkFreeSpaceBeforeBackupMenuItem;
    private javax.swing.JMenuItem clearSourceMenuItem;
    private javax.swing.JCheckBoxMenuItem confirmExitCheckBoxMenuItem;
    private javax.swing.JMenuItem createDefaultConfigMenuItem;
    private javax.swing.JButton createSourceFileButton;
    private javax.swing.JCheckBoxMenuItem deleteSourceCheckBoxMenuItem;
    private javax.swing.JTextField destinationField;
    private javax.swing.JButton doBackupButton;
    private javax.swing.JCheckBoxMenuItem domMode;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JCheckBoxMenuItem exitProgramAfterBackupMenuItem;
    private javax.swing.JCheckBoxMenuItem happyModeCheckkBoxMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem loadSettingsMenuItem;
    private javax.swing.JButton mergeButton;
    private javax.swing.JComboBox previousDestPathComboBox;
    private javax.swing.JComboBox previousSrcPathComboBox;
    private javax.swing.JRadioButtonMenuItem priority_max_radioItem;
    private javax.swing.JRadioButtonMenuItem priority_min_radioItem;
    private javax.swing.JRadioButtonMenuItem priority_normal_radioItem;
    private javax.swing.JMenuItem refreshSettingsMenuItem;
    private javax.swing.JButton removeButton;
    private javax.swing.JMenuItem removeDuplicatesMenuItem;
    private javax.swing.JCheckBoxMenuItem saveAsCryptedCheckBoxMenuItem;
    private javax.swing.JCheckBoxMenuItem saveAsZipCheckBoxMenuItem;
    private javax.swing.JCheckBoxMenuItem saveResultToFileCheckBoxMenuItem;
    private javax.swing.JMenuItem saveSettingsMenuItem;
    private javax.swing.JButton selectDestinationButton;
    private javax.swing.JButton selectSourceButton;
    private javax.swing.JMenu settingsMenu;
    private javax.swing.JCheckBoxMenuItem shutdownAfterBackupMenuItem;
    private javax.swing.JTextField sourceField;
    private javax.swing.JLabel sourceFileLabel;
    private javax.swing.JList sourceList;
    private javax.swing.JCheckBoxMenuItem speedLightModeMenuItem;
    private javax.swing.JMenu statusMenu;
    private javax.swing.JMenuItem statusMenuItem;
    private javax.swing.JButton swapDestinationFolderPathButton;
    private javax.swing.JButton swapSourceFolderPathButton;
    private javax.swing.JMenu tbpMenu;
    private javax.swing.JMenuItem tutorialMenuItem;
    private javax.swing.JMenuItem workEndMenu;

    /**
     * Creates new form GUI
     */
    public GUI() {
        LOGGER.info("Program: Start.");
        boot();
        initComponents();
        addonsForinitComponents();
        setup();
        check();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new GUI().setVisible(true));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sourceList = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        destinationField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        selectDestinationButton = new javax.swing.JButton();
        doBackupButton = new javax.swing.JButton();
        sourceField = new javax.swing.JTextField();
        sourceFileLabel = new javax.swing.JLabel();
        selectSourceButton = new javax.swing.JButton();
        InfoLabel = new javax.swing.JLabel();
        createSourceFileButton = new javax.swing.JButton();
        mergeButton = new javax.swing.JButton();
        previousDestPathComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        swapDestinationFolderPathButton = new javax.swing.JButton();
        previousSrcPathComboBox = new javax.swing.JComboBox();
        swapSourceFolderPathButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        statusMenu = new javax.swing.JMenu();
        AboutMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        statusMenuItem = new javax.swing.JMenuItem();
        settingsMenu = new javax.swing.JMenu();
        exitProgramAfterBackupMenuItem = new javax.swing.JCheckBoxMenuItem();
        deleteSourceCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        QuickBackupCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        confirmExitCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        shutdownAfterBackupMenuItem = new javax.swing.JCheckBoxMenuItem();
        saveAsZipCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        saveAsCryptedCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        saveResultToFileCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        checkFreeSpaceBeforeBackupMenuItem = new javax.swing.JCheckBoxMenuItem();
        speedLightModeMenuItem = new javax.swing.JCheckBoxMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        happyModeCheckkBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        domMode = new javax.swing.JCheckBoxMenuItem();
        jMenu7 = new javax.swing.JMenu();
        priority_max_radioItem = new javax.swing.JRadioButtonMenuItem();
        priority_normal_radioItem = new javax.swing.JRadioButtonMenuItem();
        priority_min_radioItem = new javax.swing.JRadioButtonMenuItem();
        jMenu5 = new javax.swing.JMenu();
        createDefaultConfigMenuItem = new javax.swing.JMenuItem();
        clearSourceMenuItem = new javax.swing.JMenuItem();
        removeDuplicatesMenuItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        tbpMenu = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        WorkStartMenu = new javax.swing.JMenuItem();
        workEndMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        Lap2USBMenu = new javax.swing.JMenuItem();
        Lap2HDDMenu = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        Lap2ArchMenu = new javax.swing.JMenuItem();
        USB2LapMenu = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        saveSettingsMenuItem = new javax.swing.JMenuItem();
        loadSettingsMenuItem = new javax.swing.JMenuItem();
        refreshSettingsMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        FAQMenuItem = new javax.swing.JMenuItem();
        tutorialMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("nanoBackup by Pastor Cmentarny");
        setFont(new java.awt.Font("Corbel", 3, 18)); // NOI18N
        setMinimumSize(new java.awt.Dimension(444, 444));
        setName("mainGUIframe"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("What items (files and/or folders should be in backup?");

        sourceList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = srcList;

            public int getSize() {
                return strings.length;
            }

            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        sourceList.setToolTipText("Source items");
        sourceList.setMaximumSize(new java.awt.Dimension(276, 160));
        sourceList.setMinimumSize(new java.awt.Dimension(276, 160));
        sourceList.setPreferredSize(new java.awt.Dimension(276, 160));
        jScrollPane1.setViewportView(sourceList);

        jLabel2.setText("Destinantion folder where backup will be stored:");

        destinationField.setToolTipText("destination folder");
        destinationField.setEnabled(false);
        destinationField.setMaximumSize(new java.awt.Dimension(280, 20));
        destinationField.setMinimumSize(new java.awt.Dimension(280, 20));
        destinationField.setPreferredSize(new java.awt.Dimension(280, 20));

        addButton.setText("Add");
        addButton.addActionListener(evt -> addButtonActionPerformed(evt));

        removeButton.setText("Remove");
        removeButton.addActionListener(evt -> removeButtonActionPerformed(evt));

        selectDestinationButton.setText("Change");
        selectDestinationButton.addActionListener(evt -> selectDestinationButtonActionPerformed(evt));

        doBackupButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doBackupButton.setText("Make Backup");
        doBackupButton.setPreferredSize(new java.awt.Dimension(128, 96));
        doBackupButton.setRolloverEnabled(false);
        doBackupButton.addActionListener(evt -> doBackupButtonActionPerformed(evt));

        sourceField.setEditable(false);
        sourceField.setToolTipText("source file");
        sourceField.setMaximumSize(new java.awt.Dimension(280, 20));
        sourceField.setMinimumSize(new java.awt.Dimension(280, 20));
        sourceField.setPreferredSize(new java.awt.Dimension(300, 20));

        sourceFileLabel.setText("Source file that with folders to backup:");
        sourceFileLabel.setMaximumSize(new java.awt.Dimension(280, 14));
        sourceFileLabel.setMinimumSize(new java.awt.Dimension(280, 14));
        sourceFileLabel.setPreferredSize(new java.awt.Dimension(280, 14));
        sourceFileLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        selectSourceButton.setText("Change");
        selectSourceButton.addActionListener(evt -> selectSourceButtonActionPerformed(evt));

        InfoLabel.setForeground(new java.awt.Color(255, 0, 0));
        InfoLabel.setText("InfoBar");
        InfoLabel.setMaximumSize(new java.awt.Dimension(395, 14));
        InfoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InfoLabelMouseClicked(evt);
            }
        });

        createSourceFileButton.setText("Create new");
        createSourceFileButton.addActionListener(evt -> createSourceFileButtonActionPerformed(evt));

        mergeButton.setText("Merge");
        mergeButton.addActionListener(evt -> mergeButtonActionPerformed(evt));

        previousDestPathComboBox.setModel(new javax.swing.DefaultComboBoxModel(recentDestPaths));
        previousDestPathComboBox.setMaximumSize(new java.awt.Dimension(300, 20));
        previousDestPathComboBox.setMinimumSize(new java.awt.Dimension(300, 20));
        previousDestPathComboBox.setPreferredSize(new java.awt.Dimension(300, 20));

        jLabel3.setText("Swap destinations with  one of resent destination paths:");

        swapDestinationFolderPathButton.setText("Swap");
        swapDestinationFolderPathButton.addActionListener(evt -> swapDestinationFolderPathButtonActionPerformed(evt));

        previousSrcPathComboBox.setModel(new javax.swing.DefaultComboBoxModel(recentSrcPaths));

        swapSourceFolderPathButton.setText("Swap");
        swapSourceFolderPathButton.addActionListener(evt -> swapSourceFolderPathButtonActionPerformed(evt));

        statusMenu.setText("Program");

        AboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        AboutMenuItem.setText("About");
        AboutMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AboutMenuItemMouseClicked(evt);
            }
        });
        AboutMenuItem.addActionListener(evt -> AboutMenuItemActionPerformed(evt));
        statusMenu.add(AboutMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(evt -> exitMenuItemActionPerformed(evt));
        statusMenu.add(exitMenuItem);

        statusMenuItem.setText("STATUS:" + status[0] + "\n");
        statusMenuItem.addActionListener(evt -> statusMenuItemActionPerformed(evt));
        statusMenu.add(statusMenuItem);

        jMenuBar1.add(statusMenu);

        settingsMenu.setText("Settings");

        exitProgramAfterBackupMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.ALT_MASK));
        exitProgramAfterBackupMenuItem.setSelected(settings.isExitAfterBackup());
        exitProgramAfterBackupMenuItem.setText("Exit program after backup");
        exitProgramAfterBackupMenuItem.setToolTipText("If is selected,program will exit after finish backup (in all cases)");
        exitProgramAfterBackupMenuItem.addActionListener(evt -> exitProgramAfterBackupMenuItemActionPerformed(evt));
        settingsMenu.add(exitProgramAfterBackupMenuItem);

        deleteSourceCheckBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_MASK));
        deleteSourceCheckBoxMenuItem.setText("Clear source after backup");
        deleteSourceCheckBoxMenuItem.setSelected(settings.isDeleteSourceAfterBackup());
        deleteSourceCheckBoxMenuItem.addActionListener(evt -> deleteSourceCheckBoxMenuItemActionPerformed(evt));
        settingsMenu.add(deleteSourceCheckBoxMenuItem);

        QuickBackupCheckBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.ALT_MASK));
        QuickBackupCheckBoxMenuItem.setText("Quick Backup Only");
        QuickBackupCheckBoxMenuItem.setSelected(settings.isQuickBackup());
        QuickBackupCheckBoxMenuItem.addActionListener(evt -> QuickBackupCheckBoxMenuItemActionPerformed(evt));
        settingsMenu.add(QuickBackupCheckBoxMenuItem);

        confirmExitCheckBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.ALT_MASK));
        confirmExitCheckBoxMenuItem.setText("Confirm on exit");
        confirmExitCheckBoxMenuItem.setSelected(settings.isConfirmOnExit());
        confirmExitCheckBoxMenuItem.addActionListener(evt -> confirmExitCheckBoxMenuItemActionPerformed(evt));
        settingsMenu.add(confirmExitCheckBoxMenuItem);

        shutdownAfterBackupMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.ALT_MASK));
        shutdownAfterBackupMenuItem.setForeground(AppColor.DARKORANGE);
        shutdownAfterBackupMenuItem.setText("Shutdown a PC after backup(beta!)");
        shutdownAfterBackupMenuItem.setEnabled(false);
        shutdownAfterBackupMenuItem.addActionListener(evt -> shutdownAfterBackupMenuItemActionPerformed(evt));
        settingsMenu.add(shutdownAfterBackupMenuItem);

        saveAsZipCheckBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.ALT_MASK));
        saveAsZipCheckBoxMenuItem.setSelected(settings.isSaveAsZip());
        saveAsZipCheckBoxMenuItem.setText("Save a zip file (beta!)");
        saveAsZipCheckBoxMenuItem.setForeground(AppColor.DARKORANGE);
        saveAsZipCheckBoxMenuItem.addActionListener(evt -> saveAsZipCheckBoxMenuItemActionPerformed(evt));
        settingsMenu.add(saveAsZipCheckBoxMenuItem);

        saveAsCryptedCheckBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.event.InputEvent.ALT_MASK));
        saveAsCryptedCheckBoxMenuItem.setSelected(settings.isSaveAsCrypted());
        saveAsZipCheckBoxMenuItem.setForeground(AppColor.DARKORANGE);
        saveAsCryptedCheckBoxMenuItem.setText("Save as paranoid crypted zip file");
        saveAsCryptedCheckBoxMenuItem.setEnabled(false);
        saveAsCryptedCheckBoxMenuItem.addActionListener(evt -> saveAsCryptedCheckBoxMenuItemActionPerformed(evt));
        settingsMenu.add(saveAsCryptedCheckBoxMenuItem);

        saveResultToFileCheckBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, java.awt.event.InputEvent.ALT_MASK));
        saveResultToFileCheckBoxMenuItem.setSelected(settings.isSaveResultsToFile());
        saveResultToFileCheckBoxMenuItem.setText("Save results to file");
        saveResultToFileCheckBoxMenuItem.addActionListener(evt -> saveResultToFileCheckBoxMenuItemActionPerformed(evt));
        settingsMenu.add(saveResultToFileCheckBoxMenuItem);

        checkFreeSpaceBeforeBackupMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.event.InputEvent.ALT_MASK));
        checkFreeSpaceBeforeBackupMenuItem.setSelected(settings.isCheckFreeSpaceBeforeBackup());
        checkFreeSpaceBeforeBackupMenuItem.setText("Check free space before backup");
        checkFreeSpaceBeforeBackupMenuItem.addActionListener(evt -> checkFreeSpaceBeforeBackupMenuItemActionPerformed(evt));
        settingsMenu.add(checkFreeSpaceBeforeBackupMenuItem);

        speedLightModeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9, java.awt.event.InputEvent.ALT_MASK));
        speedLightModeMenuItem.setText("Speed Light mode");
        speedLightModeMenuItem.setForeground(AppColor.DARKORANGE);
        speedLightModeMenuItem.setSelected(settings.isSpeedLightMode());
        speedLightModeMenuItem.addActionListener(evt -> speedLightModeMenuItemActionPerformed(evt));
        settingsMenu.add(speedLightModeMenuItem);
        settingsMenu.add(jSeparator2);

        happyModeCheckkBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        happyModeCheckkBoxMenuItem.setText("happy mode");
        happyModeCheckkBoxMenuItem.setSelected(settings.isHappyMode());
        happyModeCheckkBoxMenuItem.addActionListener(evt -> happyModeCheckkBoxMenuItemActionPerformed(evt));
        settingsMenu.add(happyModeCheckkBoxMenuItem);

        domMode.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        domMode.setText("dom mode");
        domMode.addItemListener(evt -> domModeItemStateChanged(evt));
        settingsMenu.add(domMode);

        jMenu7.setText("Backup priority");

        priority_max_radioItem.setMnemonic('1');
        priority_max_radioItem.setText("MAX");
        priority_max_radioItem.addActionListener(evt -> priority_max_radioItemActionPerformed(evt));
        jMenu7.add(priority_max_radioItem);

        priority_normal_radioItem.setSelected(true);
        priority_normal_radioItem.setText("NORMAL");
        priority_normal_radioItem.addActionListener(evt -> priority_normal_radioItemActionPerformed(evt));
        jMenu7.add(priority_normal_radioItem);

        priority_min_radioItem.setText("MIN");
        priority_min_radioItem.addActionListener(evt -> priority_min_radioItemActionPerformed(evt));
        jMenu7.add(priority_min_radioItem);

        settingsMenu.add(jMenu7);

        jMenuBar1.add(settingsMenu);

        jMenu5.setText("Task");

        createDefaultConfigMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.ALT_MASK));
        createDefaultConfigMenuItem.setText("Create default config");
        createDefaultConfigMenuItem.setEnabled(!settings.isQuickBackup());
        createDefaultConfigMenuItem.addActionListener(evt -> createDefaultConfigMenuItemActionPerformed(evt));
        jMenu5.add(createDefaultConfigMenuItem);

        clearSourceMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.ALT_MASK));
        clearSourceMenuItem.setText("Clear non exist files");
        clearSourceMenuItem.addActionListener(evt -> clearSourceMenuItemActionPerformed(evt));
        jMenu5.add(clearSourceMenuItem);

        removeDuplicatesMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, java.awt.event.InputEvent.ALT_MASK));
        removeDuplicatesMenuItem.setText("Remove duplicates");
        removeDuplicatesMenuItem.addActionListener(evt -> removeDuplicatesMenuItemActionPerformed(evt));
        jMenu5.add(removeDuplicatesMenuItem);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("TaskEditor");
        jMenuItem2.setEnabled(false);
        jMenu5.add(jMenuItem2);

        tbpMenu.setText("domTBP");
        tbpMenu.setEnabled(false);

        jMenu3.setText("Work");

        WorkStartMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        WorkStartMenu.setText("Work(Start)");
        WorkStartMenu.addActionListener(evt -> WorkStartMenuActionPerformed(evt));
        jMenu3.add(WorkStartMenu);

        workEndMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_MASK));
        workEndMenu.setText("Work(End)");
        workEndMenu.addActionListener(evt -> workEndMenuActionPerformed(evt));
        jMenu3.add(workEndMenu);

        tbpMenu.add(jMenu3);
        tbpMenu.add(jSeparator1);

        jMenu4.setText("Home(Laptop)");

        Lap2USBMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.CTRL_MASK));
        Lap2USBMenu.setText("To USB");
        Lap2USBMenu.addActionListener(evt -> Lap2USBMenuActionPerformed(evt));
        jMenu4.add(Lap2USBMenu);

        Lap2HDDMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.CTRL_MASK));
        Lap2HDDMenu.setText("To HDD");
        Lap2HDDMenu.addActionListener(evt -> Lap2HDDMenuActionPerformed(evt));
        jMenu4.add(Lap2HDDMenu);

        tbpMenu.add(jMenu4);

        jMenu6.setText("Home(USB)");

        Lap2ArchMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.CTRL_MASK));
        Lap2ArchMenu.setText("To Archive");
        Lap2ArchMenu.addActionListener(evt -> Lap2ArchMenuActionPerformed(evt));
        jMenu6.add(Lap2ArchMenu);

        USB2LapMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, java.awt.event.InputEvent.CTRL_MASK));
        USB2LapMenu.setText("ToLaptop");
        USB2LapMenu.addActionListener(evt -> USB2LapMenuActionPerformed(evt));
        jMenu6.add(USB2LapMenu);

        tbpMenu.add(jMenu6);

        jMenu5.add(tbpMenu);

        jMenu1.setText("Save/Load settings");

        saveSettingsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, java.awt.event.InputEvent.ALT_MASK));
        saveSettingsMenuItem.setText("save settings (beta!)");
        saveSettingsMenuItem.setForeground(AppColor.DARKORANGE);
        saveSettingsMenuItem.addActionListener(evt -> saveSettingsMenuItemActionPerformed(evt));
        jMenu1.add(saveSettingsMenuItem);

        loadSettingsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, java.awt.event.InputEvent.ALT_MASK));
        loadSettingsMenuItem.setText("load settings(beta!)");
        loadSettingsMenuItem.addActionListener(evt -> loadSettingsMenuItemActionPerformed(evt));
        jMenu1.add(loadSettingsMenuItem);

        refreshSettingsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, java.awt.event.InputEvent.ALT_MASK));
        refreshSettingsMenuItem.setText("refresh settings(beta!)");
        refreshSettingsMenuItem.setEnabled(false);
        refreshSettingsMenuItem.addActionListener(evt -> refreshSettingsMenuItemActionPerformed(evt));
        jMenu1.add(refreshSettingsMenuItem);

        jMenu5.add(jMenu1);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Help");

        FAQMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_MASK));
        FAQMenuItem.setText("FAQ");
        FAQMenuItem.addActionListener(evt -> FAQMenuItemActionPerformed(evt));
        jMenu2.add(FAQMenuItem);

        tutorialMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.ALT_MASK));
        tutorialMenuItem.setText("Tutorial");
        tutorialMenuItem.addActionListener(evt -> tutorialMenuItemActionPerformed(evt));
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
    }// </editor-fold>//GEN-END:initComponents

    private void doBackupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doBackupButtonActionPerformed
        if (backup.isInProgress()) {
            utilities.setInfoLabel(AppColor.DARKORANGE, "Another backup in progress.Please wait until previous backup is done", InfoLabel);
        } else {
            LOGGER.debug("Doing backup using:\n\tsource file:" + sourceField.getText() + "\n\tdestination folder:" + destinationField.getText());
            backup.backupGUI(utilities.makeList(sourceField.getText()), destinationField.getText(), this);
            this.toBack();
            utilities.setInfoLabel(Color.BLUE, "Backup task ended.(See BackupTask window for details)", InfoLabel);
            check();
        }
    }//GEN-LAST:event_doBackupButtonActionPerformed

    private void selectSourceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectSourceButtonActionPerformed
        String tempSource = utilities.chooseFiletoLoad();
        if (FileTools.isFileExists(tempSource)) {
            sourceField.setText(tempSource);
            srcList = utilities.makeList(tempSource);
            srcList = TaskUtils.removeNonExistsItems(srcList);
            settings.setSourceFilePath(tempSource);
            settings.setProperties(true);
            recentSrcPaths = utilities.updateRecentFolderPaths(recentSrcPaths, tempSource);
            FileTools.saveListToFile(recentSrcPaths, Settings.RECENT_SRC_PATHS_FILE);
            utilities.setInfoLabel(AppColor.DARKGREEN, "Source file set to " + tempSource, InfoLabel);
        } else {
            utilities.setInfoLabel(Color.RED, "Action cancelled", InfoLabel);
        }
        refreshContent();
        check();

    }//GEN-LAST:event_selectSourceButtonActionPerformed

    private void selectDestinationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDestinationButtonActionPerformed
        String tempSource = FileTools.chooseDirtoLoad();
        if (tempSource != null) {
            destinationField.setText(tempSource);
            settings.setDestinationFolderPath(tempSource);
            settings.setProperties(true);
            recentDestPaths = utilities.updateRecentFolderPaths(recentDestPaths, tempSource);
            FileTools.saveListToFile(recentDestPaths, Settings.RECENT_DEST_PATHS_FILE);

            InfoLabel.setForeground(AppColor.DARKGREEN);
            InfoLabel.setText("Destination folder is set to: " + tempSource);
        } else {
            InfoLabel.setForeground(Color.RED);
            InfoLabel.setText("Destination folder is not changed.");
        }
        refreshContent();
        check();

    }//GEN-LAST:event_selectDestinationButtonActionPerformed

    private void createDefaultConfigMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createDefaultConfigMenuItemActionPerformed
        if (settings.createDefaultSettings()) {
            sourceField.setText(settings.getSourceFilePath());
            srcList = utilities.makeList(settings.getSourceFilePath());
            destinationField.setText(settings.getDestinationFolderPath());
            destination = settings.getDestinationFolderPath();
            utilities.setInfoLabel(AppColor.DARKGREEN, "Default config was used to create source/destination path.", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.RED, "Unable to create default config.Please reinstall program!", InfoLabel);
        }
        refreshContent();
        check();
    }//GEN-LAST:event_createDefaultConfigMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        settings.setProperties(true);
        utilities.shutdown("exitByUser");
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void AboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutMenuItemActionPerformed
        new About().setVisible(true);
    }//GEN-LAST:event_AboutMenuItemActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String[] addFileResult = utilities.addItemsToItemsList(srcList, sourceField, "item");
        if (addFileResult != null) {
            srcList = addFileResult;
            if (FileTools.saveListToFile(srcList, sourceField.getText())) {
                InfoLabel.setText("List was saved to file.");
            } else {
                InfoLabel.setText("List was NOT saved to file.");
                JOptionPane.showMessageDialog(null, msg.getMsg("error.createFile"), "Woops!", JOptionPane.ERROR_MESSAGE);
            }
            refreshContent();
            check();
            InfoLabel.setForeground(AppColor.DARKGREEN);
            if (addFileResult.length == 1) {
                InfoLabel.setText("Item added." + InfoLabel.getText());
            } else {
                InfoLabel.setText("Items added." + InfoLabel.getText());
            }
        } else {
            utilities.setInfoLabel(Color.RED, "I'm afraid.Item(s) were NOT added.", InfoLabel);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void FAQMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FAQMenuItemActionPerformed
        FaqGUI faq = new FaqGUI();
        faq.setVisible(true);
    }//GEN-LAST:event_FAQMenuItemActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        String[] temp = srcList;
        srcList = utilities.removeItemsFromList(srcList, sourceList);
        if (srcList != null) {
            //change ?
            FileTools.saveListToFile(srcList, sourceField.getText());
            removeButton.setEnabled(true);
            refreshContent();
            check();
        }

        if (Arrays.equals(temp, srcList)) {
            utilities.setInfoLabel(AppColor.DARKORANGE, "Nothing was removed.", InfoLabel);
        } else {
            utilities.setInfoLabel(AppColor.DARKGREEN, "Item(s) was removed from list.", InfoLabel);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void domModeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_domModeItemStateChanged
        if (domMode.isSelected()) {
            utilities.setInfoLabel(Tools.getRandomColor(), "dom Mode activated.", InfoLabel);
        } else {
            utilities.setInfoLabel(Tools.getRandomColor(), "dom Mode deactivated.", InfoLabel);
        }
        check();
    }//GEN-LAST:event_domModeItemStateChanged

    private void workEndMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workEndMenuActionPerformed
        utilities.setInfoLabel(Color.BLACK, "WORK.END: doing backup...", InfoLabel);
        backup.backupGUI(utilities.makeList(dom.getProperty("dom.source.work.end")), dom.getProperty("dom.destination.word.end"), this);
        utilities.setInfoLabel(Color.BLACK, "WORK.END backup task ended.", InfoLabel);
        InfoLabel.setText("");

    }//GEN-LAST:event_workEndMenuActionPerformed

    private void Lap2ArchMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lap2ArchMenuActionPerformed
        utilities.setInfoLabel(Color.BLACK, "USB2HDD: doing backup", InfoLabel);
        backup.backupGUI(utilities.makeList(dom.getProperty("dom.source.usb.hdd")), dom.getProperty("dom.destination.usb.hdd"), this);
        utilities.setInfoLabel(Color.BLACK, "USB2HDD backup task ended.", InfoLabel);
    }//GEN-LAST:event_Lap2ArchMenuActionPerformed

    private void Lap2USBMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lap2USBMenuActionPerformed
        utilities.setInfoLabel(Color.BLACK, "LAP2USB: doing backup", InfoLabel);
        backup.backupGUI(utilities.makeList(dom.getProperty("dom.source.lap.usb")), dom.getProperty("dom.destination.lap.usb"), this);
        utilities.setInfoLabel(Color.BLACK, "LAP2USB backup task ended.", InfoLabel);
    }//GEN-LAST:event_Lap2USBMenuActionPerformed

    private void WorkStartMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WorkStartMenuActionPerformed
        utilities.setInfoLabel(Color.BLACK, "WORK.START: job started.", InfoLabel);
        settings.setDomJobs(dom.getProperty("dom.source.work.start.before"), dom.getProperty("dom.source.work.start.after"));
        backup.backupGUI(utilities.makeList(dom.getProperty("dom.source.work.start")), dom.getProperty("dom.destination.work.start"), this);
        //TaskUtils.doJob("C:\\dsSTUFF\\dssoft\\dev\\nanoBackup\\dom\\jobTest.properties", InfoLabel);
        utilities.setInfoLabel(Color.BLACK, "WORK.START  job ended.", InfoLabel);


    }//GEN-LAST:event_WorkStartMenuActionPerformed

    private void tutorialMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorialMenuItemActionPerformed
        JOptionPane.showMessageDialog(null, msg.getMsg("tutorial"), "Tutorial", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_tutorialMenuItemActionPerformed

    private void createSourceFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSourceFileButtonActionPerformed
        String result = FileTools.createSourceFile(Settings.SRC_FILE_ENDING);
        if (result == null) {
            utilities.setInfoLabel(Color.RED, "File was NOT created.", InfoLabel);
        } else {
            utilities.setInfoLabel(AppColor.DARKGREEN, "Source file: " + result + " was created.", InfoLabel);
            recentSrcPaths = utilities.updateRecentFolderPaths(recentSrcPaths, sourceField.getText());
            FileTools.saveListToFile(recentSrcPaths, Settings.RECENT_SRC_PATHS_FILE);
            sourceField.setText(result);
            settings.setSourceFilePath(result);
            settings.setProperties(true);
            srcList = new String[0];
        }
        refreshContent();
        check();
    }//GEN-LAST:event_createSourceFileButtonActionPerformed

    private void Lap2HDDMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lap2HDDMenuActionPerformed
        InfoLabel.setForeground(Color.BLACK);
        InfoLabel.setText("LAP2HDD: doing backup");
        boolean result = FileTools.copyFolder(new File(dom.getProperty("dom.source.lap.hdd")), new File(dom.getProperty("dom.destination.lap.hdd")), null);
        if (result) {
            utilities.setInfoLabel(AppColor.DARKGREEN, "LAP2HDD backup was done successfully.", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.RED, "Program was unable to create backup", InfoLabel);
        }
    }//GEN-LAST:event_Lap2HDDMenuActionPerformed

    private void USB2LapMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USB2LapMenuActionPerformed
        InfoLabel.setText("USB2LAP: doing backup");
        //TODO CHANGE IT!
        String tempResponse = backup.doClassicBackup(utilities.makeList(dom.getProperty("dom.source.usb.lap")), dom.getProperty("dom.destination.usb.lap"), null);
        if (tempResponse != null) {
            JOptionPane.showMessageDialog(null, tempResponse, "Results", JOptionPane.INFORMATION_MESSAGE);
            utilities.setInfoLabel(AppColor.DARKGREEN, "USB2LAP backup was done successfully.", InfoLabel);
        } else {
            utilities.setInfoLabel(AppColor.DARKGREEN, "Program was unable to create backup", InfoLabel);
        }
    }//GEN-LAST:event_USB2LapMenuActionPerformed

    private void AboutMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutMenuItemMouseClicked
        new About().setVisible(true);
    }//GEN-LAST:event_AboutMenuItemMouseClicked

    private void clearSourceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearSourceMenuItemActionPerformed
        srcList = TaskUtils.removeNonExistsItems(srcList);
        FileTools.saveListToFile(srcList, sourceField.getText());
        removeButton.setEnabled(true);
        refreshContent();
        check();
        utilities.setInfoLabel(Color.BLUE, "Source list is cleaned from non existing files/folders.", InfoLabel);
    }//GEN-LAST:event_clearSourceMenuItemActionPerformed

    private void exitProgramAfterBackupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitProgramAfterBackupMenuItemActionPerformed
        settings.setExitAfterBackup(exitProgramAfterBackupMenuItem.isSelected());
        settings.setProperties(true);
        if (exitProgramAfterBackupMenuItem.isSelected()) {
            check();
            utilities.setInfoLabel(Color.BLUE, "Program will exit when backup is finished.", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.BLUE, "Program will back to this sreen when backup is finished.", InfoLabel);
        }
    }//GEN-LAST:event_exitProgramAfterBackupMenuItemActionPerformed

    private void removeDuplicatesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDuplicatesMenuItemActionPerformed
        srcList = TaskUtils.removeDuplicateLines(srcList);
        FileTools.saveListToFile(srcList, source);
        utilities.setInfoLabel(AppColor.DARKGREEN, "Duplicate lines in source file are removed.", InfoLabel);
        refreshContent();
        check();
    }//GEN-LAST:event_removeDuplicatesMenuItemActionPerformed

    private void QuickBackupCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuickBackupCheckBoxMenuItemActionPerformed
        settings.setQuickBackup(QuickBackupCheckBoxMenuItem.isSelected());
        if (quickBackupMode(QuickBackupCheckBoxMenuItem.isSelected())) {
            utilities.setInfoLabel(Color.BLUE, "Quick backup enabled.(Source file is NOT needed to make Backup)", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.DARK_GRAY, "Quick backup disabled.(Source file is  needed to make Backup)", InfoLabel);
        }
        refreshContent();
        check();
    }//GEN-LAST:event_QuickBackupCheckBoxMenuItemActionPerformed

    private void deleteSourceCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSourceCheckBoxMenuItemActionPerformed
        settings.setDeleteSourceAfterBackup(deleteSourceCheckBoxMenuItem.isSelected());
        settings.setProperties(true);
        if (deleteSourceCheckBoxMenuItem.isSelected()) {
            utilities.setInfoLabel(AppColor.DARKORANGE, "Source item(s) will be deleted after backup.(It cannot be undone!)", InfoLabel);
        } else {
            utilities.setInfoLabel(AppColor.DARKGREEN, "Source item(s) will stay untouched after backup.", InfoLabel);
        }
    }//GEN-LAST:event_deleteSourceCheckBoxMenuItemActionPerformed

    private void confirmExitCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmExitCheckBoxMenuItemActionPerformed
        settings.setConfirmOnExit(confirmExitCheckBoxMenuItem.isSelected());
        settings.setProperties(true);
        if (exitProgramAfterBackupMenuItem.isSelected()) {
            utilities.setInfoLabel(Color.BLUE, "Program will exit when backup is finished.", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.BLUE, "Program will back to this sreen when backup is finished.", InfoLabel);
        }
    }//GEN-LAST:event_confirmExitCheckBoxMenuItemActionPerformed

    private void happyModeCheckkBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_happyModeCheckkBoxMenuItemActionPerformed
        InfoLabel.setForeground(AppColor.DARKGREEN);
        settings.setHappyMode(happyModeCheckkBoxMenuItem.isSelected());
        settings.setProperties(true);
        if (happyModeCheckkBoxMenuItem.isSelected()) {
            utilities.setInfoLabel(Color.BLUE, "happy mode is activated.(It works only if speed light mode is disabled)", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.DARK_GRAY, "Happy mode is deactivated.", InfoLabel);
        }

    }//GEN-LAST:event_happyModeCheckkBoxMenuItemActionPerformed

    private void mergeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mergeButtonActionPerformed
        String[] itemsList = utilities.merge2Source(srcList);
        if (itemsList != null) {
            srcList = TaskUtils.removeDuplicateLines(itemsList);
            FileTools.saveListToFile(srcList, sourceField.getText());
            settings.setProperties(true);
            utilities.setInfoLabel(AppColor.DARKGREEN, "Selected source file was merged into item list.", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.RED, "Action cancelled.", InfoLabel);
        }
        refreshContent();
        check();
    }//GEN-LAST:event_mergeButtonActionPerformed

    private void statusMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusMenuItemActionPerformed
        Tools.showStatus(status);
    }//GEN-LAST:event_statusMenuItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //log.debug();
        utilities.shutdown("");
    }//GEN-LAST:event_formWindowClosing

    private void saveAsZipCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsZipCheckBoxMenuItemActionPerformed
        settings.setSaveAsZip(saveAsZipCheckBoxMenuItem.isSelected());
        settings.setProperties(true);
        if (deleteSourceCheckBoxMenuItem.isSelected()) {
            utilities.setInfoLabel(AppColor.DARKGREEN, "Backup will be saved as compressed zip file.", InfoLabel);
            //TODO; remove below dialog when zip feature will be completly implemented
            JOptionPane.showMessageDialog(null, "This is beta feature!\nIt has some known issues,which cause distasters!See changelog .. ", "WARNING", WIDTH);
        } else {
            utilities.setInfoLabel(AppColor.DARKGREEN, "Backup will be saved as folder.", InfoLabel);
        }
    }//GEN-LAST:event_saveAsZipCheckBoxMenuItemActionPerformed

    private void swapDestinationFolderPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swapDestinationFolderPathButtonActionPerformed
        String temp = previousDestPathComboBox.getSelectedItem().toString();
        if (FileTools.isDirectoryExists(temp)) {
            utilities.swapDestFolderPaths(recentDestPaths, temp, destinationField.getText());
            destinationField.setText(previousDestPathComboBox.getSelectedItem().toString());
            settings.setDestinationFolderPath(previousDestPathComboBox.getSelectedItem().toString());
            settings.setProperties(true);
            refreshContent();
            check();
            utilities.setInfoLabel(AppColor.DARKGREEN, "Destination folder path is swapped.", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.RED, "Selected destination path doesn't exist.", InfoLabel);
        }
    }//GEN-LAST:event_swapDestinationFolderPathButtonActionPerformed

    private void saveResultToFileCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveResultToFileCheckBoxMenuItemActionPerformed
        settings.setSaveResultsToFile(saveResultToFileCheckBoxMenuItem.isSelected());
        settings.setProperties(true);
        if (saveResultToFileCheckBoxMenuItem.isSelected()) {
            utilities.setInfoLabel(Color.BLUE, "Program will save results to file.", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.BLUE, "Program will NOT save results to file.", InfoLabel);
        }
    }//GEN-LAST:event_saveResultToFileCheckBoxMenuItemActionPerformed

    private void InfoLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InfoLabelMouseClicked
        history.showHistoryOfMessages();
    }//GEN-LAST:event_InfoLabelMouseClicked

    private void checkFreeSpaceBeforeBackupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkFreeSpaceBeforeBackupMenuItemActionPerformed
        settings.setCheckFreeSpaceBeforeBackup(checkFreeSpaceBeforeBackupMenuItem.isSelected());
        settings.setProperties(true);
        if (checkFreeSpaceBeforeBackupMenuItem.isSelected()) {
            utilities.setInfoLabel(Color.BLUE, "Program will check free space before backup.(Takes more time).", InfoLabel);
        } else {
            utilities.setInfoLabel(AppColor.DARKORANGE, "Program will NOT check free space before backup.(Quicker backup).", InfoLabel);
        }
    }//GEN-LAST:event_checkFreeSpaceBeforeBackupMenuItemActionPerformed

    private void saveSettingsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSettingsMenuItemActionPerformed
        String result = settings.saveSettingsWithDestSelection();
        if (result != null) {
            settings.setProperties(true);
            settings.saveProperties();
            refreshContent();
            check();
            utilities.setInfoLabel(AppColor.DARKGREEN, "Setting file: " + result + " was saved.", InfoLabel);

        } else {
            utilities.setInfoLabel(AppColor.DARKORANGE, "Unable to save.", InfoLabel);
        }


    }//GEN-LAST:event_saveSettingsMenuItemActionPerformed

    private void shutdownAfterBackupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shutdownAfterBackupMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shutdownAfterBackupMenuItemActionPerformed

    private void speedLightModeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speedLightModeMenuItemActionPerformed
        settings.setSpeedLightMode(speedLightModeMenuItem.isSelected());
        settings.setProperties(true);
        settings.saveProperties();
        if (speedLightModeMenuItem.isSelected()) {
            utilities.setInfoLabel(Color.BLUE, "Speed light mode activated.", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.BLUE, "Speed light mode deactivated.", InfoLabel);        // TODO add your handling code here:
        }
    }//GEN-LAST:event_speedLightModeMenuItemActionPerformed

    private void swapSourceFolderPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swapSourceFolderPathButtonActionPerformed
        String temp = previousSrcPathComboBox.getSelectedItem().toString();
        if (FileTools.isFileExists(temp)) {
            utilities.swapDestFolderPaths(recentSrcPaths, temp, sourceField.getText());
            sourceField.setText(previousSrcPathComboBox.getSelectedItem().toString());
            srcList = utilities.makeList(previousSrcPathComboBox.getSelectedItem().toString());
            srcList = TaskUtils.removeNonExistsItems(srcList);
            recentSrcPaths = utilities.updateRecentFolderPaths(recentSrcPaths, previousSrcPathComboBox.getSelectedItem().toString());
            settings.setSourceFilePath(previousSrcPathComboBox.getSelectedItem().toString());
            settings.setProperties(true);
            refreshContent();
            check();
            utilities.setInfoLabel(AppColor.DARKGREEN, "Source folder path is swapped.", InfoLabel);
        } else {
            utilities.setInfoLabel(Color.RED, "Selected Source path doesn't exist.", InfoLabel);
        }
    }//GEN-LAST:event_swapSourceFolderPathButtonActionPerformed

    private void loadSettingsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadSettingsMenuItemActionPerformed
        //TODO test it!
        String path = FileTools.chooseFiletoLoad();
        if (path != null) {
            if (settings.loadSettings(path, rootPaneCheckingEnabled)) {
                if (StringUtils.isNotBlank(sourceField.getText())) {
                    settings.setSourceFilePath(sourceField.getText());
                }

                if (StringUtils.isNotBlank(destinationField.getText())) {
                    settings.setDestinationFolderPath(destinationField.getText());
                }

                recentDestPaths = utilities.makeList(Settings.RECENT_DEST_PATHS_FILE);
                settings.setProperties(true);
                settings.saveProperties();
                refreshContent();
                check();
                utilities.setInfoLabel(AppColor.DARKORANGE, "Settings loaded and set.", InfoLabel);
            } else {
                utilities.setInfoLabel(AppColor.DARKORANGE, "Unable to load settings due error.", InfoLabel);
            }

        } else {
            utilities.setInfoLabel(AppColor.DARKORANGE, "Load settings was cancelled", InfoLabel);
        }
    }//GEN-LAST:event_loadSettingsMenuItemActionPerformed

    private void refreshSettingsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshSettingsMenuItemActionPerformed

        boolean loaded = settings.loadSettings(true);
        if (loaded) {
            settings.validateProperties(true);
            refreshContent();
            check();        // TODO add your handling code here:
            utilities.setInfoLabel(AppColor.DARKGREEN, "Settings refreshed.", InfoLabel);
        } else {
            utilities.setInfoLabel(AppColor.DARKORANGE, "Unable to refresh settings!", InfoLabel);
        }

    }//GEN-LAST:event_refreshSettingsMenuItemActionPerformed

    private void saveAsCryptedCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsCryptedCheckBoxMenuItemActionPerformed
        settings.setSaveAsCrypted(saveAsCryptedCheckBoxMenuItem.isSelected());
        settings.setProperties(true);
        if (saveAsCryptedCheckBoxMenuItem.isSelected()) {
            JOptionPane.showMessageDialog(null, "CAUTION!\nUse this only for file (few files).\n Keep in mind,that it will take ages to finish this backup.\n\n This mode is designed only for ", "WARNING!", JOptionPane.ERROR_MESSAGE);
            utilities.setInfoLabel(AppColor.DARKGREEN, "Backup will be saved as compressed zip file.", InfoLabel);
            //TODO; remove below dialog when zip feature will be completly implemented
            JOptionPane.showMessageDialog(null, "This is beta feature!\nIt has some known issues,which cause distasters!See changelog .. ", "WARNING", WIDTH);
        } else {
            utilities.setInfoLabel(AppColor.DARKGREEN, "Backup will be saved as crypted archive file.", InfoLabel);
        }
    }//GEN-LAST:event_saveAsCryptedCheckBoxMenuItemActionPerformed

    private void priority_max_radioItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priority_max_radioItemActionPerformed
        settings.setCpuPriority(2);
        settings.setProperties(true);
        utilities.setInfoLabel(AppColor.DARKBLUE, "Backup will used highest cpu priority.", InfoLabel);
    }//GEN-LAST:event_priority_max_radioItemActionPerformed

    private void priority_normal_radioItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priority_normal_radioItemActionPerformed
        settings.setCpuPriority(1);
        settings.setProperties(true);
        utilities.setInfoLabel(AppColor.DARKBLUE, "Backup will used normal cpu priority.", InfoLabel);
    }//GEN-LAST:event_priority_normal_radioItemActionPerformed

    private void priority_min_radioItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priority_min_radioItemActionPerformed
        settings.setCpuPriority(0);
        settings.setProperties(true);
        utilities.setInfoLabel(AppColor.DARKBLUE, "Backup will used lowest priority.", InfoLabel);
    }//GEN-LAST:event_priority_min_radioItemActionPerformed
    // End of variables declaration//GEN-END:variables

    private void refreshContent() {
        LOGGER.debug("refreshing GUI content...");
        //SOURCE LIST
        sourceList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = srcList;

            public int getSize() {
                return strings.length;
            }

            public Object getElementAt(int element) {
                return strings[element];
            }
        });

        //SOURCE AND DESTINATION PATHS LIST
        previousSrcPathComboBox.setModel(new javax.swing.DefaultComboBoxModel(recentSrcPaths));
        previousDestPathComboBox.setModel(new javax.swing.DefaultComboBoxModel(recentDestPaths));

        //SETTINGS        
        exitProgramAfterBackupMenuItem.setSelected(settings.isExitAfterBackup());
        deleteSourceCheckBoxMenuItem.setSelected(settings.isDeleteSourceAfterBackup());
        QuickBackupCheckBoxMenuItem.setSelected(settings.isQuickBackup());
        confirmExitCheckBoxMenuItem.setSelected(settings.isConfirmOnExit());
        shutdownAfterBackupMenuItem.setSelected(settings.isShutdownAfterBackup());
        saveAsZipCheckBoxMenuItem.setSelected(settings.isSaveAsZip());
        saveAsCryptedCheckBoxMenuItem.setSelected(settings.isSaveAsCrypted());
        saveResultToFileCheckBoxMenuItem.setSelected(settings.isSaveResultsToFile());
        checkFreeSpaceBeforeBackupMenuItem.setSelected(settings.isCheckFreeSpaceBeforeBackup());
        speedLightModeMenuItem.setSelected(settings.isSpeedLightMode());
        happyModeCheckkBoxMenuItem.setSelected(settings.isHappyMode());


    }

    private void check() {

        //CREATE DEFAULT 
        createDefaultConfigMenuItem.setEnabled(!settings.isQuickBackup());


        //ADD/MERGE BUTTON

        if (sourceField == null || StringUtils.isStringEmpty(sourceField.getText())) {
            boolean groupSelection = false;
            addButton.setEnabled(groupSelection);
            mergeButton.setEnabled(groupSelection);
        } else {
            boolean groupSelection = true;
            addButton.setEnabled(groupSelection);
            mergeButton.setEnabled(groupSelection);
        }

        //REMOVE BUTTON
        if (srcList.length == 0) {
            removeButton.setEnabled(false);
        } else {
            removeButton.setEnabled(true);
        }

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
        if (status[0].equals("ERROR")) {
            LOGGER.warn("Program is damaged.");
        }

        if (!FileTools.isFileExists(Settings.SETTINGSPATH)) {
            settings.createDefaultSettings();
        }

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage() + "\n\n" + ex.getCause());
            JOptionPane.showMessageDialog(null, msg.getMsg("error.abnormalExit"), "Disaster", JOptionPane.ERROR_MESSAGE);
        }


        settings.loadSettings(true);

        if (settings.getSourceFilePath() != null && FileTools.isFileExists(settings.getSourceFilePath())) {
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


        if (FileTools.isFileExists(Settings.RECENT_SRC_PATHS_FILE)) {
            recentSrcPaths = utilities.makeList(Settings.RECENT_SRC_PATHS_FILE);
        } else {
            FileTools.createAFile(Settings.RECENT_SRC_PATHS_FILE);
        }

        if (FileTools.isFileExists(Settings.RECENT_DEST_PATHS_FILE)) {
            recentDestPaths = utilities.makeList(Settings.RECENT_DEST_PATHS_FILE);
        } else {
            FileTools.createAFile(Settings.RECENT_DEST_PATHS_FILE);
        }
    }

    private boolean quickBackupMode(boolean activate) {
        if (activate) {
            LOGGER.debug("Activating quick backup mode.");
            settings.setNonQuickPath(sourceField.getText());
            if (!FileTools.createAFile(Settings.QUICKMODE_FILENAME)) {
                return false;
            }
            source = new File(Settings.QUICKMODE_FILENAME).getAbsolutePath();
            sourceField.setText(source);
            srcList = new String[0];
            srcList = utilities.makeList(source);
            settings.setSourceFilePath(source);
            settings.setProperties(true);
            return true;

        } else {
            LOGGER.debug("Deactivating quick backup mode.");
            if (new File(Settings.QUICKMODE_FILENAME).exists()) {
                FileTools.delete(new File(Settings.QUICKMODE_FILENAME).getAbsolutePath());
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
        //STATUS for dom mode
        if (status[0] == null) {
            statusMenuItem.setForeground(AppColor.DARKORANGE);
            statusMenuItem.setText("STATUS: UNKNOWN");
        } else if (status[0].equalsIgnoreCase("ERROR")) {
            statusMenuItem.setForeground(Color.RED);
        } else if (status[0].equalsIgnoreCase("WARNING")) {
            statusMenuItem.setForeground(AppColor.DARKORANGE);
        } else if (status[0].equalsIgnoreCase("OK")) {
            statusMenuItem.setForeground(AppColor.DARKGREEN);
        } else {
            statusMenuItem.setForeground(Color.DARK_GRAY);
        }

        //dom mode
        FileInputStream fis = null;
        try {
            dom.load(new FileInputStream(System.getProperty("user.dir") + System.getProperty("file.separator") + "dom.properties"));
            domMode.setSelected(true);
        } catch (IllegalArgumentException | IOException ex) {
            LOGGER.debug("dom mode deactivated:" + ex.getCause());
            domMode.setVisible(false);
            domMode.setEnabled(false);
            domMode.setSelected(false);
        } finally {
            IOUtils.closeQuietly(fis);
        }

        //OS depended setup
        if (System.getProperty("os.name").startsWith("Windows")) {
            shutdownAfterBackupMenuItem.setEnabled(true);
        } else {
            shutdownAfterBackupMenuItem.setEnabled(true);
            shutdownAfterBackupMenuItem.setSelected(false);
        }

        //Quick backup
        if (settings.isQuickBackup()) {
            utilities.activateQuickBackupMode(sourceField);
            source = Settings.QUICKMODE_FILENAME;
            srcList = utilities.makeList(source);
        }


        sourceField.setText(source);
        destinationField.setText(destination);
        utilities.setInfoLabel(Tools.getRandomColor(), source, InfoLabel);


        if (StringUtils.isStringBlank(source)) {
            for (String recentSrcPath : recentSrcPaths) {
                if (FileTools.isFileExists(recentSrcPath)) {
                    source = recentSrcPath;
                    sourceField.setText(source);
                }
                InfoLabel.setForeground(AppColor.DARKBLUE);
                InfoLabel.setText("Source path doesn't exist.Program will use one of them from recent source list.");
            }
        }

        if (StringUtils.isStringBlank(destination)) {
            for (String recentDestPath : recentDestPaths) {
                if (FileTools.isDirectoryExists(recentDestPath)) {
                    destination = recentDestPath;
                    destinationField.setText(destination);
                }
                InfoLabel.setForeground(AppColor.DARKBLUE);
                InfoLabel.setText("Destination path doesn't exist.Program will use one of them from recent destinations list.");
            }
        }

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

    private void addonsForinitComponents() {
        //sets radio group for priority
        group = new ButtonGroup();
        group.add(priority_max_radioItem);
        group.add(priority_normal_radioItem);
        group.add(priority_min_radioItem);
    }
}
