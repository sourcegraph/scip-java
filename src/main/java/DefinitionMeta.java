import java.util.ArrayList;
import java.util.List;

public class DefinitionMeta {
    public String rangeId;
    public String resultSetId;
    public String definitionResultId;
    public List<String> referenceRangeIds = new ArrayList<>();

    public DefinitionMeta(String rangeId, String resultSetId) {
        this.rangeId = rangeId;
        this.resultSetId = resultSetId;
    }
}
