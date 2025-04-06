package com.bridgelabz.annotations.ExerciseProblems;


class Animal{
    public void makeSound(){
        System.out.println("Dogs woof!");
    }
}

class Dog extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Woof! Woof!");

    }
}
public class OverrideDemo {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound();
    }
}
