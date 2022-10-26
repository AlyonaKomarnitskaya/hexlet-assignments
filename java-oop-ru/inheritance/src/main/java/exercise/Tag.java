package exercise;

import java.util.Map;

// BEGIN
public class Tag {
     String name;
     Map<String, String> attributes;



    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<" + name);

        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            stringBuilder.append(" " + entry.getKey() + "=\"" + entry.getValue() + "\"");
        }
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}
// END
