package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> fields = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (field.getAnnotation(NotNull.class) != null && field.get(address) == null) {
                    fields.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return fields;
    }
}
// END
