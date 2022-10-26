package exercise;

import java.util.Map;
import java.util.List;


// BEGIN
public class PairedTag extends Tag {

    String body;
    List<Tag> child;

    public PairedTag(String name, Map<String, String> map, String body, List<Tag> child) {
        this.name = name;
        this.attributes = map;
        this.body = body;
        this.child = child;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<" + name);
        for (Map.Entry<String, String> element : attributes.entrySet()) {
            stringBuilder.append(" " + element.getKey() + "=");
            stringBuilder.append("\"" + element.getValue() + "\"");
        }
        stringBuilder.append(">");
        for (Tag element : child) {
            stringBuilder.append(element.toString());
        }
        stringBuilder.append(body);
        stringBuilder.append("</" + name + ">");
        return stringBuilder.toString();
    }
}
// END
