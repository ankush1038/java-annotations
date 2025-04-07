package com.bridgelabz.annotations.AdvancedLevel;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

// Class with expensive method
class ExpensiveCalculator {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int fibonacci(int n) {
        if (cache.containsKey(n)) {
            System.out.println("Returning from cache for n = " + n);
            return cache.get(n);
        }

        System.out.println("Computing fibonacci for n = " + n);
        int result;
        if (n <= 1) result = n;
        else result = fibonacci(n - 1) + fibonacci(n - 2);

        cache.put(n, result);
        return result;
    }
    public static void main(String[] args) throws Exception {
        ExpensiveCalculator calculator = new ExpensiveCalculator();

        // Call the method with the same input to show caching in action
        System.out.println("Result 1: " + calculator.fibonacci(5));
        System.out.println("Result 2: " + calculator.fibonacci(5)); // From cache
        System.out.println("Result 3: " + calculator.fibonacci(6)); // Partially from cache
    }
}

