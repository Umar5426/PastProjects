package edu.ucalgary.oop;

import java.util.*;

public class Location {
    private String name;
    private String address;
    private List<DisasterEntity> occupants;
    private List<Supply> supplies;

    public Location(String name, String address){
        this.name = name;
        this.address = address;
        this.occupants = new ArrayList<>();
        this.supplies = new ArrayList<>();
    }

    /**
     * Gets the name of the location.
     * 
     * @return The name of the location.
     */
    public String getName(){
        return name;
    }

    /**
     * Sets the name of the location.
     * 
     * @param name The name to set.
     * @throws IllegalArgumentException if the provided name is null or empty.
     */
    public void setName(String name){
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
    }

    /**
     * Gets the address of the location.
     * 
     * @return The address of the location.
     */
    public String getAddress(){
        return address;
    }

    /**
     * Sets the address of the location.
     * 
     * @param address The address to set.
     * @throws IllegalArgumentException if the provided address is null or empty.
     */
    public void setAddress(String address){
        if (address != null && !address.isEmpty()) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Address cannot be null or empty.");
        }
    }

    /**
     * Gets the list of occupants in the location.
     * 
     * @return The list of occupants.
     */
    public List<DisasterEntity> getOccupants(){
        return occupants;
    }

    /**
     * Sets the list of occupants in the location.
     * 
     * @param occupants The list of occupants to set.
     */
    public void setOccupants(List<DisasterEntity> occupants){
        this.occupants = occupants;
    }

    /**
     * Adds an occupant to the location.
     * 
     * @param occupant The occupant to add.
     * @throws IllegalArgumentException if the provided occupant is null.
     */
    public void addOccupant(DisasterEntity occupant){
        if (occupant != null) {
            occupants.add(occupant);
        } else {
            throw new IllegalArgumentException("Occupant cannot be null.");
        }
    }

    /**
     * Removes an occupant from the location.
     * 
     * @param occupant The occupant to remove.
     */
    public void removeOccupant(DisasterEntity occupant){
        occupants.remove(occupant);
    }

    /**
     * Gets the list of supplies in the location.
     * 
     * @return The list of supplies.
     */
    public List<Supply> getSupplies(){
        return supplies;
    }

    /**
     * Sets the list of supplies in the location.
     * 
     * @param supplies The list of supplies to set.
     */
    public void setSupplies(List<Supply> supplies){
        this.supplies = supplies;
    }

    /**
     * Adds a supply to the location.
     * 
     * @param supply The supply to add.
     * @throws IllegalArgumentException if the provided supply is null.
     */
    public void addSupply(Supply supply){
        if (supply != null) {
            supplies.add(supply);
        } else {
            throw new IllegalArgumentException("Supply cannot be null.");
        }
    }

    /**
     * Removes a supply from the location.
     * 
     * @param supply The supply to remove.
     */
    public void removeSupply(Supply supply){
        supplies.remove(supply);
    }
}