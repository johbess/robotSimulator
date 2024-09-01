package com.hiq.robotSimulator;

import java.io.*;
import java.net.URL;

public class RobotSimulator {
    public static void main(String[] args) {

        Robot robot = new Robot();

        String filePath = RobotSimulator.class.getClassLoader().getResource("test3").getPath();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String input;

            while ((input = br.readLine()) != null) {
                robot.postCommand(input);
            }

        } catch (FileNotFoundException e) {
            System.err.println(String.format("Could not find file path %s: %s", filePath, e.getCause()));
        } catch (IOException e) {
            System.err.println(String.format("Could not read next line: %s", e.getCause()));
        }
    }
}
