package Model_DAO;

import Beans.UsersBean;
import Database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
    public String registerUser(UsersBean usersBean) {
        String username = usersBean.getUsername();
        String surname = usersBean.getSurname();
        String email = usersBean.getEmail();
        String login = usersBean.getLogin();
        String password = usersBean.getPassword();


        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnection.createConnection();
            String query = "insert into users(username, surname, email, login, password) values (?,?,?,?,?)";

            // вставляем данные пользователя в таблицу customers
            preparedStatement = connection.prepareStatement(query);
            // используем здесь готовые операторы для вставки данных
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, login);
            preparedStatement.setString(5, password);


            int i = preparedStatement.executeUpdate();

            if (i!=0)
                // чтобы убедиться, что данные были вставлены в базу данных
                System.out.println("success");
                return "success";
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }

        System.out.println("error");
        return "Oops.. Something went wrong there!";
        // в случае ошибки отправить сообщение
    }

}
