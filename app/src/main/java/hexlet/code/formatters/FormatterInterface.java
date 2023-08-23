package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.CompositeValue;

import java.util.List;

public interface FormatterInterface {
    String render(List<CompositeValue> diff) throws JsonProcessingException;
}
