package com.aqacources.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runner {

    public static void main(String[] args) {

        // We can run test in that way
        Result result = JUnitCore.runClasses(DifferenceInPricesTest.class, UnicodeTest.class, WaitersTest.class);

        // And then work with the result
        if (result.wasSuccessful()) {
            // Print successful message about task 1
            System.out.println("Tasks have done!");
        } else {
            // Or work with failures
            for (Failure failure : result.getFailures()) {
                System.err.println("Exception - " + failure.getException());
                System.err.println("Trace - " + failure.getTrace());
            }
        }

        }
    }

