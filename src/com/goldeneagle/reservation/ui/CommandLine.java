package com.goldeneagle.reservation.ui;

import com.goldeneagle.reservation.resources.City;
import com.goldeneagle.reservation.resources.DataGenerator;
import com.goldeneagle.reservation.resources.Flight;
import com.goldeneagle.reservation.resources.Seat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        
        // initialize variables
        List<City> cities = data.getCities();
        City selectedDepartureCity;
        City selectedArrivalCity;

        // print all of the possible cities. Repeat while the selected departure city equals the selected arrival city
        do {
            System.out.println("Please select your departure city:");
            
            // print all of the cities as a list
            for (int i=0; i < cities.size(); i++) {
                System.out.println((i+1) + ") " + cities.get(i).getName());
            }
            
            // print an option to return to the main menu
            System.out.println(cities.size() + 1 + ") Return to menu");
            
            // collect selection from user
            System.out.print("\nSelection: ");
            int departureSelection = this.scanner.nextInt();

            // return if quit is selected
            if (departureSelection == cities.size() + 1) {
                System.out.println("--------------------------------");
                return;
            };

            // fetch city object by selected index
            selectedDepartureCity = cities.get(departureSelection - 1);

            System.out.println("--------------------------------");
            System.out.println("Please select your arrival city: ");

            // print all cities
            for (int i=0; i < cities.size(); i++) {
                System.out.println((i+1) + ") " + cities.get(i).getName());
            }
            
            // print return menu option
            System.out.println(cities.size() + 1 + ") Return to menu");
            
            // gather arrival selection
            System.out.print("\n" + "Selection: ");
            int arrivalSelection = this.scanner.nextInt();

            // return if quit is selected
            if (arrivalSelection == cities.size() + 1) {
                System.out.println("--------------------------------");
                return;
            };

            // fetch city object by index
            selectedArrivalCity = cities.get(arrivalSelection - 1);
            
            // if selected departure and arrival cities are the same, send error message
            if (selectedDepartureCity.equals(selectedArrivalCity)) {
                System.out.println("--------------------------------");
                System.out.println("Departure City cannot be the same as the Arrival City");
            }
            System.out.println("--------------------------------");
            
            // repeat while selected cities are the same
        } while(selectedDepartureCity.equals(selectedArrivalCity));

        // create a list of date time options
        List<LocalDateTime> dateTimeOptions = new ArrayList<>();
        
        // loop through all of the generated date times
        for (LocalDateTime dateTime : this.data.getDateTimes()) {
            
            // for every date time, loop through all of the generated flights
            for (Flight flight : this.data.getFlights()) {
                
                // if the flight date is the same as the current date in the loop AND
                // the flight arrival city is the same as the selected arrival city AND
                // the flight departure city is the same as the selected departure city
                // add that date time to the list of possible dates
                if (flight.getDateTime().equals(dateTime) && flight.getArrivalCity().equals(selectedArrivalCity)
                    && flight.getDepartureCity().equals(selectedDepartureCity)) {

                    // check if the date already exists in the list before adding it
                    if (!dateTimeOptions.contains(dateTime)) {
                        dateTimeOptions.add(dateTime);
                    }
                }
            }
        }

        // print all of the dates that were filtered above
        System.out.println("Please select your departure date: ");
        for (int i=0; i < dateTimeOptions.size(); i++) {
            LocalDateTime dateTime = dateTimeOptions.get(i);
            String dateTimeFormatted = dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

            System.out.println((i+1) + ") " + dateTimeFormatted);
        }

        System.out.println(dateTimeOptions.size() + 1 + ") Return to menu");
        System.out.print("Selection: ");
        int selectedDate = this.scanner.nextInt();

        // return if quit is selected
        if (selectedDate == dateTimeOptions.size() + 1) {
            System.out.println("--------------------------------");
            return;
        };

        // fetch the selected date time
        LocalDateTime selectedDateTime = dateTimeOptions.get(selectedDate - 1);
        System.out.println("--------------------------------");

        // fetch flights that match destination, departure, and date
        List<Flight> selectedFlights = new ArrayList<>();

        for (Flight flight : data.getFlights()) {
            // check if selected departure city equals flight departure city
            // check if selected arrival city equals flight arrival city
            // check if selected date equals flight date
            if (flight.getDepartureCity().equals(selectedDepartureCity) &&
                flight.getArrivalCity().equals(selectedArrivalCity) &&
                flight.getDateTime().equals(selectedDateTime)) {
                selectedFlights.add(flight);
            }
        }

        // start with seatIsAvailable to false
        boolean seatIsAvailable = false;
        
        // initialize selected seat object
        Seat selectedSeat = null;

        // print all of the flights
        System.out.println("Please select a flight: ");
        do {
            for (int i=0; i < selectedFlights.size(); i++) {
                Flight flight = selectedFlights.get(i);
                int hours = (int) flight.getDuration().toHours();
                int minutes = (int) flight.getDuration().minusHours(hours).toMinutes();

                int availableSeatCount = 0;

                for (Seat seat : flight.getSeats()) {
                    if (seat.isAvailable()) {
                        availableSeatCount++;
                    }
                }

                //TODO set this to print actual data (flight name, num, depCity, arrCity, dateTime, duration, price, and how many seats out of 25 are available
                System.out.printf((i+1) + ") %s %s-%s: %dh %dm - $%5.2f %d/25 seats %n", flight.getName(),
                        flight.getDepartureCity().getAirport(), flight.getArrivalCity().getAirport(),
                        hours, minutes, flight.getPrice(), availableSeatCount);
            }

            System.out.println(selectedFlights.size() + 1 + ") Return to menu");
            System.out.print("Selection: ");

            int flightSelection = this.scanner.nextInt();

            // return if quit is selected
            if (flightSelection == selectedFlights.size() + 1) return;

            // fetch flight object by index
            Flight flight = selectedFlights.get(flightSelection - 1);

            //TODO check if seats are available, if not then return to prompt. If so then continue
            for (Seat seat : flight.getSeats()) {
                if (seat.isAvailable()) {
                    selectedSeat = seat;
                    seatIsAvailable = true;
                }
            }

            if (!seatIsAvailable) {
                System.out.println("--------------------------------");
                System.out.println("There were no seats available for the selected flight. Please select a different flight");
            }
            System.out.println("--------------------------------");

        } while (!seatIsAvailable);

        boolean doesEmailExist;
        String email;

        do {
            doesEmailExist = false;
            System.out.print("Please enter your email: ");
            email = this.scanner.next();

            for (Flight listFlight : this.data.getFlights()) {
                for (Seat listSeat : listFlight.getSeats()) {
                    if (listSeat.getEmail().equals(email)) {
                        doesEmailExist = true;
                    }
                }
            }

            if (doesEmailExist) {
                System.out.println("That email is already being used, please enter a new email");
            }
            System.out.println("--------------------------------");
        } while (doesEmailExist);

        selectedSeat.setAvailable(false);
        selectedSeat.setEmail(email);

        System.out.println("Your reservation has been booked under " + email + ", your seat is #" + selectedSeat.getName());

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
