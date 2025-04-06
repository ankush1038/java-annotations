package com.bridgelabz.annotations.ExerciseProblems;

import java.util.*;
public class UncheckedWarnings {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("Ankush");
        list.add("Sharma");
        list.add(21);

        for (Object item : list){
            System.out.println(item);
        }
    }
}
