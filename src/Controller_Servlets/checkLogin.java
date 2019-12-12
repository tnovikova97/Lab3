package Controller_Servlets;

import Beans.UsersBean;
import Model_DAO.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/checkLoginAjax")
public class checkLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String result;
        result = "";

        try {
            String login = request.getParameter("login");
            ArrayList<UsersBean> usersBeans = UsersDao.checkLogin(login);

            if (usersBeans.isEmpty() == false) {
                result = "Данный логин уже занят!";
            }
            else {
                result = "Свободен!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().write(result);
    }
}
