package hexlet.code;

import java.util.TreeSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class DifSearcher {
    public static List<CompositeValue> findDiff(Map<String, Object> firstMap, Map<String, Object> secondMap) {

        Set<String> keys = new TreeSet<>(firstMap.keySet());
        keys.addAll(secondMap.keySet());

        List<CompositeValue> sortedResult = new ArrayList<>();

        for (String key: keys) {
            Object firstObject = firstMap.get(key);
            Object secondObject = secondMap.get(key);

            if (Objects.isNull(firstObject)) {
                sortedResult.add(new CompositeValue(key, "added", null, secondObject));
            } else if (Objects.isNull(secondObject)) {
                sortedResult.add(new CompositeValue(key, "deleted", firstObject, null));
            } else if (firstObject.equals(secondObject)) {
                sortedResult.add(new CompositeValue(key, "unchanged", firstObject, secondObject));
            } else {
                sortedResult.add(new CompositeValue(key, "changed", firstObject, secondObject));
            }
        }

        return sortedResult;
    }
}
