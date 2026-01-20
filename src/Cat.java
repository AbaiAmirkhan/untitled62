package model;

import exception.InvalidInputException;

public class Cat extends Animal {
    private String color;

    public Cat(String name, int age, double weight, boolean vaccinated, String color) throws InvalidInputException {
        super(name, age, weight, vaccinated);
        setColor(color);
    }

    public void setColor(String color) throws InvalidInputException {
        if(color == null || color.trim().isEmpty()) throw new InvalidInputException("Color cannot be empty");
        this.color = color;
    }

    public String getColor() { return color; }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }

    @Override
    public String getType() { return "Cat"; }

    @Override
    public void receiveTreatment(String treatment) {
        System.out.println(name + " the cat received treatment: " + treatment);
    }

    @Override
    public String toString() {
        return super.toString() + " | Color: " + color;
    }
}
