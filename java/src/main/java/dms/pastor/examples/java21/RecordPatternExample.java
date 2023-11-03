package dms.pastor.examples.java21;

public class RecordPatternExample {

    record Template(int id, String name) {}
    public static void main(String[] args) {
        runRecordPatternsExample();
    }

    private static void runRecordPatternsExample() {
        printTemplate(new Template(404, "Cancelled Order"));
    }

    static void printTemplate(Object obj) {
        if (obj instanceof Template(int id, String name)) {
            System.out.printf("%s (%d)%n", name, id);
        }

        /*
        if (obj instanceof Template template) {
        int id = template.id();
        String name = template.name();
        System.out.printf("%s (%d)%n", name, id);
         */
    }
}
