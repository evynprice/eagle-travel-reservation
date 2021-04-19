package com.goldeneagle.reservation.app;

import com.goldeneagle.reservation.resources.DataGenerator;
import com.goldeneagle.reservation.ui.CommandLine;

public class App {

    /**
     * This method starts the program and creates DataGenerator and CommandLine objects.
     * It then runs the command line initiation method
     * @param args
     */
    public static void main(String[] args) {
        DataGenerator data = new DataGenerator();

        CommandLine cl = new CommandLine(data);
        cl.init();
    }
}
