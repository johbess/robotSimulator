import com.hiq.robotSimulator.Direction;
import com.hiq.robotSimulator.Robot;
import com.hiq.robotSimulator.RobotSimulator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRobotSimulator {

    private RobotSimulator sut;
    @Before
    public void setup() {
        sut = new RobotSimulator();
    }

    @Test
    public void whenFileInputIsNull_RobotHasNotBeenPlacedOrMoved() {
        sut.processInput(null);

        Robot robot = sut.getRobot();

        assertNull(robot.getDirection());
        assertEquals(0, robot.getX());
        assertEquals(0, robot.getY());
    }

    @Test
    public void whenFileDoesNotExist_RobotHasNotBeenPlacedOrMoved() {
        sut.processInput("file that does not exist");
        Robot robot = sut.getRobot();

        assertNull(robot.getDirection());
        assertEquals(0, robot.getX());
        assertEquals(0, robot.getY());
    }

    @Test
    public void testCase1() {
        sut.processInput("test1");

        Robot robot = sut.getRobot();

        assertEquals(robot.getDirection(), Direction.NORTH);
        assertEquals(0, robot.getX());
        assertEquals(1, robot.getY());
    }

    @Test
    public void testCase2() {
        sut.processInput("test2");

        Robot robot = sut.getRobot();

        assertEquals(robot.getDirection(), Direction.WEST);
        assertEquals(0, robot.getX());
        assertEquals(0, robot.getY());
    }

    @Test
    public void testCase3() {
        sut.processInput("test3");

        Robot robot = sut.getRobot();

        assertEquals(robot.getDirection(), Direction.NORTH);
        assertEquals(3, robot.getX());
        assertEquals(3, robot.getY());
    }

}
