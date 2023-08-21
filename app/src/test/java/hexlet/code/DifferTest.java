package hexlet.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

public class DifferTest {
    @Test
    @DisplayName("test Differ Json")
    void testDifferJson() throws Exception {

        Map<String, Object> firstObject = Parser.parseFile("./src/test/resources/1.json");
        Map<String, Object> secondObject = Parser.parseFile("./src/test/resources/2.json");
        Map<String, CompositeValue> diff = Differ.findDiff(firstObject, secondObject);

        Map<String, CompositeValue> expected = new HashMap<>(
                Map.of("follow", new CompositeValue("false", null),
                "host", new CompositeValue("hexlet.io", "hexlet.io"),
                "proxy", new CompositeValue("123.234.53.22", null),
                "timeout", new CompositeValue("50", "20"),
                "verbose", new CompositeValue(null, "true")));
        assertTrue(diff.equals(expected));
    }

    @Test
    @DisplayName("test Differ Yaml")
    void testDifferYaml() throws Exception {

        Map<String, Object> firstObject = Parser.parseFile("./src/test/resources/1.yaml");
        Map<String, Object> secondObject = Parser.parseFile("./src/test/resources/2.yaml");
        Map<String, CompositeValue> diff = Differ.findDiff(firstObject, secondObject);

        Map<String, CompositeValue> expected = new HashMap<>(
                Map.of("follow", new CompositeValue("false", null),
                "host", new CompositeValue("hexlet.io", "hexlet.io"),
                "proxy", new CompositeValue("123.234.53.22", null),
                "timeout", new CompositeValue("50", "20"),
                "verbose", new CompositeValue(null, "true")));
        assertTrue(diff.equals(expected));
    }

    @Test
    @DisplayName("test Differ Stylish")
    void testDifferStylish() throws Exception {

        String diff = Differ.generate("./src/test/resources/1.json",
                "./src/test/resources/2.json", "stylish");

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        assertTrue(diff.equals(expected));
    }

    @Test
    @DisplayName("test Differ Plain")
    void testDifferPlain() throws Exception {

        String diff = Differ.generate("./src/test/resources/1.json",
                "./src/test/resources/2.json", "plain");

        String expected = "Property 'follow' was removed\n"
                + "Property 'host' was unchanged with value: 'hexlet.io'\n"
                + "Property 'proxy' was removed\n"
                + "Property 'timeout' was updated. From '50' to '20'\n"
                + "Property 'verbose' was added with value: 'true'";

        assertTrue(diff.equals(expected));
    }

    @Test
    @DisplayName("test Differ Json format")
    void testDifferJsonFormat() throws Exception {

        String diff = Differ.generate("./src/test/resources/1.json",
                "./src/test/resources/2.json", "json");

        String expected = "{\"follow\":{\"oldValue\":\"false\",\"newValue\":null},\"host\":{\"oldValue\":"
                + "\"hexlet.io\",\"newValue\":\"hexlet.io\"},\"proxy\":{\"oldValue\":\"123.234.53.22\","
                + "\"newValue\":null},\"timeout\":{\"oldValue\":\"50\",\"newValue\":\"20\"},\"verbose\""
                + ":{\"oldValue\":null,\"newValue\":\"true\"}}";

        assertTrue(diff.equals(expected));
    }
}

