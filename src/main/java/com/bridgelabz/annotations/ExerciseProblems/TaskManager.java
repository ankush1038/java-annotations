package com.bridgelabz.annotations.ExerciseProblems;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

    @Retention(RetentionPolicy.RUNTIME) // Make it accessible at runtime
    @Target(ElementType.METHOD)  // Can be applied to methods only
    @interface TaskInfo{
        String priority();
        String assignedTo();
    }


public class TaskManager {

    @TaskInfo(priority = "High" ,assignedTo = "Ankush Sharma")
    public void completeTask(){
            System.out.println("Task Completed");
    }

    @TaskInfo(priority = "Low", assignedTo = "Akshit Chauhan")
    public void cleanWorkSpace(){
        System.out.println("WorkSpace cleaned");
    }
}
