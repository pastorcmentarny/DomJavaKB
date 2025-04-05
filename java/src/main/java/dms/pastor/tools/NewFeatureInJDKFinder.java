package dms.pastor.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class NewFeatureInJDKFinder {
    //find@since
    private String app() {
        List<String> answers = new ArrayList<>();
        Class<?> stringName = String.class;
        answers.add(stringName.getName());
        Supplier<String> supplierName = () -> "Supplier name";
        answers.add(supplierName.getClass().getName());
        return String.join("\n", answers);
    }

    public static void main(String[] args) {
        System.out.println(new NewFeatureInJDKFinder().app());
    }
}
