package Model_DAO;

import Beans.WatchsBean;
import mySQL_util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static mySQL_util.DBConnection.createConnection;

public class WatchsDAO {

    private static final String INSERT_WATCH_SQL = "INSERT INTO watchs" + "  (title, type, gender, price) VALUES " +
            " (?, ?, ?, ?);";
    private static final String SELECT_WATCH_BY_ID = "select id, title, type, gender, price from watchs where id =?;";
    private static final String SELECT_ALL_WATCH = "select * from watchs;";
    private static final String DELETE_WATCH_SQL = "delete from watchs where id = ?;";
    private static final String UPDATE_WATCH_SQL = "update watchs set title = ?, type = ?, gender = ?, price = ? where id = ?;";

    public WatchsDAO() {
    }

    public void insertWatch(WatchsBean watchsBean) throws SQLException {
        System.out.println(INSERT_WATCH_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WATCH_SQL)) {
            preparedStatement.setString(1, watchsBean.getTitle());
            preparedStatement.setString(2, watchsBean.getType());
            preparedStatement.setString(3, watchsBean.getGender());
            preparedStatement.setInt(4, watchsBean.getPrice());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public WatchsBean selectWatch(int id) {
        WatchsBean watchsBean = null;
        // Step 1: Establishing a Connection
        try (Connection connection = createConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WATCH_BY_ID)) {
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
                watchsBean = new WatchsBean(id, title, type, gender, price);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return watchsBean;
    }

    public List<WatchsBean> selectAllWatch() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<WatchsBean> watchsBeans = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = createConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WATCH)) {
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
                watchsBeans.add(new WatchsBean(id, title, type, gender, price));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return watchsBeans;
    }

    public boolean deleteWatch(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = createConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_WATCH_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateWatch(WatchsBean watchsBean) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_WATCH_SQL)) {
            statement.setString(1, watchsBean.getTitle());
            statement.setString(2, watchsBean.getType());
            statement.setString(3, watchsBean.getGender());
            statement.setInt(4, watchsBean.getPrice());
            statement.setInt(5, watchsBean.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
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
