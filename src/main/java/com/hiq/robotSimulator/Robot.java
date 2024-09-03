package com.hiq.robotSimulator;

public class Robot {
    private int x;
    private int y;
    private Direction direction;


    /**
     * Method to process a command given to the robot
     * If the length of argument is greater than 1,
     * it will either be a PLACE command or an invalid command
     * If the robot has not been placed previously
     * @param command the command fed to the robot
     */
    public void postCommand(String command) {

        if (command == null || command.isBlank()) {
            return;
        }

        if (command.contains("PLACE")) {
            processPlaceCommand(command);
        } else if (direction != null) {
            switch (command) {
                case "MOVE" -> move();
                case "LEFT", "RIGHT" -> turn(Turn.valueOf(command));
                case "REPORT" -> report();
            }
        }
    }

    private void processPlaceCommand(String command) {
        String[] commandArr = command.replace(",", " ").split(" ");

        if (commandArr.length != 4) {
            return;
        }

        if (commandArr[0].equals("PLACE")) {
            try {
                int xTmp = Integer.parseInt(commandArr[1]);
                int yTmp = Integer.parseInt(commandArr[2]);
                Direction directionTmp = Direction.valueOf(commandArr[3]);
                place(xTmp, yTmp, directionTmp);
            } catch (IllegalArgumentException e) {
                // Invalid input
            }
        }
    }

    /**
     * Place or move the robot on the board
     * If the input is not within the boundaries,
     * the input is ignored
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param direction the direction in which the robot will be walking towards when moving
     */
    private void place(int x, int y, Direction direction) {
        if (x >= 0 && x <= 4 &&
            y >= 0 && y <= 4) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    /**
     * Moves the robot one step
     * in the current direction
     */
    private void move() {
        switch (direction) {
            case EAST -> {
                if (x < 4) {
                    x = x + 1;
                }
            }

            case WEST -> {
                if (x > 0) {
                    x = x - 1;
                }
            }

            case NORTH -> {
                if (y < 4) {
                    y = y + 1;
                }
            }

            case SOUTH -> {
                if (y > 0) {
                    y = y - 1;
                }
            }
        }
    }

    private void turn(Turn turn) {

        if (turn.equals(Turn.LEFT)) {
            direction = switch (direction) {
                case SOUTH -> Direction.EAST;
                case NORTH -> Direction.WEST;
                case WEST -> Direction.SOUTH;
                case EAST -> Direction.NORTH;
            };
        } else {
            direction = switch (direction) {
                case SOUTH -> Direction.WEST;
                case NORTH -> Direction.EAST;
                case WEST -> Direction.NORTH;
                case EAST -> Direction.SOUTH;
            };
        }
    }

    private void report() {
        System.out.printf("%d,%d,%s%n", x,y,direction.name());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}
