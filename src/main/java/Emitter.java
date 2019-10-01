import com.google.gson.Gson;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Emitter {
    private PrintWriter writer;
    private Gson gson = new Gson();
    private int nextId = 1;

    public Emitter(PrintWriter writer) {
        this.writer = writer;
    }

    private static Map<String, Object> union(Map<String, Object> h1, Map<String, Object> h2) {
        HashMap<String, Object> union = new HashMap<>(h1);
        union.putAll(h2);
        return union;
    }

    public int getNumElements() {
        return nextId;
    }

    public String emitVertex(String labelName, Map<String, Object> args) {
        return emit("vertex", labelName, args);
    }

    public String emitEdge(String labelName, Map<String, Object> args) {
        return emit("edge", labelName, args);
    }

    private String emit(String typeName, String labelName, Map<String, Object> args) {
        String id = String.format("%d", nextId++);

        writer.println(gson.toJson(union(args, Map.of(
                "id", id,
                "type", typeName,
                "label", labelName
        ))));

        return id;
    }
}
