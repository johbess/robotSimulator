import com.hiq.robotSimulator.Direction;
import com.hiq.robotSimulator.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRobot {

    private Robot sut;
    @Before
    public void setup() {
        sut = new Robot();
    }

    @Test
    public void whenInputIsNull_RobotIgnoresCommand() {
        sut.postCommand(null);

        assertNull(sut.getDirection());
        assertEquals(0, sut.getX());
        assertEquals(0, sut.getY());
    }

    @Test
    public void whenInputIsBlankString_RobotIgnoresCommand() {
        sut.postCommand("             ");

        assertNull(sut.getDirection());
        assertEquals(0, sut.getX());
        assertEquals(0, sut.getY());
    }

    @Test
    public void whenInputIsInvalid_RobotIgnoresCommand() {
        sut.postCommand("invalid input");

        assertNull(sut.getDirection());
        assertEquals(0, sut.getX());
        assertEquals(0, sut.getY());
    }

    @Test
    public void whenInputWillWalkRobotOutOfBounds_RobotStaysAtBoundary() {
        sut.postCommand("PLACE 0,0,EAST");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");

        assertEquals(sut.getDirection(), Direction.EAST);
        assertEquals(4, sut.getX());
        assertEquals(0, sut.getY());
    }

    @Test
    public void whenInputWillWalkRobotAnEntireLap_RobotEndsUpAtStart() {
        sut.postCommand("PLACE 0,0,NORTH");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");

        sut.postCommand("RIGHT");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");

        sut.postCommand("RIGHT");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");

        sut.postCommand("RIGHT");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");
        sut.postCommand("MOVE");

        assertEquals(sut.getDirection(), Direction.WEST);
        assertEquals(0, sut.getX());
        assertEquals(0, sut.getY());

    }
}
