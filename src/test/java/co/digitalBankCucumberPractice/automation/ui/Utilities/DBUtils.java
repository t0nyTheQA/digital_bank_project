package co.digitalBankCucumberPractice.automation.ui.Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    private static Connection connection= null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    //method to establish connection with DB
    public static void establishConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
             connection = DriverManager.getConnection(
                     ConfigReader.getPropertiesValue("dBankDBurl"),
                     ConfigReader.getPropertiesValue("dBankDBusername"),
                     ConfigReader.getPropertiesValue("dBankDBpassword"));

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    //method that can dynamically send select statement
    //and return a list of mao of all columns
    public static List<Map<String, Object>> runSQLSelectQuery(String sqlQuery) {
        List<Map<String, Object>> dbResultList = new ArrayList<>();
        try {
            if (connection == null) {
                establishConnection();
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData(); //meta data gives methods to get info about database
            int columnCount = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                Map<String, Object> rowMap = new HashMap<>();

                for (int col = 1; col <= columnCount; col++) {
                    rowMap.put(resultSetMetaData.getColumnName(col), resultSet.getObject(col));
                }
                dbResultList.add(rowMap);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dbResultList;
    }


    //create method that inserts and update into db
    //and return nums of rows affected

    //delete ot truncate the table
    public static int runSQLUpdateQuery(String sqlQuery) {
        int rowsAffected = 0;
        try {
                statement = connection.createStatement();
                rowsAffected = statement.executeUpdate(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    //close connection, statement, result set
    public static void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
