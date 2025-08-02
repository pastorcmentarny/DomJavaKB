package dms.pastor.domain;

import static dms.pastor.utils.file.FileUtils.unlockFile;

/**
 * Author Dominik Symonowicz
 * Created 2011-11-05 at 00:27:34
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class ShutdownHook extends Thread {

    @Override
    public void run() {
        unlockFile();
    }

}
