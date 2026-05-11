package snapshots;

public class CompanionConsumer {
    CompanionConsumer() {
        CompanionOwner.Companion.create();
        new CompanionOwner().create();
    }
}
