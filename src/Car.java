import java.io.Serializable;

public class Car implements Serializable {

    private String brand;
    private String model;
    private double price;

    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Getter
    public String getBrand() {
        return brand;
    }

    // ✅ ADD THESE SETTERS (THIS IS THE FIX)
    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("----------------------");
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : ₹" + price);
    }
}



