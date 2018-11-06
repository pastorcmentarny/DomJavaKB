package dms.pastor.kb.java8.newIn8;

final class Java8Basics {

    public static void main(String[] args) {
        Java8Basics basics = new Java8Basics();
        basics.defaultInterface();
    }

    private void defaultInterface() {
        CubicFormula formula = new CubicFormula();
        System.out.println("Default method : " + formula.calculate(9));
        System.out.println("Implemented method : " + formula.sqrt(9));
    }

    class CubicFormula implements Formula{

        @Override
        public double calculate(final int number) {
            return sqrt(number)*number;
        }
    }

}

interface Formula {
    double calculate(int number);

    default double sqrt(int number){
        return  Math.sqrt(number);
    }
}
