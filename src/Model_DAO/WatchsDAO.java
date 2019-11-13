package Model_DAO;

import Beans.WatchsBean;
import mySQL_util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WatchsDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public WatchsDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertWatch(WatchsBean watchsBean) throws SQLException {
        String sql = "insert into watchs(title, type, gender, price) values (?,?,?,?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, watchsBean.getTitle());
        statement.setString(2, watchsBean.getType());
        statement.setString(3, watchsBean.getGender());
        statement.setInt(4, watchsBean.getPrice());

        boolean rowInserted = statement.executeUpdate()>0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<WatchsBean> listAllWatchs() throws SQLException {
        List<WatchsBean> listWatchs = new ArrayList<>();

        String sql = "select * from watchs";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String type = resultSet.getString("type");
            String gender = resultSet.getString("gender");
            int price = resultSet.getInt("price");

            WatchsBean watchsBean = new WatchsBean(id, title, type, gender, price);
            listWatchs.add(watchsBean);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listWatchs;
    }

    public boolean deleteWatch(WatchsBean watchsBean) throws SQLException {
        String sql = "delete from watchs where id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, watchsBean.getId());

        boolean rowDelete = statement.executeUpdate()>0;
        statement.close();
        disconnect();
        return rowDelete;
    }

    public boolean updateWatch(WatchsBean watchsBean) throws SQLException {
        String sql = "update watchs set title = ?, type = ?, gender = ?, price =?";
        sql += " where id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, watchsBean.getTitle());
        statement.setString(2, watchsBean.getType());
        statement.setString(3, watchsBean.getGender());
        statement.setInt(4, watchsBean.getPrice());
        statement.setInt(5, watchsBean.getId());

        boolean rowUpdate = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdate;
    }

    public WatchsBean getWatch(int id) throws SQLException {
        WatchsBean watchsBean = null;
        String sql = "select * from watchs where id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            String title = resultSet.getString("title");
            String type = resultSet.getString("type");
            String gender = resultSet.getString("gender");
            int price = resultSet.getInt("price");

            watchsBean = new WatchsBean(id, title, type, gender, price);
        }

        resultSet.close();
        statement.close();
        return watchsBean;
    }
}
