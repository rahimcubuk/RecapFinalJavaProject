package Core.Helpers;

import java.sql.*;

public interface DbHelper {
    Connection getConnection() throws SQLException ;

    void showDbErrorMessage(SQLException exception);

    ResultSet getData(Connection connection, String sorgu) throws SQLException ;
}
