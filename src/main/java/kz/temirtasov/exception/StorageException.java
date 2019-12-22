package kz.temirtasov.exception;

public class StorageException extends RuntimeException {
    private final Integer id;

    public StorageException(String message, int id) {
        super(message);
        this.id = id;
    }

    public StorageException(String message, Exception e) {
        this(message, null, e);
    }

    public StorageException(String message, Integer id, Exception e) {
        super(message, e);
        this.id = id;
    }

    public StorageException(String message) {
        this(message, null, null);
    }

    public StorageException(Exception e) {
        this(e.getMessage(), e);
    }

    public Integer getId() {
        return id;
    }
}
