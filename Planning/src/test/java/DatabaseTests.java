import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class DatabaseTests {

    @Test
    void showThatTheConnectionToPostgresIsNotNull() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/cursistdb";
        String username = "cursist";
        String password = "PaSSw0rd";
        Connection connection = DriverManager.getConnection(url, username,
                password);
        assertThat(connection).isNotNull();
    }


}
