package hexlet.code;

import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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

            String type = "changed";
            if (!firstMap.containsKey(key)) {
                type = "added";
            } else if (!secondMap.containsKey(key)) {
                type = "deleted";
            } else {
                if (Objects.isNull(firstObject)) {
                    if (Objects.isNull(secondObject)) {
                        type = "unchanged";
                    }
                } else if (firstObject.equals(secondObject)) {
                    type = "unchanged";
                }
            }

            sortedResult.add(new CompositeValue(key, type, firstObject, secondObject));
        }

        return sortedResult;
    }
}
