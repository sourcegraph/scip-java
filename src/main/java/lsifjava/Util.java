package lsifjava;

import java.util.HashMap;
import java.util.Map;

public class Util {
    protected static Map<String, Object> union(Map<String, Object> h1, Map<String, Object> h2) {
        var union = new HashMap<String, Object>(h1);
        union.putAll(h2);
        return union;
    }

    protected static Map<String, Object> mapOf(Object... args) {
        var map = new HashMap<String, Object>();
        for (int i = 0; i < args.length - 1; i += 2) {
            map.put(args[i].toString(), args[i + 1]);
        }
        return map;
    }
}
