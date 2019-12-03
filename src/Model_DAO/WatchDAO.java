package Model_DAO;

import Beans.Watch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Database.DBConnection.createConnection;



public class WatchDAO {

    Connection connection = null;

    private static final String INSERT_WATCH_SQL = "insert into watch (title, type, gender, price) values (?, ?, ?, ?);";
    private static final String SELECT_WATCH_BY_ID = "select id, title, type, gender, price from watch where id = ?";
    private static final String SELECT_ALL_WATCH = "select * from watch";
    private static final String DELETE_WATCH_SQL = "delete from watch where id = ?;";
    private static final String UPDATE_WATCH_SQL = "update watch set title = ?, type = ?, gender = ?, price = ? where id = ?;";

    public WatchDAO() {}

    public void insertWatch(Watch watch) throws SQLException {
        System.out.println(INSERT_WATCH_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WATCH_SQL)) {
            preparedStatement.setString(1, watch.getTitle());
            preparedStatement.setString(2, watch.getType());
            preparedStatement.setString(3, watch.getGender());
            preparedStatement.setInt(4, watch.getPrice());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Watch selectWatch(int id) {
        Watch watch = null;
        // Step 1: Establishing a Connection
        try (Connection connection = createConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WATCH_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String title = rs.getString("title");
                String type = rs.getString("type");
                String gender = rs.getString("gender");
                int price = rs.getInt("price");
                watch = new Watch(id, title, type, gender, price);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return watch;
    }

    public List < Watch > selectAllWatch() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List< Watch > watch = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = createConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WATCH);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String type = rs.getString("type");
                String gender = rs.getString("gender");
                int price = rs.getInt("price");
                watch.add(new Watch(id, title, type, gender, price));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return watch;
    }

    public boolean deleteWatch(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_WATCH_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateWatch(Watch watch) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_WATCH_SQL);) {
            statement.setString(1, watch.getTitle());
            statement.setString(2, watch.getType());
            statement.setString(3, watch.getGender());
            statement.setInt(4, watch.getPrice());
            statement.setInt(5, watch.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
