package edu.ucalgary.oop;

public class Supply {
    private String type; // Type of the supply (e.g., food, water, medicine)
    private int quantity; // Quantity of the supply available
    private Location location; // Location where the supply is stored or available

    // Constructor with location specified
    public Supply(String type, int quantity, Location location) {
        this.type = type;
        setQuantity(quantity);
        this.location = location;
    }

    // Constructor without location specified
    public Supply(String type, int quantity) {
        this.type = type;
        setQuantity(quantity);
    }

    // Getter and setter for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and setter for quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    // Getter and setter for location
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
