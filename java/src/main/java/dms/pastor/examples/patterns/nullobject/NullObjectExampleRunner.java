package dms.pastor.examples.patterns.nullobject;

public class NullObjectExampleRunner {

    public static void main(String[] args) {
        System.out.println(ProcessorFactory.selectProcessorFor("?", null).process());
    }


}
