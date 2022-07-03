package main.BankApp.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    static final String endpoint="jdbc:postgresql://awsdb.ch3f9makdbyg.us-east-1.rds.amazonaws.com:5432/postgres", username="postgres", password="awsdatabase";
    Connection connection = null;
    //connect to the database
    public void connectToDb() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(endpoint, username, password);
            connection.setAutoCommit(false);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //disconnect from the database
    public void disconnectDb() throws Exception {
        connection.close();
    }
}
