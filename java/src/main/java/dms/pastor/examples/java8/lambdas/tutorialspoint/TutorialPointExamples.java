package dms.pastor.examples.java8.lambdas.tutorialspoint;

/*
http://www.tutorialspoint.com/java8/java8_lambda_expressions.htm
 */
public class TutorialPointExamples {

    public static void main(String[] args) {
        TutorialPointExamples exampleRunner = new TutorialPointExamples();

        MathOperation addition = Integer::sum;
        MathOperation substraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> a / b;


        //displayResult("Result of 5+8 is:",result);

    }


}
