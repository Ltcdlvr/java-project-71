package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.CompositeValue;

import java.util.Map;

@FunctionalInterface
public interface FormatterInterface {
    String getString(Map<String, CompositeValue> diff) throws JsonProcessingException;
}
