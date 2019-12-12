package Model_DAO;

import Beans.UsersBean;
import Database.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
    public String authenticateUser(UsersBean usersBean) {

        // Сохранение введенных пользователем значений во временных переменных.
        String login = usersBean.getLogin();
        String password = usersBean.getPassword();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String loginDB = "";
        String passwordDB = "";
        String roleDB ="";

        try {

            connection = DBConnection.createConnection();             //установление соединения
            statement = connection.createStatement();             // оператор для написания запросов
            resultSet = statement.executeQuery("select login, password, role from users");
            // выборка всех записей и сохранение в результате

            while (resultSet.next())
                //до следующего ряда, в противном случае возвращается false
            {
                // получение значений, присутствующих в БД
                loginDB = resultSet.getString("login");
                passwordDB = resultSet.getString("password");
                roleDB = resultSet.getString("role");

                if (login.equals(loginDB) && password.equals(passwordDB) && roleDB.equals("admin"))
                return "Admin_role";
                else if (login.equals(loginDB) && password.equals(passwordDB) && roleDB.isEmpty())
                return "Editor_role";
                else
                    if (login.equals(loginDB) && password.equals(passwordDB) && roleDB.equals("user"))
                return "User_role";
//                        {
//                    System.out.println("success");
//                    return "success";
//                    // если введенные пользователем значения уже присутствуют в БД,
//                    // это означает, что пользователь уже зарегистрирован,
//                    // поэтому возвращаем сообщение success.
//                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("error");
        return "Invalid user or credentials";
        // в противном случае просто вернем соответствующее сообщение
    }

}

