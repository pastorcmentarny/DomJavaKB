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
 * <p>
 * This is my first project after graduation in 2010. Do not expect too much :)
 */
public class AbstractTools {

    protected final Messenger msg = new Messenger();

    protected final Settings settings = Settings.getSettings();
}