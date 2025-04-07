package com.bridgelabz.annotations.ExerciseProblems;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) // Make it accessible at runtime
    @Target(ElementType.METHOD)  // Can be applied to methods only
    @interface TaskInfo{
        String priority();
        String assignedTo();
    }


public class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Ankush Sharma")
    public void completeTask() {
        System.out.println("Task Completed");
    }

    @TaskInfo(priority = "Low", assignedTo = "Akshit Chauhan")
    public void cleanWorkSpace() {
        System.out.println("WorkSpace cleaned");
    }


    public static void main(String[] args) {
            try {
                // Directly access the 'completeTask' method by name
                Method method = TaskManager.class.getMethod("completeTask");

                if (method.isAnnotationPresent(TaskInfo.class)) {
                    TaskInfo task = method.getAnnotation(TaskInfo.class);
                    System.out.println("Priority: " + task.priority());
                    System.out.println("Assigned To: " + task.assignedTo());
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
}
