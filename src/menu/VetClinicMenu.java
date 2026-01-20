package menu;

import exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Scanner;

public class VetClinicMenu implements menu.Menu {
    private ArrayList<model.Animal> allAnimals = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n=== VET CLINIC MANAGEMENT SYSTEM ===");
        System.out.println("1. Add Dog");
        System.out.println("2. Add Cat");
        System.out.println("3. View All Animals");
        System.out.println("4. Make All Animals Speak");
        System.out.println("5. Give Treatment to Animals");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }

    @Override
    public void run() {
        boolean running = true;
        while(running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch(choice) {
                    case 1: addDog(); break;
                    case 2: addCat(); break;
                    case 3: viewAllAnimals(); break;
                    case 4: makeAllSpeak(); break;
                    case 5: treatAllAnimals(); break;
                    case 0: running = false; break;
                    default: System.out.println("Invalid choice!"); break;
                }
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Exiting Vet Clinic. Goodbye!");
    }

    private void addDog() {
        try {
            System.out.print("Name: "); String name = scanner.nextLine();
            System.out.print("Age: "); int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Weight: "); double weight = Double.parseDouble(scanner.nextLine());
            System.out.print("Vaccinated (true/false): "); boolean vac = Boolean.parseBoolean(scanner.nextLine());
            System.out.print("Breed: "); String breed = scanner.nextLine();
            allAnimals.add(new model.Dog(name, age, weight, vac, breed));
            System.out.println("Dog added successfully!");
        } catch(InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addCat() {
        try {
            System.out.print("Name: "); String name = scanner.nextLine();
            System.out.print("Age: "); int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Weight: "); double weight = Double.parseDouble(scanner.nextLine());
            System.out.print("Vaccinated (true/false): "); boolean vac = Boolean.parseBoolean(scanner.nextLine());
            System.out.print("Color: "); String color = scanner.nextLine();
            allAnimals.add(new model.Cat(name, age, weight, vac, color));
            System.out.println("Cat added successfully!");
        } catch(InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewAllAnimals() {
        System.out.println("\n--- ALL ANIMALS ---");
        if(allAnimals.isEmpty()) { System.out.println("No animals found."); return; }
        for(model.Animal a : allAnimals) System.out.println(a);
    }

    private void makeAllSpeak() {
        System.out.println("\n--- ANIMALS SPEAK ---");
        for(model.Animal a : allAnimals) a.makeSound(); // Polymorphism
    }

    private void treatAllAnimals() {
        System.out.print("Enter treatment: ");
        String treatment = scanner.nextLine();
        for(model.Animal a : allAnimals) a.receiveTreatment(treatment); // Polymorphism
    }
}
