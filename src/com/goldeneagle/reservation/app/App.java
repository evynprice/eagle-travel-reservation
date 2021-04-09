package com.goldeneagle.reservation.app;

import com.goldeneagle.reservation.resources.DataGenerator;
import com.goldeneagle.reservation.ui.CommandLine;

public class App {
    public static void main(String[] args) {
        DataGenerator data = new DataGenerator();

        CommandLine cl = new CommandLine();
        cl.init();
    }
}
