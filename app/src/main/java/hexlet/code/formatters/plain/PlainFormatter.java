package hexlet.code.formatters.plain;

import hexlet.code.CompositeValue;
import hexlet.code.formatters.FormatterInterface;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public class PlainFormatter implements FormatterInterface {

    private static String getPlainValue(String obj) {
        if (Objects.isNull(obj)) {
            return "null";
        }

        if (obj.contains("[") || obj.contains("{")) {
            return "[complex value]";
        }

        try {
            Double.valueOf(obj);
            return obj;
        } catch (NumberFormatException ignored) {
        }

        List<String> tokens = List.of("true", "false", "null");
        if (tokens.contains(obj)) {
            return obj;
        }

        return "'" + obj + "'";
    }

    public String getString(Map<String, CompositeValue> diff) {
        StringJoiner result = new StringJoiner("\n");

        for (Map.Entry<String, CompositeValue> line: diff.entrySet()) {
            CompositeValue val = line.getValue();

            String oldValue = val.oldValue;
            String newValue = val.newValue;

            if (Objects.isNull(newValue)) {
                result.add("Property '" + line.getKey() + "' was removed");
            } else if (Objects.isNull(oldValue)) {
                result.add("Property '" + line.getKey() + "' was added with value: " + getPlainValue(newValue));
//            } else if (newValue.equals(oldValue)) {
//                result.add("Property '" + line.getKey() + "' was unchanged with value: " + getPlainValue(oldValue));
            } else if (!newValue.equals(oldValue)) {
                result.add("Property '" + line.getKey() + "' was updated. From "
                        + getPlainValue(oldValue) + " to " + getPlainValue(newValue));
            }
        }
        return result.toString();
    }
}
