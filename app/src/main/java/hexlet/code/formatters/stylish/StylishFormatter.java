package hexlet.code.formatters.stylish;

import hexlet.code.CompositeValue;
import hexlet.code.formatters.FormatterInterface;

import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public class StylishFormatter implements FormatterInterface {
    public String getString(Map<String, CompositeValue> diff) {
        StringJoiner result = new StringJoiner("\n");
        result.add("{");

        for (Map.Entry<String, CompositeValue> line: diff.entrySet()) {
            CompositeValue val = line.getValue();

            String oldValue = val.oldValue;
            String newValue = val.newValue;

            if (Objects.isNull(newValue)) {
                result.add("  - " + line.getKey() + ": " + oldValue);
            } else if (Objects.isNull(oldValue)) {
                result.add("  + " + line.getKey() + ": " + newValue);
            } else if (newValue.equals(oldValue)) {
                result.add("    " + line.getKey() + ": " + oldValue);
            } else {
                result.add("  - " + line.getKey() + ": " + oldValue);
                result.add("  + " + line.getKey() + ": " + newValue);
            }
        }
        result.add("}");
        return result.toString();
    }
}
