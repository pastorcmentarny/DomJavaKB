package dms.pastor.examples;

import dms.pastor.domain.exception.SomethingWentWrongException;

/*
 *  An ExceptionInInitializerError is thrown to indicate that an exception occurred during evaluation of a static initializer
 *  or the initializer for a static variable.
 */
public class ExceptionInInitializerErrorExample {

    static {
        throwExceptionHere();
    }

    private static void throwExceptionHere() {
        throw new SomethingWentWrongException("Exception occurred in static block");
    }

    public static void main(String[] args) {
        System.out.println("RunningExceptionInInitializerError Example");
    }
}
