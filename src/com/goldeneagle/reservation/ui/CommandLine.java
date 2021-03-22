package com.goldeneagle.reservation.ui;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandLine {

    private Scanner scanner = new Scanner(System.in);

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
                    this.bookAFlight();
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

    private void bookAFlight() {
        /* Pull in list of cities and print with for loop, ex:
        1) Chattanooga, TN
        2) Atlanta, GA
        3) Nashville, TN
         */

        // temporary example, the real list would store City objects
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Chattanooga, TN");
        cities.add("Atlanta, GA");
        cities.add("Nashville, TN");

        for (int i=0; i < cities.size(); i++) {
            System.out.println((i+1) + ") " + cities.get(i));
        }
        System.out.println(cities.size() + 1 + ") Return to menu");
        System.out.print("\n" + "Please select your departure city: ");
        int dep = this.scanner.nextInt();

        // return if quit is selected
        if (dep == cities.size() + 1) return;

        // fetch city object by index
        // City departure = cities.get(selection - 1);

        System.out.println("--------------------------------");

        for (int i=0; i < cities.size(); i++) {
            System.out.println((i+1) + ") " + cities.get(i));
        }
        System.out.println(cities.size() + 1 + ") Return to menu");
        System.out.print("\n" + "Please select your arrival city: ");

        int arr = this.scanner.nextInt();

        // return if quit is selected
        if (arr == cities.size() + 1) return;

        // fetch city object by index
        // City departure = cities.get(selection - 1);

        // check if departure city is the same as destination city and send error if true
        // if (departure.equals(destination)) {}

        System.out.println("--------------------------------");

        // fetch departure date and most likely use regex parse and store as Date format.
        System.out.print("Please enter your departure date (MM-DD-YY): ");
        String date = this.scanner.next();
        System.out.println("--------------------------------");

        // fetch flights that match destination, departure, and date

        // temporary example, production should be a list of Flight objects
        ArrayList<String> flights = new ArrayList<>();
        flights.add("United 5701 ATL-CHA (3:35pm - 5:32pm) - 2h:21m");
        flights.add("Delta 3817 ATL-CHA (2:32pm - 4:56pm) - xh:ym");
        flights.add("American 1932 ATL-CHA (3:25pm - 4:12pm) - xh:ym");

        for (int i=0; i < flights.size(); i++) {
            System.out.println((i+1) + ") " + flights.get(i));
        }
        System.out.println(flights.size() + 1 + ") Return to menu");
        System.out.print("\n" + "Please select a flight: ");

        int fli = this.scanner.nextInt();

        // return if quit is selected
        if (fli == flights.size() + 1) return;

        // fetch flight object by index
        // Flight flight = flight.get(selection - 1);

        // check if seats are available, if not then return to prompt. If so then continue

        System.out.println("--------------------------------");

        System.out.print("Please enter your email: ");
        String email = this.scanner.next();

        System.out.println("--------------------------------");

        // lower flight seats by 1, most likely add flight to HashMap with email as key

        System.out.println("Your reservation has been booked under " + email);

        System.out.println("--------------------------------");
    }

    private void modifyBooking() {}
}
