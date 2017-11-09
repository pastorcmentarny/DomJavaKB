package dms.pastor.domain;

import static dms.pastor.utils.FileTools.unlockFile;

/**
 * @author Pastor
 * Created 2011-11-05 at 00:27:34
 */
public class ShutdownHook extends Thread {

    @Override
    public void run() {
        unlockFile();
    }

}
