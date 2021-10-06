package dms.pastor.domain;

import static dms.pastor.utils.file.FileUtils.unlockFile;

/**
 * Author Dominik Symonowicz
 * Created 2011-11-05 at 00:27:34
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ShutdownHook extends Thread {

    @Override
    public void run() {
        unlockFile();
    }

}
