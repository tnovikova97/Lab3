package Model_DAO;

import Beans.CustomersBean;
import mySQL_util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
    public String authenticateUser(CustomersBean customersBean) {

        // Сохранение введенных пользователем значений во временных переменных.
        String login = customersBean.getLogin();
        String password = customersBean.getPassword();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String loginDB = "";
        String passwordDB = "";

        try {

            connection = DBConnection.createConnection();             //установление соединения
            statement = connection.createStatement();             // оператор для написания запросов
            resultSet = statement.executeQuery("select login, password from users");
            // выборка всех записей и сохранение в результате

            while (resultSet.next())
                //до следующего ряда, в противном случае возвращается false
            {
                // получение значений, присутствующих в БД
                loginDB = resultSet.getString("login");
                passwordDB = resultSet.getString("password");

                if (login.equals(loginDB) && password.equals(passwordDB))
                {
                    System.out.println("success");
                    return "success";
                    // если введенные пользователем значения уже присутствуют в БД,
                    // это означает, что пользователь уже зарегистрирован,
                    // поэтому возвращаем сообщение success.
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("error");
        return "Invalid user";
        // в противном случае просто вернем соответствующее сообщение
    }
}

