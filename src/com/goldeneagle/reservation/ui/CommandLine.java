package com.goldeneagle.reservation.ui;

import java.util.Scanner;

public class CommandLine {
    public static void init() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // repeats until app quits
        while(running) {
            System.out.println("Golden Eagle Travel Reservation");
            System.out.println("--------------------------------");
            System.out.println("1) Update flight information");
            System.out.println("2) Book a flight");
            System.out.println("3) View or modify your booking");
            System.out.println("4) Exit");
            System.out.println("");
            System.out.print("Please select an option: ");
            int selection = scanner.nextInt();

            switch(selection) {
                case 1:
                    CommandLine.updateFlightInfo();
                    break;
                case 2:
                    CommandLine.bookAFlight();
                    break;
                case 3:
                    CommandLine.modifyBooking();
                    break;
                case 4:
                    running = false;
                    break;
            }
        }

        // send thank you if program quits
        System.out.println("Thank you for using Golden Eagle.");
    }

    private static void updateFlightInfo() {}

    private static void bookAFlight() {}

    private static void modifyBooking() {}
}
