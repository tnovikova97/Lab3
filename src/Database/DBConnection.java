package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection createConnection()
    {
        Connection connection = null;

        // прописываем url адрес подключения к БД используя кодировку UTF8
        String url = "jdbc:postgresql://localhost:5432/jewelry?useUnicode=true&characterEncoding=utf8";
        // указываем имя пользователя БД
        String username = "postgres";
        // указывем пароль
        String password = "0000";

        try
        {
            try
            {
                // загружаем postgree драйвер БД, драйвера различны для разных БД
                // динамическая загрузка драйвера, который расширяет DriverManager
                Class.forName("org.postgresql.Driver");

            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }

            connection = DriverManager.getConnection(url, username, password);
            //попытка подключиться к базе данных
            System.out.println("Printing connection object "+connection);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("connected");
        return connection;
    }
}