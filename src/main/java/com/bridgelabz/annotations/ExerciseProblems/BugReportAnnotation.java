package com.bridgelabz.annotations.ExerciseProblems;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports{
    BugReport[] value();
   }

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport{
    String description();
}

public class BugReportAnnotation {

    @BugReport(description = "Null pointer when input is null")
    @BugReport(description = "Incorrect output for negative numbers")
    public void processData(){
        System.out.println("Processing data...");
    }

    public static void main(String[] args) throws Exception {
        Method method = BugReportAnnotation.class.getMethod("processData");

        BugReport[] reports = method.getAnnotationsByType(BugReport.class);

        for (BugReport report : reports) {
            System.out.println("Bug: " + report.description());
        }
    }
}
