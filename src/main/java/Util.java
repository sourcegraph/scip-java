import java.util.HashMap;
import java.util.Map;

public class Util {
    protected static Map<String, Object> union(Map<String, Object> h1, Map<String, Object> h2) {
        HashMap<String, Object> union = new HashMap<>(h1);
        union.putAll(h2);
        return union;
    }
}
