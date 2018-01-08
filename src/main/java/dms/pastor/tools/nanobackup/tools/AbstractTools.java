package dms.pastor.tools.nanobackup.tools;


import dms.pastor.tools.nanobackup.Messenger;
import dms.pastor.tools.nanobackup.Settings;

/**
 * This class just set  common variables
 *
 * @author Dominik Symonowicz
 */
public abstract class AbstractTools {
    /**/
    public Messenger msg = new Messenger();
    /**/
    public Settings settings = Settings.getSettings();
}