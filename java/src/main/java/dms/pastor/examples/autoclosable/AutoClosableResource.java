package dms.pastor.examples.autoclosable;

public class AutoClosableResource implements AutoCloseable {
    public AutoClosableResource() {
        System.out.println("Creating imaginary resource (let's say ... stream)");
    }

    public String performingActionPackedOperation() {
        System.out.println("Working hard in progres..");
        return "result";
    }

    @Override
    public void close() throws Exception {
        System.out.println("Clean up the mess");
    }
}
