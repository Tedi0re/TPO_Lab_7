import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testMainWithValidExpression() throws Exception {
        String input = "2 + 2" + System.lineSeparator() + "exit" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});

        assertEquals("Enter expression:" + System.lineSeparator() + "Result:4.0" + System.lineSeparator() + "Enter expression:" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testMainWithInvalidExpression() throws Exception {
        String input = "invalid expression" + System.lineSeparator() + "exit" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});

        assertEquals("Enter expression:" + System.lineSeparator() + "Not a valid expression" + System.lineSeparator() + "Enter expression:" + System.lineSeparator(), outContent.toString());
    }
}
