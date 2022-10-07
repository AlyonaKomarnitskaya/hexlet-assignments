package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.TreeSet;

// BEGIN
public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> m1, Map<String, Object> m2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(m1.keySet());
        keys.addAll(m2.keySet());
        return keys.stream()
                .collect(Collectors.toMap(key -> key, value -> {
                    if (!m1.containsKey(value) && m2.containsKey(value)) {
                        return "added";
                    }
                    if (m1.containsKey(value) && !m2.containsKey(value)) {
                        return "deleted";
                    }
                    if (m1.containsKey(value) && m2.containsKey(value) && !m1.containsValue(m2.get(value))) {
                        return "changed";
                    } else {
                        return "unchanged";
                    }
                }, (v1, v2) -> v1, LinkedHashMap::new));
    }
}
//END
