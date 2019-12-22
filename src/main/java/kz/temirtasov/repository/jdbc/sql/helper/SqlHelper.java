package kz.temirtasov.repository.jdbc.sql.helper;


import kz.temirtasov.exception.StorageException;
import kz.temirtasov.repository.jdbc.sql.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlHelper {
    private final ConnectionFactory factory;

    public SqlHelper(String dbUrl, String dbUser, String dbPassword) {
        factory = () -> DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    public <T> T execute(StatementExecutor<T> statement, String sql) {
        try (Connection connection = factory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            return statement.execute(preparedStatement);
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }
}
