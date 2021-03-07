package dms.pastor.examples.autoclosable;

/**
 * An example of implementing autoclosable interface so you can use with
 * try with resource to have cleanup happen automatically by jvm
 * It also useful using convert try-catch-finally into try-with-resource
 */
class AutoClosableExample {
    public static void main(String[] args) {
        try (AutoClosableResource resource = new AutoClosableResource()) {
            System.out.println(resource.performingActionPackedOperation());
        } catch (Exception unexpectedException) {
            System.out.println(unexpectedException.getMessage());
        }
    }
}
