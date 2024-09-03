package com.hiq.robotSimulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Arrays;
import java.util.Objects;

public class RobotSimulator {
    private final Robot robot;
    public RobotSimulator() {
        this.robot = new Robot();
    }

    public void processInput(String filePathString) {
        String filePath;

        try {
            filePath = Objects.requireNonNull(RobotSimulator.class.getClassLoader().getResource(filePathString)).getPath();
        } catch (NullPointerException e) {
            System.err.printf("Input is null: %s", (Object) e.getStackTrace());
            return;
        }

        try {

            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String input;

            while ((input = br.readLine()) != null) {
                robot.postCommand(input);
            }

        } catch (FileNotFoundException e) {
            System.err.printf("Could not find file path %s: %s%n", filePath, Arrays.toString(e.getStackTrace()));
        } catch (IOException e) {
            System.err.printf("Could not read next line: %s%n", (Object) e.getStackTrace());
        }
    }

    public Robot getRobot() {
        return robot;
    }

}
