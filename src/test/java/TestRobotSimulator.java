import com.hiq.robotSimulator.Direction;
import com.hiq.robotSimulator.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestRobotSimulator {

    private Robot sut;
    @Before
    public void setup() {
        sut = new Robot();
    }

    @Test
    public void whenInputIsNull_RobotIgnoresCommand() {
        sut.postCommand(null);

        assertTrue(sut.getDirection() == null);
        assertTrue(sut.getX() == 0);
        assertTrue(sut.getY() == 0);
    }

    @Test
    public void whenInputIsBlankString_RobotIgnoresCommand() {
        sut.postCommand("             ");

        assertTrue(sut.getDirection() == null);
        assertTrue(sut.getX() == 0);
        assertTrue(sut.getY() == 0);
    }

    @Test
    public void whenInputIsInvalid_RobotIgnoresCommand() {
        sut.postCommand("invalid input");

        assertTrue(sut.getDirection() == null);
        assertTrue(sut.getX() == 0);
        assertTrue(sut.getY() == 0);
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

        assertTrue(sut.getDirection().equals(Direction.EAST));
        assertTrue(sut.getX() == 4);
        assertTrue(sut.getY() == 0);
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

        assertTrue(sut.getDirection().equals(Direction.WEST));
        assertTrue(sut.getX() == 0);
        assertTrue(sut.getY() == 0);

    }
}
