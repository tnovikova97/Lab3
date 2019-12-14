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

@WebServlet("/checkLoginAjax")
public class checkLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result;
        result="";

        try {
            String logins = request.getParameter("login");
            String user = UsersDao.checkLogin(logins);
            if(logins!=""){result="not empty";}
            else {result="empty";}
        }
        catch (Exception ex){
        }
        response.getWriter().write(result);
    }

}