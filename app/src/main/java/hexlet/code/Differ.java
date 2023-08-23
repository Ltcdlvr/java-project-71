package hexlet.code;

import hexlet.code.formatters.FormatterInterface;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String firstURI, String secondURI) throws Exception {
        return generate(firstURI, secondURI, "stylish");
    }
    public static String generate(String firstURI, String secondURI, String formatName) throws Exception {
        FormatterInterface formatter = Formatter.getFormatter(formatName);
        Map<String, Object> firstObject = Parser.parseFile(firstURI);
        Map<String, Object> secondObject = Parser.parseFile(secondURI);
        List<CompositeValue> actualDiff = DifSearcher.findDiff(firstObject, secondObject);
        return formatter.render(actualDiff);
    }
}
