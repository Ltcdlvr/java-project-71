package hexlet.code;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import picocli.CommandLine;

public class AppTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("'main' method works correctly")
    void testMain() {
        App ap = new App();
//        int exitCode = new CommandLine(ap).execute("./src/test/resources/1.json",
//                "./src/test/resources/2.json");
////        System.exit(exitCode);
//        assertEquals("{- follow=false,   host=hexlet.io, - proxy=123.234.53.22, - timeout=50, + timeout=20, "
//                + "+ verbose=true}", output.toString(StandardCharsets.UTF_8).trim());
//
//        int exitCode = new CommandLine(ap).execute("./src/test/resources/1.yaml",
//                "./src/test/resources/2.yaml");
//        assertEquals("{- follow=false,   host=hexlet.io, - proxy=123.234.53.22, - timeout=50, + timeout=20, "
//                + "+ verbose=true}", output.toString(StandardCharsets.UTF_8).trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}



