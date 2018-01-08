package dms.pastor.tools.nanobackup;

import dms.pastor.tools.nanobackup.GUI.GUI;
import dms.pastor.tools.nanobackup.tools.FileTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        final GUI start = new GUI();
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            FileTools.lock();
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
