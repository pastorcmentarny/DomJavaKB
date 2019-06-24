package dms.pastor.domain.exception;

public class GobshiteException extends RuntimeException {
    public GobshiteException(Throwable throwable) {
        super("Shit happens because you have no f..king clue what are you doing! Learn things and fix your mess!", throwable);
    }
}
