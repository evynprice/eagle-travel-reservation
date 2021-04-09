package com.goldeneagle.reservation.resources;

public class Seat {

    private final String name;
    private String email;
    private boolean available;


    /**
     * Seat constructor that takes in name and email
     * @param name
     * @param email
     */
    public Seat(String name, String email) {
      this.name = name;
      this.email = email;
    }
    
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

    /**
     * Books the seat if the random check is true
     * @param customer
     * @param contact
     * @return
     */
    public boolean bookSeat(String customer, String contact) {
        if (this.available != true) {
            return false;
        } else {
            this.email = contact;
            this.available = false;
            return true;
        }
    }
}
