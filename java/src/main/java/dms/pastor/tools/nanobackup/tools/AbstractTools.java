package dms.pastor.tools.nanobackup.tools;


import dms.pastor.tools.nanobackup.Messenger;
import dms.pastor.tools.nanobackup.Settings;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * <p>
 * This is my first project after graduation in 2010. Do not expect too much :)
 */
public class AbstractTools {

    protected final Messenger msg = new Messenger();

    protected final Settings settings = Settings.getSettings();
}