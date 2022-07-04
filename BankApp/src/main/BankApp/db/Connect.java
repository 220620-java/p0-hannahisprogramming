package main.BankApp.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    static final String endpoint="jdbc:postgresql://awsdb.ch3f9makdbyg.us-east-1.rds.amazonaws.com:5432/postgres", username="postgres", password="awsdatabase";
    private static Connection connection;

    private Connection() { };
    public static synchronized Connection getConnection() {
        if (connection == null) {
            connection = new Connection();
        }
        return connection;
    }
    //connect to the database
    public static Connect connectToDb() {
        Connect connect = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(endpoint, username, password);
            connection.setAutoCommit(false);
            connect = (Connect) connection;
        } catch (Exception e){
            e.printStackTrace();
        }
        return connect;
    }
    //disconnect from the database
    public void disconnectDb() throws Exception {
        connection.close();
    }
}
