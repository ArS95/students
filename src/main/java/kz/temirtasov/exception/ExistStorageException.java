package kz.temirtasov.exception;

import java.sql.SQLException;

public class ExistStorageException extends StorageException {
    public ExistStorageException(int id) {
        super("Student " + id + " already exist", id);
    }

    public ExistStorageException(SQLException e) {
        super(e);
    }

    public ExistStorageException(String message, int id, Exception e) {
        super(message, id, e);
    }
}
