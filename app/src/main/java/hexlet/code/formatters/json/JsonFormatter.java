package hexlet.code.formatters.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.CompositeValue;
import hexlet.code.formatters.FormatterInterface;

import java.util.Map;

public class JsonFormatter implements FormatterInterface {

    public String getString(Map<String, CompositeValue> diff) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(diff);
    }
}
