package dms.pastor.tools.nanobackup;

import dms.pastor.tools.nanobackup.GUI.GUI;
import dms.pastor.utils.FileUtils;

import javax.swing.*;

/**
 * Author Dominik Symonowicz
 * Created 11.12.2010
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class NanoBackupApplication {

    // --Commented out by Inspection (21/02/2018 14:14):private static final Logger LOGGER = LoggerFactory.getLogger(NanoBackupApplication.class);

    private NanoBackupApplication() {
    }

    public static void main(String[] args) {
        final GUI start = new GUI();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            FileUtils.lock();
            if (args.length != 0) {
                System.out.println(args[0]);
            } else {
                start.setVisible(true);
            }
        } catch (RuntimeException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Program is already running", "Are you blind ???", JOptionPane.ERROR_MESSAGE);
            start.utilities.shutdown("alreadyRun");
        } catch (Exception ex) {
            start.utilities.shutdown("disaster");
        }
    }

}
