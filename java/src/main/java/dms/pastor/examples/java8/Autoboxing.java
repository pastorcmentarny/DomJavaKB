package dms.pastor.kb.java8;

import java.util.Objects;
import java.util.Random;

final class Autoboxing {

    public static void main(String[] args) {
        /*
         JVM that is only caching int between -128 to 127.
         */
        //noinspection NumberEquality
        System.out.println(Integer.valueOf("127") == Integer.valueOf("127"));
        //noinspection NumberEquality
        System.out.println(Integer.valueOf("128") == Integer.valueOf("128"));

        //check result using equals instead of ==
        System.out.println(Integer.valueOf("127").equals(Integer.valueOf("127")));
        System.out.println(Integer.valueOf("128").equals(Integer.valueOf("128")));

        //this is used only to check how looks situation when you using Object comparison
        System.out.println(Objects.equals(Integer.valueOf("127"), Integer.valueOf("127")));
        System.out.println(Objects.equals(Integer.valueOf("128"), Integer.valueOf("128")));


        int test = new Random().nextInt(Integer.MAX_VALUE);
        /*
            compiler will choose widening over boxing,
            According to IntellIJ second method is not used, but as compiler will choose widening over boxing,
             then actually overloadedMethod will be used instead :)
         */
        overloadedMethod(test);


        /*---------------------------------//
        // NPE //
        unboxing of 'testNPE' may produce 'java.lang.NullPointerException
        Boolean testNPE = null;
        if(testNPE){
            System.out.println("Unreach statement");
        }
        */
    }

    private static void overloadedMethod(long number) {
        System.out.println("Primitive long:" + number);
    }


    /*
    Actually it is used and method private static void overloadedMethod(long number) is not used
     */
    @SuppressWarnings("unused")
    private static void overloadedMethod(Integer number) {
        System.out.println("Wrapped Integer " + number);
    }

}
