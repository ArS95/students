package kz.temirtasov.exception;

import java.sql.SQLException;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(int id) {
        super("Student " + id + " not exist", id);
    }

    public NotExistStorageException(SQLException e) {
        super(e);
    }

    public NotExistStorageException(String message, int id, Exception e) {
        super(message, id, e);
    }
}
