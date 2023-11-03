package dms.pastor.examples.java21;

public class SwitchPatternMatching {
    public static void main(String[] args) {
        runSwitchPatternMatchingExamples();
    }

    private static void runSwitchPatternMatchingExamples() {
        System.out.println(getTemplateId(1));
        System.out.println(getTemplateId(3.01));
        System.out.println(getTemplateId("312"));
        System.out.println(getTemplateId('1'));
    }



        static String getTemplateId(Object obj) {
            return switch (obj) {
                case Integer i -> String.format("%d (from int)", i);
                case Double d  -> String.format("Template ID  %f (from double)", d);
                case Long l    -> String.format("Template ID  %d (from long)", l);
                case String s  -> String.format("Template ID %s (from String)", s);
                default        -> obj.toString();
            };
        }

}
