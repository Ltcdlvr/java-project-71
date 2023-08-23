package hexlet.code.formatters.plain;

import hexlet.code.CompositeValue;
import hexlet.code.formatters.FormatterInterface;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public final class PlainFormatter implements FormatterInterface {

    private static String getPlainValue(Object obj) {

        if (Objects.isNull(obj)) {
            return "null";
        }

        if (obj instanceof String) {
            return "'" + obj + "'";
        }

        if (obj instanceof Map || obj instanceof List) {
            return "[complex value]";
        }

        return obj.toString();
    }

    public String render(List<CompositeValue> diff) {
        StringJoiner result = new StringJoiner("\n");

        for (CompositeValue line: diff) {
            String format = line.getType();
            Object oldValue = line.getOldValue();
            Object newValue = line.getNewValue();

            switch (format) {
                case "added" ->
                        result.add("Property '" + line.getKey() + "' was added with value: " + getPlainValue(newValue));
                case "deleted" ->
                        result.add("Property '" + line.getKey() + "' was removed");
                case "changed" ->
                        result.add("Property '" + line.getKey() + "' was updated. From "
                                + getPlainValue(oldValue) + " to " + getPlainValue(newValue));
                default -> {
                }
            }
        }
        return result.toString();
    }
}
