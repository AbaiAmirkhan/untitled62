package model;

import exception.InvalidInputException;

public class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, double weight, boolean vaccinated, String breed) throws InvalidInputException {
        super(name, age, weight, vaccinated);
        setBreed(breed);
    }

    public void setBreed(String breed) throws InvalidInputException {
        if(breed == null || breed.trim().isEmpty()) throw new InvalidInputException("Breed cannot be empty");
        this.breed = breed;
    }

    public String getBreed() { return breed; }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof Woof!");
    }

    @Override
    public String getType() { return "Dog"; }

    @Override
    public void receiveTreatment(String treatment) {
        System.out.println(name + " the dog received treatment: " + treatment);
    }

    @Override
    public String toString() {
        return super.toString() + " | Breed: " + breed;
    }
}
