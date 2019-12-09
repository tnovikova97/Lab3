package Model_DAO;

import Beans.Rings;
import Database.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Database.DBConnection.createConnection;

public class RingsDao {

    private Connection connection;

    private static final String INSERT_RINGS = "insert into rings (title, brand, metal, vstavka, proba, size, prise) values (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_RINGS_BY_ID = "select id, title, brand, metal, vstavka, proba, size, prise from rings where id = ?";
    private static final String SELECT_ALL_RINGS = "select * from rings";
    private static final String DELETE_RINGS = "delete from rings where id = ?;";
    private static final String UPDATE_RINGS = "update rings set title = ?, brand = ?, metal = ?, vstavka = ?, proba = ?, size = ?, prise = ? where id = ?;";
//    private static final String FIND_RINGS = "select * from rings where title = '" +title+ "' order by id;";


    public RingsDao () {
        connection = createConnection();
    }

    public void addRing (Rings rings) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RINGS);
            // Parameters start with 1
            preparedStatement.setString(1, rings.getTitle());
            preparedStatement.setString(2, rings.getBrand());
            preparedStatement.setString(3, rings.getMetal());
            preparedStatement.setString(4, rings.getVstavka());
            preparedStatement.setInt(5, rings.getProba());
            preparedStatement.setFloat(6, rings.getSize());
            preparedStatement.setInt(7, rings.getPrise());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRing (int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RINGS);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRing (Rings rings) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RINGS);
            // parameters start with 1
            preparedStatement.setString(1, rings.getTitle());
            preparedStatement.setString(2, rings.getBrand());
            preparedStatement.setString(3, rings.getMetal());
            preparedStatement.setString(4, rings.getVstavka());
            preparedStatement.setInt(5, rings.getProba());
            preparedStatement.setFloat(6, rings.getSize());
            preparedStatement.setInt(7, rings.getPrise());
            preparedStatement.setInt(8, rings.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Rings> getAllRing() {
        ArrayList<Rings> ring = new ArrayList<Rings>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_RINGS);
            while (resultSet.next()) {
                Rings rings = new Rings();
                rings.setId(resultSet.getInt("id"));
                rings.setTitle(resultSet.getString("title"));
                rings.setBrand(resultSet.getString("brand"));
                rings.setMetal(resultSet.getString("metal"));
                rings.setVstavka(resultSet.getString("vstavka"));
                rings.setProba(resultSet.getInt("proba"));
                rings.setSize(resultSet.getFloat("size"));
                rings.setPrise(resultSet.getInt("prise"));
                ring.add(rings);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ring;
    }


//    public List < Rings > getAllRing() {
//
//        // using try-with-resources to avoid closing resources (boiler plate code)
//        List< Rings > rings = new ArrayList<>();
//        // Step 1: Establishing a Connection
//        try (Connection connection = createConnection();
//
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RINGS);) {
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String title = rs.getString("title");
//                String brand = rs.getString("brand");
//                String metal = rs.getString("metal");
//                String vstavka = rs.getString("vstavka");
//                int proba = rs.getInt("proba");
//                float size = rs.getFloat("size");
//                int prise = rs.getInt("prise");
//
//                rings.add(new Rings(id, title, brand, metal, vstavka, proba, size, prise));
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return rings;
//    }

    public Rings getRingById (int id) {
        Rings rings = new Rings();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RINGS_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                rings.setId(resultSet.getInt("id"));
                rings.setTitle(resultSet.getString("title"));
                rings.setBrand(resultSet.getString("brand"));
                rings.setMetal(resultSet.getString("metal"));
                rings.setVstavka(resultSet.getString("vstavka"));
                rings.setProba(resultSet.getInt("proba"));
                rings.setSize(resultSet.getFloat("size"));
                rings.setPrise(resultSet.getInt("prise"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rings;
    }

    public static ArrayList<Rings> searchRing(String title) {
        ArrayList<Rings> rings = new ArrayList<>();
        String query = null;
        if (title!=null){
            query = "select * from rings where title = '" +title+ "' order by id;";
        }
        else {
            query = SELECT_ALL_RINGS;
        }

        try {
            Connection connection = createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title1 = resultSet.getString("title");
                String brand = resultSet.getString("brand");
                String metal = resultSet.getString("metal");
                String vstavka = resultSet.getString("vstavka");
                int proba = resultSet.getInt("proba");
                float size = resultSet.getFloat("size");
                int prise = resultSet.getInt("prise");
                Rings rings1 = new Rings(id, title1, brand, metal, vstavka, proba, size, prise);
                rings.add(rings1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rings;
    }




//    private void printSQLException(SQLException ex) {
//        for (Throwable e: ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }

}
