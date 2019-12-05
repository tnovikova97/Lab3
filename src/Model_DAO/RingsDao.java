package Model_DAO;

import Beans.Rings;
import Database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RingsDao {

    private Connection connection;

    private static final String INSERT_RINGS = "insert into rings (name, brand, metal, vstavka, proba, size, prise) values (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_RINGS_BY_ID = "select id, title, type, gender, price from watch where id = ?";
    private static final String SELECT_ALL_RINGS = "select * from watch";
    private static final String DELETE_RINGS = "delete from rings where id = ?;";
    private static final String UPDATE_RINGS = "update rings set name = ?, brand = ?, metal = ?, vstavka = ?, proba = ?, size = ?, prise = ? where id = ?;";


    public RingsDao () {
        connection = DBConnection.createConnection();
    }

    public void addRing (Rings rings) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RINGS);
            // Parameters start with 1
            preparedStatement.setString(1, rings.getName());
            preparedStatement.setString(2, rings.getBrand());
            preparedStatement.setString(3, rings.getMetal());
            preparedStatement.setString(4, rings.getVstavka());
            preparedStatement.setInt(5, rings.getProba());
            preparedStatement.setFloat(6, rings.getSize());
            preparedStatement.setInt(7, rings.getPrice());
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
            preparedStatement.setString(1, rings.getName());
            preparedStatement.setString(2, rings.getBrand());
            preparedStatement.setString(3, rings.getMetal());
            preparedStatement.setInt(4, rings.getProba());
            preparedStatement.setFloat(5, rings.getSize());
            preparedStatement.setInt(6, rings.getPrice());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Rings> getAllRing() {
        List<Rings> rings = new ArrayList<Rings>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_RINGS);
            while (resultSet.next()) {
                Rings rings1 = new Rings();
                rings1.setId(resultSet.getInt("id"));
                rings1.setName(resultSet.getString("name"));
                rings1.setBrand(resultSet.getString("brand"));
                rings1.setMetal(resultSet.getString("metal"));
                rings1.setVstavka(resultSet.getString("vstavka"));
                rings1.setProba(resultSet.getInt("proba"));
                rings1.setSize(resultSet.getFloat("size"));
                rings1.setPrice(resultSet.getInt("prise"));
                rings.add(rings1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rings;
    }

    public Rings getRingById (int id) {
        Rings rings = new Rings();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RINGS_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                rings.setId(resultSet.getInt("id"));
                rings.setName(resultSet.getString("name"));
                rings.setBrand(resultSet.getString("brand"));
                rings.setMetal(resultSet.getString("metal"));
                rings.setVstavka(resultSet.getString("vstavka"));
                rings.setProba(resultSet.getInt("proba"));
                rings.setSize(resultSet.getFloat("size"));
                rings.setPrice(resultSet.getInt("prise"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rings;
    }

}
