package gabrieljayme.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    protected static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        //Informação para a conexão
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://127.0.0.1:3306/enderecos";

        //Nome e dados da Database
        String dbUsername = "root";
        String dbPassword = "root";

        //Buscar o driver e realizar a conexão
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

        return con;
    }
}
