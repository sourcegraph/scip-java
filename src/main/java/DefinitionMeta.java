import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DefinitionMeta {
    public String rangeId;
    public String resultSetId;
    public String definitionResultId;
    public Map<String, Set<String>> referenceRangeIds = new HashMap<>();

    public DefinitionMeta(String rangeId, String resultSetId) {
        this.rangeId = rangeId;
        this.resultSetId = resultSetId;
    }
}
