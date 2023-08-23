package hexlet.code.formatters.stylish;

import hexlet.code.CompositeValue;
import hexlet.code.formatters.FormatterInterface;

import java.util.List;
import java.util.StringJoiner;

public final class StylishFormatter implements FormatterInterface {
    public String render(List<CompositeValue> diff) {
        StringJoiner result = new StringJoiner("\n");
        result.add("{");

        for (CompositeValue line: diff) {
            String format = line.getType();
            Object oldValue = line.getOldValue();
            Object newValue = line.getNewValue();

            switch (format) {
                case "added" -> result.add("  + " + line.getKey() + ": " + newValue);
                case "deleted" -> result.add("  - " + line.getKey() + ": " + oldValue);
                case "unchanged" -> result.add("    " + line.getKey() + ": " + oldValue);
                case "changed" -> {
                    result.add("  - " + line.getKey() + ": " + oldValue);
                    result.add("  + " + line.getKey() + ": " + newValue);
                }
                default -> {
                }
            }
        }
        result.add("}");
        return result.toString();
    }
}
