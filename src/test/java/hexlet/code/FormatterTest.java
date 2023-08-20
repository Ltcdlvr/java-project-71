package hexlet.code;

import hexlet.code.formatters.FormatterInterface;
import hexlet.code.formatters.json.JsonFormatter;
import hexlet.code.formatters.plain.PlainFormatter;
import hexlet.code.formatters.stylish.StylishFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatterTest {
    @Test
    @DisplayName("test Formatter")
    void testFormatter() {
        FormatterInterface format1 = Formatter.getFormatter("plain");
        FormatterInterface format2 = Formatter.getFormatter("json");
        FormatterInterface format3 = Formatter.getFormatter("stylish");


        assertEquals(format1.getClass(), PlainFormatter.class);
        assertEquals(format2.getClass(), JsonFormatter.class);
        assertEquals(format3.getClass(), StylishFormatter.class);
    }
}
