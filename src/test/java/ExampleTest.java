import org.frc1793.robot.commands.ExampleCommand;
import org.junit.Before;
import org.junit.Test;
import org.strongback.command.CommandTester;

/**
 * Created by tyler on 4/11/17.
 */
public class ExampleTest {

    private String word;
    private CommandTester tester;

    @Before
    public void beforeEach() {
        word = "Hello, World!";
    }

    @Test
    public void testExampleCommand() {
        tester = new CommandTester(new ExampleCommand(word));
        tester.step(1000);
    }
}
