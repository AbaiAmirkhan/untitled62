package model;

import exception.InvalidInputException;

public abstract class Animal implements Treatable {
    protected String name;
    protected int age;
    protected double weight;
    protected boolean vaccinated;

    public Animal(String name, int age, double weight, boolean vaccinated) throws InvalidInputException {
        setName(name);
        setAge(age);
        setWeight(weight);
        this.vaccinated = vaccinated;
    }

    
    public abstract void makeSound();
    public abstract String getType();

    
    public void setName(String name) throws InvalidInputException {
        if(name == null || name.trim().isEmpty()) throw new InvalidInputException("Name cannot be empty");
        this.name = name;
    }

    public void setAge(int age) throws InvalidInputException {
        if(age < 0) throw new InvalidInputException("Age cannot be negative");
        this.age = age;
    }

    public void setWeight(double weight) throws InvalidInputException {
        if(weight <= 0) throw new InvalidInputException("Weight must be positive");
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "[" + getType() + "] " + name + " (Age: " + age + ", Weight: " + weight + "kg, Vaccinated: " + vaccinated + ")";
    }

    public abstract void receiveTreatment(String treatment);
}
