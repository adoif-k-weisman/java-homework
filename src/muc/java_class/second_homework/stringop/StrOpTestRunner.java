package muc.java_class.second_homework.stringop;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class StrOpTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(StrOpTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("All Tests Passed: " + result.wasSuccessful());
    }
}
