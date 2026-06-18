package test;
import org.immutables.value.Value;
import java.util.Optional;
@Value.Immutable
public abstract class ExampleClass {
    public abstract Optional<String> getWorkflowIdReusePolicy();
}
