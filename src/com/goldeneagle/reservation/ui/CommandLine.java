package com.goldeneagle.reservation.ui;

import com.goldeneagle.reservation.resources.City;
import com.goldeneagle.reservation.resources.DataGenerator;
import com.goldeneagle.reservation.resources.Flight;
import com.goldeneagle.reservation.resources.Seat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandLine {

    private Scanner scanner = new Scanner(System.in);
    private DataGenerator data;

    public CommandLine(DataGenerator data) {
        this.data = data;
    }

    public void init() {
        boolean running = true;

        System.out.println("Golden Eagle Travel Reservation");
        System.out.println("--------------------------------");

        // repeats until app quits
        while(running) {
            System.out.println("1) Book a flight");
            System.out.println("2) View or modify your booking");
            System.out.println("3) Exit" + "\n");
            System.out.print("Please select an option: ");
            int selection = this.scanner.nextInt();
            System.out.println("--------------------------------");

            switch(selection) {
                case 1:
                    this.bookFlight();
                    break;
                case 2:
                    this.modifyBooking();
                    break;
                case 3:
                    running = false;
                    break;
            }
        }

        // send thank you if program quits
        System.out.println("Thank you for using Golden Eagle.");
    }

    private void bookFlight() {
        /* Pull in list of cities and print with for loop, ex:
        1) Chattanooga, TN
        2) Atlanta, GA
        3) Nashville, TN
         */

        List<City> cities = data.getCities();
        City departureCity;
        City arrivalCity;

        do {
            for (int i=0; i < cities.size(); i++) {
                System.out.println((i+1) + ") " + cities.get(i).getName());
            }
            System.out.println(cities.size() + 1 + ") Return to menu");
            System.out.print("\n" + "Please select your departure city: ");
            int dep = this.scanner.nextInt();

            // return if quit is selected
            if (dep == cities.size() + 1) {
                System.out.println("--------------------------------");
                return;
            };

            // fetch city object by index
            departureCity = cities.get(dep - 1);

            System.out.println("--------------------------------");

            for (int i=0; i < cities.size(); i++) {
                System.out.println((i+1) + ") " + cities.get(i).getName());
            }
            System.out.println(cities.size() + 1 + ") Return to menu");
            System.out.print("\n" + "Please select your arrival city: ");

            int arr = this.scanner.nextInt();

            // return if quit is selected
            if (arr == cities.size() + 1) {
                System.out.println("--------------------------------");
                return;
            };

            // fetch city object by index
            arrivalCity = cities.get(arr - 1);
            if (departureCity.equals(arrivalCity)) {
                System.out.println("--------------------------------");
                System.out.println("Departure City cannot be the same as the Arrival City");
            }
            System.out.println("--------------------------------");
        } while(departureCity.equals(arrivalCity));

        //TODO This should pull a list of possible dates instead of asking for a date
        System.out.print("Please enter your departure date (MM-DD-YY): ");
        String date = this.scanner.next();
        System.out.println("--------------------------------");

        // fetch flights that match destination, departure, and date
        //TODO check every flight in the list, and see if the destination and arrival cities match, then check if the date matches
        List<Flight> selectedFlights = new ArrayList<>();

        for (Flight flight : data.getFlights()) {
            // check if selected departure city equals flight departure city
            // check if selected arrival city equals flight arrival city
            // check if selected date equals flight date
            if (true) {
                selectedFlights.add(flight);
            }
        }

        for (int i=0; i < selectedFlights.size(); i++) {
            Flight flight = selectedFlights.get(i);
            int hours = (int) flight.getDuration().toHours();
            int minutes = (int) flight.getDuration().minusHours(hours).toMinutes();

            //TODO set this to print actual data (flight name, num, depCity, arrCity, dateTime, duration, price, and how many seats out of 25 are available
            System.out.printf((i+1) + ") %s %s-%s: %dh %dm - $%5.2f %n", flight.getName(), "CHA", "ATL", hours, minutes, flight.getPrice());
        }

        System.out.println(selectedFlights.size() + 1 + ") Return to menu");
        System.out.print("\n" + "Please select a flight: ");

        int fli = this.scanner.nextInt();

        // return if quit is selected
        if (fli == selectedFlights.size() + 1) return;

        // fetch flight object by index
        Flight flight = selectedFlights.get(fli - 1);

        Seat yourSeat = null;
        //TODO check if seats are available, if not then return to prompt. If so then continue
        for (Seat seat : flight.getSeats()) {
            if (seat.isAvailable()) {
                yourSeat = seat;
            }
        }

        if (yourSeat == null) {
            // print sorry there were no seats, repeat the selection
        }

        System.out.println("--------------------------------");

        System.out.print("Please enter your email: ");
        String email = this.scanner.next();

        //possibly a way to deal with double booking but still needs an option to stop.
        while(email.equals(seat.getEmail))
        {

            System.out.println("Email is already booked to a flight");

            System.out.print("Please enter your email: ");
            email = this.scanner.next();
        }



        System.out.println("--------------------------------");



        //TODO check if this email is currently in use in a flight, if so ask for a different email

        yourSeat.setAvailable(false);
        yourSeat.setEmail(email);

        System.out.println("Your reservation has been booked under " + email + ", your seat is #" + yourSeat.getName());

        System.out.println("--------------------------------");

    }

    private void modifyBooking() {
        System.out.print("What is your email? ");
        String email = scanner.next();

        List<Flight> yourFlights = new ArrayList<>();
        List<Seat> yourSeats = new ArrayList<>();

        for (Flight flight : data.getFlights()) {
            for (Seat seat : flight.getSeats()) {
                if (seat.getEmail().equals(email)) {

                }
            }
        }

        for (Flight flight : yourFlights) {
            System.out.println(); // flight info
        } // ask which flight you would like to modify

        // loop through the seats in the flight that you asked to modify

        //TODO ask you for your email
        //Loop through all of the flights, for each flight loop through all of the seats
        //if your email matches the seat email, set your flight equal to the current flight and your seat equal to the current seat
        //Display your flight and seat number
        //Ask if you would like to cancel
        // If you would like to cancel, set your seat to be available and your email to be ""
        //Else, return to menu
    }
}
