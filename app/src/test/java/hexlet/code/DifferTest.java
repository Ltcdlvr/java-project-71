package hexlet.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    @Test
    @DisplayName("test Differ - json - stylish")
    void testDifferJsonStylish() throws Exception {
        String diff = Differ.generate("./src/test/resources/1.json",
                "./src/test/resources/2.json", "stylish");
        String expected = FileReader.getContent("./src/test/resources/expected/stylish.txt");
        assertEquals(diff, expected);
    }

    @Test
    @DisplayName("test Differ - json - default")
    void testDifferJsonDefault() throws Exception {
        String diff = Differ.generate("./src/test/resources/1.json",
                "./src/test/resources/2.json");
        String expected = FileReader.getContent("./src/test/resources/expected/stylish.txt");
        assertEquals(diff, expected);
    }

    @Test
    @DisplayName("test Differ - json - plain")
    void testDifferJsonPlain() throws Exception {
        String diff = Differ.generate("./src/test/resources/1.json",
                "./src/test/resources/2.json", "plain");
        String expected = FileReader.getContent("./src/test/resources/expected/plain.txt");
        assertEquals(diff, expected);
    }

    @Test
    @DisplayName("test Differ - json - json")
    void testDifferJsonFormat() throws Exception {
        String diff = Differ.generate("./src/test/resources/1.json",
                "./src/test/resources/2.json", "json");
        String expected = FileReader.getContent("./src/test/resources/expected/json.txt");
        assertEquals(diff, expected);
    }

    @Test
    @DisplayName("test Differ - yaml - stylish")
    void testDifferYamlStylish() throws Exception {
        String diff = Differ.generate("./src/test/resources/1.yaml",
                "./src/test/resources/2.yaml", "stylish");
        String expected = FileReader.getContent("./src/test/resources/expected/stylish.txt");
        assertEquals(diff, expected);
    }

    @Test
    @DisplayName("test Differ - yaml - default")
    void testDifferYamlDefault() throws Exception {
        String diff = Differ.generate("./src/test/resources/1.yaml",
                "./src/test/resources/2.yaml");
        String expected = FileReader.getContent("./src/test/resources/expected/stylish.txt");
        assertEquals(diff, expected);
    }

    @Test
    @DisplayName("test Differ - yaml - plain")
    void testDifferYamlPlain() throws Exception {
        String diff = Differ.generate("./src/test/resources/1.yaml",
                "./src/test/resources/2.yaml", "plain");
        String expected = FileReader.getContent("./src/test/resources/expected/plain.txt");
        assertEquals(diff, expected);
    }

    @Test
    @DisplayName("test Differ - yaml - json")
    void testDifferYamlFormat() throws Exception {
        String diff = Differ.generate("./src/test/resources/1.yaml",
                "./src/test/resources/2.yaml", "json");
        String expected = FileReader.getContent("./src/test/resources/expected/json.txt");
        assertEquals(diff, expected);
    }
}
