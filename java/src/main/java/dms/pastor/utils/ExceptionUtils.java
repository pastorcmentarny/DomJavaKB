package dms.pastor.utils;

import javax.annotation.Nullable;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ExceptionUtils {

    public static boolean isIgnorableException(@Nullable Throwable throwableException) {
        return (throwableException instanceof FileNotFoundException ||
                throwableException instanceof UnknownHostException ||
                throwableException instanceof SocketException);
    }
}
