package com.bridgelabz.annotations.BeginnerLevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

// Class with annotated methods
class Service {

    @ImportantMethod
    public void processPayment() {
        System.out.println("Processing payment...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void generateInvoice() {
        System.out.println("Generating invoice...");
    }

    public void logActivity() {
        System.out.println("Logging activity...");
    }
}

// Use reflection to read annotated methods
public class AnnotationReader {
    public static void main(String[] args) {
        Method[] methods = Service.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Importance Level: " + annotation.level());
                System.out.println("------------------------");
            }
        }
    }
}

