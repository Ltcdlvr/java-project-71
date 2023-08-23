package hexlet.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class DifferTest {
    @Test
    @DisplayName("test Differ Json")
    void testDifferJson() throws Exception {

        Map<String, Object> firstObject = Parser.parseFile("./src/test/resources/1.json");
        Map<String, Object> secondObject = Parser.parseFile("./src/test/resources/2.json");
        List<CompositeValue> diff = DifSearcher.findDiff(firstObject, secondObject);

        List<CompositeValue> expected = new LinkedList<>(
                List.of(
                        new CompositeValue("follow", "sometype", false, null),
                        new CompositeValue("host", "sometype", "hexlet.io", "hexlet.io"),
                        new CompositeValue("proxy", "sometype", "123.234.53.22", null),
                        new CompositeValue("timeout", "sometype", "50", "20"),
                        new CompositeValue("verbose", "sometype", null, true)
                )
        );

//        for (CompositeValue val: diff) {
//            Object oV = Objects.isNull(val.getOldValue()) ? "null" : val.getOldValue();
//            Object nV = Objects.isNull(val.getNewValue()) ? "null" : val.getNewValue();
//            System.out.println( oV.getClass() + " - " + nV.getClass());
//        }
//
//        for (CompositeValue val: expected) {
//            Object oV = Objects.isNull(val.getOldValue()) ? "null" : val.getOldValue();
//            Object nV = Objects.isNull(val.getNewValue()) ? "null" : val.getNewValue();
//            System.out.println( oV.getClass() + " - " + nV.getClass());
//        }

        assertEquals(diff, expected);
    }

    @Test
    @DisplayName("test Differ Yaml")
    void testDifferYaml() throws Exception {

        Map<String, Object> firstObject = Parser.parseFile("./src/test/resources/1.yaml");
        Map<String, Object> secondObject = Parser.parseFile("./src/test/resources/2.yaml");
        List<CompositeValue> diff = DifSearcher.findDiff(firstObject, secondObject);

        List<CompositeValue> expected = new LinkedList<>(
                List.of(
                        new CompositeValue("follow", "sometype", false, null),
                        new CompositeValue("host", "sometype", "hexlet.io", "hexlet.io"),
                        new CompositeValue("proxy", "sometype", "123.234.53.22", null),
                        new CompositeValue("timeout", "sometype", "50", "20"),
                        new CompositeValue("verbose", "sometype", null, true)
                )
        );
        assertEquals(diff, expected);
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
                + "Property 'proxy' was removed\n"
                + "Property 'timeout' was updated. From '50' to '20'\n"
                + "Property 'verbose' was added with value: true";

        assertTrue(diff.equals(expected));
    }

    @Test
    @DisplayName("test Differ Json format")
    void testDifferJsonFormat() throws Exception {

        String diff = Differ.generate("./src/test/resources/1.json",
                "./src/test/resources/2.json", "json");

        System.out.println(diff);
        String expected = "[{\"key\":\"follow\",\"type\":\"deleted\",\"oldValue\":false,\"newValue\":null},"
                + "{\"key\":\"host\",\"type\":\"unchanged\",\"oldValue\":\"hexlet.io\",\"newValue\":\"hexlet.io\"},"
                + "{\"key\":\"proxy\",\"type\":\"deleted\",\"oldValue\":\"123.234.53.22\",\"newValue\":null},"
                + "{\"key\":\"timeout\",\"type\":\"changed\",\"oldValue\":\"50\",\"newValue\":\"20\"},"
                + "{\"key\":\"verbose\",\"type\":\"added\",\"oldValue\":null,\"newValue\":true}]";

        assertTrue(diff.equals(expected));
    }
}

