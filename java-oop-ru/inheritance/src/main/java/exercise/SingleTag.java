package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {


    public SingleTag(String name, Map<String, String> map) {
        this.name = name;
        this.attributes = map;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
// END
