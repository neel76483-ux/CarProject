import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Car> carList = new ArrayList<>();
    static final String FILE_NAME = "cars.dat";

    public static void main(String[] args) {

        loadFromFile();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== CAR MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Car");
            System.out.println("2. View Cars");
            System.out.println("3. Search Car");
            System.out.println("4. Update Car");
            System.out.println("5. Delete Car");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addCar(sc);
                case 2 -> viewCars();
                case 3 -> searchCar(sc);
                case 4 -> updateCar(sc);
                case 5 -> deleteCar(sc);
                case 6 -> {
                    saveToFile();
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addCar(Scanner sc) {
        System.out.print("Brand: ");
        String brand = sc.nextLine();
        System.out.print("Model: ");
        String model = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();

        carList.add(new Car(brand, model, price));
        System.out.println("Car added.");
    }

    static void viewCars() {
        if (carList.isEmpty()) {
            System.out.println("No cars available.");
            return;
        }
        carList.forEach(Car::displayDetails);
    }

    static void searchCar(Scanner sc) {
        System.out.print("Enter brand: ");
        String brand = sc.nextLine();
        boolean found = false;

        for (Car c : carList) {
            if (c.getBrand().equalsIgnoreCase(brand)) {
                c.displayDetails();
                found = true;
            }
        }
        if (!found) System.out.println("Car not found.");
    }

    static void updateCar(Scanner sc) {
        System.out.print("Enter brand to update: ");
        String brand = sc.nextLine();

        for (Car c : carList) {
            if (c.getBrand().equalsIgnoreCase(brand)) {
                System.out.print("New Model: ");
                c.setModel(sc.nextLine());
                System.out.print("New Price: ");
                c.setPrice(sc.nextDouble());
                System.out.println("Updated successfully.");
                return;
            }
        }
        System.out.println("Car not found.");
    }

    static void deleteCar(Scanner sc) {
        System.out.print("Enter brand to delete: ");
        String brand = sc.nextLine();

        carList.removeIf(c -> c.getBrand().equalsIgnoreCase(brand));
        System.out.println("Deleted if existed.");
    }

    // 🔹 File Handling
    static void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(carList);
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    static void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            carList = (ArrayList<Car>) in.readObject();
        } catch (Exception ignored) {}
    }
}



