package Core.Helpers;

import java.sql.*;

public class MySqlHelper implements DbHelper {
    private String userName;
    private String password;
    private String dbUrl;

    public MySqlHelper(){
        userName    = "root";
        password    = "1324";
        dbUrl       = "jdbc:mysql://localhost:3306/world";
    }

    public MySqlHelper(String username, String password, String serverName, String dbName){
        this.userName   = username;
        this.password   = password;
        this.dbUrl      = "jdbc:mysql://" + serverName + "/" + dbName;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.dbUrl, this.userName, this.password);
    }

    public void showDbErrorMessage(SQLException exception){
        System.out.println("Hata: " + exception.getMessage());
        System.out.println("Kodu: "+ exception.getErrorCode());
    }

    public ResultSet getData(Connection connection, String sorgu) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sorgu);
        return resultSet;
    }
}
