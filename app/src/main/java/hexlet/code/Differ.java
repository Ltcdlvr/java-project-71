package hexlet.code;

import hexlet.code.formatters.FormatterInterface;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;


public class Differ {

    public static String generate(String firstURI, String secondURI) throws Exception {
        FormatterInterface formatter = Formatter.getFormatter("stylish");
        Map<String, Object> firstObject = Parser.parseFile(firstURI);
        Map<String, Object> secondObject = Parser.parseFile(secondURI);
        Map<String, CompositeValue> actualDiff = Differ.findDiff(firstObject, secondObject);
        return formatter.getString(actualDiff);
    }
    public static String generate(String firstURI, String secondURI, String formatName) throws Exception {
        FormatterInterface formatter = Formatter.getFormatter(formatName);
        Map<String, Object> firstObject = Parser.parseFile(firstURI);
        Map<String, Object> secondObject = Parser.parseFile(secondURI);
        Map<String, CompositeValue> actualDiff = Differ.findDiff(firstObject, secondObject);
        return formatter.getString(actualDiff);
    }

    public static Map<String, CompositeValue> findDiff(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        Set<String> firstKeys = new HashSet<>(firstMap.keySet());
        Set<String> secondKeys = new HashSet<>(secondMap.keySet());

        Set<String> intersectionKeys = new HashSet<>(firstKeys);
        intersectionKeys.retainAll(secondKeys);

        // result
        SortedMap<String, CompositeValue> sortedResult = new TreeMap<>();

        // deleted keys
        firstKeys.removeAll(intersectionKeys);
        for (String deletedKey: firstKeys) {
            sortedResult.put(deletedKey, new CompositeValue(String.valueOf(firstMap.get(deletedKey)), null));
        }

        // added keys
        secondKeys.removeAll(intersectionKeys);
        for (String addedKey: secondKeys) {
            sortedResult.put(addedKey, new CompositeValue(null, String.valueOf(secondMap.get(addedKey))));
        }

        // keys in intersection
        for (String key: intersectionKeys) {
            sortedResult.put(key, new CompositeValue(String.valueOf(firstMap.get(key)),
                    String.valueOf(secondMap.get(key))));
        }
        return sortedResult;
    }
}
