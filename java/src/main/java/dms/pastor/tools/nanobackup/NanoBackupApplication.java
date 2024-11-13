package dms.pastor.tools.nanobackup;

import dms.pastor.tools.nanobackup.GUI.GUI;
import dms.pastor.utils.file.FileUtils;

import javax.swing.*;

/**
 * Author Dominik Symonowicz
 * Created 11.12.2010
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * This is my first project after graduation in 2010. Do not expect too much :)
 */
public final class NanoBackupApplication {

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
