package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Persistence {
    private static Persistence persistence;
    private Connection connection;

    private Persistence() throws SQLException {
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/B_Uebung", "B_Uebung", "B_Uebung");
    }

    public static Persistence getInstance() throws SQLException {
        if(persistence == null)
            persistence = new Persistence();
        return persistence;
    }

    public ResultSet getResult() {
        //change
        return null;
    }
}
