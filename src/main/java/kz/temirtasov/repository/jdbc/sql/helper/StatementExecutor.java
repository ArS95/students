package kz.temirtasov.repository.jdbc.sql.helper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface StatementExecutor<T> {
    T execute(PreparedStatement statement) throws SQLException;
}