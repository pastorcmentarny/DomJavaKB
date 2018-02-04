package dms.pastor.tools.nanobackup.tools;


import dms.pastor.tools.nanobackup.Messenger;
import dms.pastor.tools.nanobackup.Settings;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public abstract class AbstractTools {

    public Messenger msg = new Messenger();

    public Settings settings = Settings.getSettings();
}