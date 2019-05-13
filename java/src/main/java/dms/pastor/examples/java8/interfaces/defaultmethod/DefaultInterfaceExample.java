package dms.pastor.examples.java8.interfaces.defaultmethod;


final class DefaultInterfaceExample {


    void displayFormula() {
        CubicFormula formula = new CubicFormula();
        System.out.println("Default method : " + formula.calculate(9));
        System.out.println("Implemented method : " + formula.sqrt(9));
    }


}
