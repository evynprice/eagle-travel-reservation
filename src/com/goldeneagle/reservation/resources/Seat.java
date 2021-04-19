package com.goldeneagle.reservation.resources;

/*
    Stores seat information
 */
public class Seat {
    // initiate instance variables
    private final String name;
    private String email;
    private boolean available;

    /**
     * Seat constructor that sets the name and boolean and sets the email to ""
     * @param name
     * @param available
     */
    public Seat(String name, boolean available) {
        this.name = name;
        this.email = "";
        this.available = available;
    }

    /**
     * Returns the users name as a String
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Return the availability status of the seat
     * @return boolean available
     */
    public boolean isAvailable() {
        return this.available;
    }

    /**
     * Sets user email
     * @param contact name
     */
    public void setEmail(String contact) {
        this.email = contact;
    }

    /**
     * Sets the seat available status
     * @param available boolean
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * returns the email as a string
     * @return
     */
    public String getEmail() {
        return email;
    }
}
