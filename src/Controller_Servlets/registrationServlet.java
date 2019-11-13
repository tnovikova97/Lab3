package Controller_Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import Beans.CustomersBean;
import Model_DAO.RegisterDao;


@WebServlet("/registrationServlet")
public class registrationServlet extends HttpServlet {
    public registrationServlet() {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // копируем все вводимые параметры в локальные переменные
        String username = request.getParameter("username");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        CustomersBean customersBean = new CustomersBean();
        // используем Java Beans - простой способ дествовать с группой связанных данных
        customersBean.setUsername(username);
        customersBean.setSurname(surname);
        customersBean.setEmail(email);
        customersBean.setLogin(login);
        customersBean.setPassword(password);

        RegisterDao registerDAO = new RegisterDao();

        // здесь присутствует базовая логика регистрационного приложения.
        // Мы собираемся вставить пользовательские данные в базу данных.
        String userRegistered = registerDAO.registerUser(customersBean);

        if (userRegistered.equals("success"))
            // В случае успеха перенапрявляем пользователя на страницу home.jsp
        {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        else
            // В случае ошибки отобразить сообщение пользователю.
        {
//            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

// Итог registrationServlet.java:
//1. Назначили все входные данные (данные пользователя) локальными переменным.
//2. Вызвали customerBean.java, чтобы установить все данные пользователя, используя установщики Java.
//3. Затем перешли в RegisterDao.java, где будут вставлены данные пользователя в БД.
//4. Если все прошло успешно, отображаем успешное сообщение.