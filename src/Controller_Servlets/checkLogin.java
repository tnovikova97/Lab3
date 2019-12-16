package Controller_Servlets;

import Beans.UsersBean;
import Database.DBConnection;
import Model_DAO.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//@WebServlet("/checkLoginAjax")
//public class checkLogin extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException {
//
//        String result;
//        result = "";
//
//        try {
//            String st = request.getParameter("login");
//            boolean login1 = UsersDao.checkLogin1(st);
//
//            if (login1 == true) {
//                result = "error";
//            }
//            else {
//                result = "empty";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        response.getWriter().write(result);
//    }
//
//}
//
//@WebServlet("/checkLoginAjax")
//public class checkLogin extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String result;
//        result="";
//
//        try {
//            String logins = request.getParameter("login");
//            String user = UsersDao.checkLogin(logins);
//            if(logins!=""){result="not empty";}
//            else {result="empty";}
//        }
//        catch (Exception ex){
//        }
//        response.getWriter().write(result);
//    }
//
//}


@WebServlet("/checkLoginAjax")
public class checkLogin extends HttpServlet {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String loginID = request.getParameter("loginID");

        try {
            connection = DBConnection.createConnection();
            preparedStatement = connection.prepareStatement("select * from users where login = ?;");
            preparedStatement.setString(1, loginID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // установка кодировки
                response.setCharacterEncoding("utf-8");
                // Установка типа содержимого ответа, отправляемого клиенту
                response.setContentType("text/html");
                // Директива no-cache означает, что при повторном запросе к тому же URL
                response.setHeader("Cache-Control", "no-cache");
                // записываем ответ сервлета
                PrintWriter out = response.getWriter();
                out.print("Занят!");
            }
            else {
                response.setCharacterEncoding("utf-8");
                response.setContentType("text/html");
                response.setHeader("Cache-Control", "no-cache");
                PrintWriter out = response.getWriter();
                out.print("Свободен!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}