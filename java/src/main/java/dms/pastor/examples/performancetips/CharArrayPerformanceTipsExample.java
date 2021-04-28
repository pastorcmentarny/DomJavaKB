package dms.pastor.examples.performancetips;

/*
use String.toCharArray for
processing. This will create a new char[] which needs to be collected. The
same code has been rewritten to use String.charAt to reduce the overhead.
 */
public class CharArrayPerformanceTipsExample {
    private String example = "Bla bla bla ";

    public void badExample(){
        example.toCharArray();
    }

    public void goodExample(){
        final var result = example.charAt(0);
    }
}
