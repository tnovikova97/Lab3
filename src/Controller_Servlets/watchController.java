package Controller_Servlets;

import Beans.Watch;
import Model_DAO.WatchDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/watchController")
public class watchController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/watch-form.jsp";
    private static String LIST_WATCH = "/watch-list.jsp";
    private WatchDAO watchDAO;

    public watchController() {
        super();
        watchDAO = new WatchDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            watchDAO.delete(id);
            forward = LIST_WATCH;
            request.setAttribute("watch", watchDAO.selectAllWatch());
            System.out.println("удаляем с помощью watchController");
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Watch watch = watchDAO.selectWatch(id);
            request.setAttribute("watch", watch);
            System.out.println("редачим с помощью watchController");
        } else if (action.equalsIgnoreCase("listWatch")) {
            forward = LIST_WATCH;
            request.setAttribute("watch", watchDAO.selectAllWatch());
            System.out.println("смотрим с помощью watchController");
        }
        else {
            forward = LIST_WATCH;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
        dispatcher.forward(request, response);
    }
}
