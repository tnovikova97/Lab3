package Controller_Servlets;

import Beans.CustomersBean;
import Model_DAO.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

    public loginServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // извлекаем значения, введенные пользователем,
        // и сохраняем переменные экземпляра для дальнейшего использования.
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        CustomersBean customersBean = new CustomersBean();

        customersBean.setLogin(login);
        customersBean.setPassword(password);
        //установка логина и пароля через объект customerBean,
        // для возможности получения их будущем.

        LoginDao loginDao = new LoginDao();
        //создание объекта для LoginDao

        String userValidate = loginDao.authenticateUser(customersBean);
        // вызов функции authenticateUser

        if (userValidate.equals("success"))
            // если функция возвращается успешно,
            // то пользователь будет переведен на домашнюю страницу
        {
            request.setAttribute("login", login);
            // с setAttribute () мы можем определить пару «ключ» и значение,
            // чтобы м могли получить ее в будущем, используя getAttribute («ключ»)
            request.getRequestDispatcher("home.jsp").forward(request, response);
            //RequestDispatcher используется для отправки элемента управления на вызванную страницу
        }
        else
        {
            request.setAttribute("errMessage", userValidate);
            //Если функция authenticateUser () возвращает другую строку, чем SUCCESS,
            // она будет снова отправлена на страницу входа.
            // Здесь сообщение об ошибке, возвращаемое функцией, было сохранено в ключе errMessage.
            request.getRequestDispatcher("index.html").forward(request, response);
            //пересылка запроса
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
