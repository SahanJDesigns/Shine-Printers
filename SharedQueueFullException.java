public class SharedQueueFullException extends Exception {
    @Override
    public String getMessage() {
        return "Shared Queue is full";
    }
}
