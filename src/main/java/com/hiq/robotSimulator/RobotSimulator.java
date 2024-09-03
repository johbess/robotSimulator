package com.hiq.robotSimulator;

import java.io.*;
import java.util.Objects;

public class RobotSimulator {
    public static void main(String[] args) {

        Robot robot = new Robot();

        String filePath = Objects.requireNonNull(RobotSimulator.class.getClassLoader().getResource("test3")).getPath();

        try {

            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String input;

            while ((input = br.readLine()) != null) {
                robot.postCommand(input);
            }

        } catch (FileNotFoundException e) {
            System.err.printf("Could not find file path %s: %s%n", filePath, e.getCause());
        } catch (IOException e) {
            System.err.printf("Could not read next line: %s%n", e.getCause());
        }
    }
}
