package hexlet.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {
    @Test
    @DisplayName("test JSON parsing")
    void testJsonParsing() {
        try {
            Map<String, Object> parsedJson = Parser.parseFile("./src/test/resources/1.json");
            Map<String, Object> expected = Map.of("host", "hexlet.io", "timeout", 50,
                    "proxy", "123.234.53.22", "follow", false);
            assertTrue(parsedJson.equals(expected));
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    @Test
    @DisplayName("test YAML parsing")
    void testYmlParsing() {
        try {
            Map<String, Object> parsedJson = Parser.parseFile("./src/test/resources/1.yaml");
            Map<String, Object> expected = Map.of("host", "hexlet.io", "timeout", 50,
                    "proxy", "123.234.53.22", "follow", false);
            assertTrue(parsedJson.equals(expected));
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}



