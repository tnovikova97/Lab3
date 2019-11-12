package mySQL_util;

import java.sql.Connection;
import java.sql.DriverManager;




//public class DBConnection {
//
//    public static Connection createConnection()
//    {
//        Connection connection = null;
//        String url = "jdbc:mysql://localhost:3306/Lab2";
//        //MySQL URL
//        String username = "root";
//        //MySQL username
//        String password = "0000";
//        //MySQL password
//
//        try
//        {
//            try
//            {
//                Class.forName("com.mysql.jdbc.Driver");
//                //загрузка MySQL драйверов.
//                // Различны для разных БД
//            }
//            catch (ClassNotFoundException e)
//            {
//                e.printStackTrace();
//            }
//
//            connection = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
//            System.out.println("Printing connection object "+connection);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        System.out.println("connectied");
//        return connection;
//    }
//}

public class DBConnection {

    public static Connection createConnection()
    {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/jewelry";
        //MySQL URL
        String username = "postgres";
        //MySQL username
        String password = "0000";
        //MySQL password

        try
        {
            try
            {
                Class.forName("org.postgresql.Driver");
                //загрузка MySQL драйверов.
                // Различны для разных БД
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }

            connection = DriverManager.getConnection(url, username, password);
            //попытка подключиться к базе данных MySQL
            System.out.println("Printing connection object "+connection);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("connectied");
        return connection;
    }
}