package com.bridgelabz.annotations.IntermediateLevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the @LogExecutionTime annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

// Class with methods we want to time
class PerformanceTester {

    @LogExecutionTime
    public void methodOne() {
        for (int i = 0; i < 1_000_000; i++); // Dummy loop
    }

    @LogExecutionTime
    public void methodTwo() {
        for (int i = 0; i < 10_000_000; i++); // Bigger dummy loop
    }

    public void methodWithoutAnnotation() {
        System.out.println("This method is not measured.");
    }
}

// Main class to execute and measure time
public class ExecutionTimer {
    public static void main(String[] args) throws Exception {
        PerformanceTester tester = new PerformanceTester();

        Method[] methods = PerformanceTester.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(tester);
                long end = System.nanoTime();

                long duration = end - start;

                System.out.println("Executed method: " + method.getName());
                System.out.println("Execution time (ns): " + duration);
                System.out.println("---------------------------");
            }
        }
    }
}

