package hexlet.code;


import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import  java.util.Comparator;
//import com.fasterxml.jackson.databind.ObjectMapper;


//import com.google.gson.*;

public class Differ {

    public static String generate(Map<String, Object> firstMap, Map<String, Object> secondMap)
            throws JsonProcessingException {
        Set<String> firstKeys = new HashSet<>(firstMap.keySet());
        Set<String> secondKeys = new HashSet<>(secondMap.keySet());

        Set<String> intersectionKeys = new HashSet<>(firstKeys);
        intersectionKeys.retainAll(secondKeys);

        class CompositeKey {
            public final String symbol;
            public final String key;
            CompositeKey(String key, String symbol) {
                this.key = key;
                this.symbol = symbol;
            }

            @Override
            public String toString() {
                return symbol + " " + key;
            }
        }

        // result
        SortedMap<CompositeKey, String> sortedResult = new TreeMap<>(new Comparator<CompositeKey>() {
            @Override
            public int compare(CompositeKey o1, CompositeKey o2) {
                if (o1.key.equals(o2.key)) {
                    return -o1.symbol.compareTo(o2.symbol);
                }
                return o1.key.compareTo(o2.key);
            }
        });

        // deleted keys
        firstKeys.removeAll(intersectionKeys);
        for (String deletedKey: firstKeys) {
            sortedResult.put(new CompositeKey(deletedKey, "-"), firstMap.get(deletedKey).toString());
        }

        // added keys
        secondKeys.removeAll(intersectionKeys);
        for (String addedKey: secondKeys) {
            sortedResult.put(new CompositeKey(addedKey, "+"), secondMap.get(addedKey).toString());
        }

        for (String key: intersectionKeys) {
            Object firstObj = firstMap.get(key);
            Object secondObj = secondMap.get(key);

            if (firstObj.equals(secondObj)) {
//                sortedResult.put(key, "unchanged");
                sortedResult.put(new CompositeKey(key, " "), secondMap.get(key).toString());
            } else {
//                sortedResult.put(key, "changed");
                sortedResult.put(new CompositeKey(key, "-"), firstMap.get(key).toString());
                sortedResult.put(new CompositeKey(key, "+"), secondMap.get(key).toString());
            }
        }

//        System.out.println(sortedResult);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String strRes = objectMapper.writeValueAsString(sortedResult);
//        System.out.println(strRes);
//
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        JsonElement je = JsonParser.parseString(sortedResult.toString());
//        String prettyJsonString = gson.toJson(je);
//
//        System.out.println(prettyJsonString);

        return sortedResult.toString();
    }


}
