package Model_DAO;

import Beans.UsersBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class UsersDao {
//
    public static boolean checkLogin1(String login) {


        String url = "jdbc:postgresql://localhost:5432/jewelry?useUnicode=true&characterEncoding=utf8";
        String username = "postgres";
        String password = "0000";

        boolean st = false;
        String query = null;

        if (login!=null) {
            query = "select * from users where login=' "+ login +"'order by user_id";
        }
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    st = resultSet.getBoolean(5);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }

    public static String checkLogin(String login) {

        String url = "jdbc:postgresql://localhost:5432/jewelry?useUnicode=true&characterEncoding=utf8";
        String username = "postgres";
        String password = "0000";

        String query=null;
        String logins="";
        if (login!=null)
        {query ="select * from users where login='"+login+"'";}
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    logins = resultSet.getString(5);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return logins;
    }
}