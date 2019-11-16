package Model_DAO;

import Beans.Watches;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static mySQL_util.DBConnection.createConnection;

public class WatchesDAO {

    Connection connection = null;

    private static final String INSERT_WATCHES_SQL = "insert into watches (title, type, gender, price) values (?, ?, ?, ?);";

    private static final String SELECT_WATCHES_BY_ID = "select id, title, type, gender, price from watches where id = ?";
    private static final String SELECT_ALL_WATCHES = "select * from watches";
    private static final String DELETE_WATCHES_SQL = "delete from watches where id = ?;";
    private static final String UPDATE_WATCHES_SQL = "update watches set title = ?, type = ?, gender = ?, price = ? where id = ?;";

    public WatchesDAO() {}

    public void insertWatches(Watches watches) throws SQLException {
        System.out.println(INSERT_WATCHES_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WATCHES_SQL)) {
            preparedStatement.setString(1, watches.getTitle());
            preparedStatement.setString(2, watches.getType());
            preparedStatement.setString(3, watches.getGender());
            preparedStatement.setInt(4, watches.getPrice());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Watches selectWatches(int id) {
        Watches watches = null;
        // Step 1: Establishing a Connection
        try (Connection connection = createConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WATCHES_BY_ID);) {
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
                watches = new Watches(id, title, type, gender, price);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return watches;
    }

    public List < Watches > selectAllWatches() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List< Watches > watches = new ArrayList< >();
        // Step 1: Establishing a Connection
        try (Connection connection = createConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WATCHES);) {
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
                watches.add(new Watches(id, title, type, gender, price));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return watches;
    }

    public boolean deleteWatches(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_WATCHES_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateWatches(Watches watches) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_WATCHES_SQL);) {
            statement.setString(1, watches.getTitle());
            statement.setString(2, watches.getType());
            statement.setString(3, watches.getGender());
            statement.setInt(4, watches.getPrice());
            statement.setInt(5, watches.getId());

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
