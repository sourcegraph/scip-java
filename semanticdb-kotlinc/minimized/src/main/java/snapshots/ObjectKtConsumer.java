package snapshots;

public class ObjectKtConsumer {
    public static void run() {
        ObjectKt.INSTANCE.fail("boom");
    }
}
