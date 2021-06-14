package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;

public class ConnectionSQL {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Haj?serverTimezone=UTC";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "Haj1234!";
    private static final String SELECT_QUERY = "SELECT * FROM Haj WHERE Brugernavn = cpr and Kodeord = kodeord";

    @FXML
    Main main = new Main();

    public boolean validate(String Brugernavn, String Kodeord) throws SQLException {


        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setString(1, Brugernavn);
            preparedStatement.setString(2, Kodeord);

            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }


        } catch (SQLException e) {
            printSQLException(e);
        }
        return false;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLHvad: " + ((SQLException) e).getSQLState());
                System.err.println("FEJL: " + ((SQLException) e).getErrorCode());
                System.err.println("Besked: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Problem: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

