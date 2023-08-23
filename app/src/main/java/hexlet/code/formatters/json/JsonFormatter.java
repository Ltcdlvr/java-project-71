package hexlet.code.formatters.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.CompositeValue;
import hexlet.code.formatters.FormatterInterface;

import java.util.List;

public final class JsonFormatter implements FormatterInterface {

    public String render(List<CompositeValue> diff) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(diff);
    }
}
