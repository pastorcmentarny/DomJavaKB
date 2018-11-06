package dms.pastor.kb.java.exceptions;

public class AutoClosableExample {
/*
I’d say, this looks a lot better. To use this syntax, any class that participates in the try-with-resources statement should implement interface AutoCloseable, which looks like this:

public interface AutoCloseable {
    void close() throws Exception;
}
It is recommended that all classes that implement this interface declare more specific exception types in their close() method signature than their parent class does. Otherwise, don't declare anything if invoking their close() method will not throw any exception.
 */
}
