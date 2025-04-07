package com.bridgelabz.annotations.BeginnerLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}
public class TodoReader {

    @Todo(task = "Implement login feature", assignedTo = "Ankush Sharma", priority = "high")
    public void loginFeature(){
        System.out.println("login feature pending...");
    }

    @Todo(task = "Add logout functionality", assignedTo = "Akshit Chauhan", priority = "low")
    public void logoutFeature(){
        System.out.println("Logout feature pending...");
    }

    public void completedFeature(){
        System.out.println("This feature is completed");
    }

    public static void main(String[] args) {
        Method[] methods = TodoReader.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("---------------------------");
            }
        }
    }
}
