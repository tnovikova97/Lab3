package Model_DAO;

import Beans.CustomersBean;
import mySQL_util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
    public String registerUser(CustomersBean customersBean) {
        String username = customersBean.getUsername();
        String surname = customersBean.getSurname();
        String email = customersBean.getEmail();
        String login = customersBean.getLogin();
        String password = customersBean.getPassword();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnection.createConnection();
            String query = "insert into customers(username, surname, email, login, password) values (?,?,?,?,?)";

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
                System.out.println("succes");
                return "succes";
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
