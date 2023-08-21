package hexlet.code;

import hexlet.code.formatters.FormatterInterface;
import hexlet.code.formatters.json.JsonFormatter;
import hexlet.code.formatters.plain.PlainFormatter;
import hexlet.code.formatters.stylish.StylishFormatter;

public class Formatter {
    public static FormatterInterface getFormatter(String formatName) {

        return switch (formatName) {
            case "plain" -> new PlainFormatter();
            case "json" -> new JsonFormatter();
            default -> new StylishFormatter();
        };
    }
}
