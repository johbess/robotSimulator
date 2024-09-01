import com.hiq.robotSimulator.Robot;
import org.junit.Before;
import org.junit.Test;

public class TestRobotSimulator {

    private Robot sut;
    @Before
    public void setup() {
        sut = new Robot();
    }

    @Test
    public void whenIllegalInputIsGivenRobot_RobotIgnoresCommand() {

    }
}
