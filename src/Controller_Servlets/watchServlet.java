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
import java.util.List;

@WebServlet("/")
public class watchServlet extends HttpServlet {

    private WatchDAO watchDAO;

    public void init() {
        watchDAO = new WatchDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertWatch(request, response);
                    break;
                case "/delete":
                    deleteWatch(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateWatch(request, response);
                    break;
                default:
                    listWatch(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void listWatch(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List <Watch> listWatch = watchDAO.selectAllWatch();
        request.setAttribute("listWatch", listWatch);
        RequestDispatcher dispatcher = request.getRequestDispatcher("watch-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("watch-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Watch existingWatch = watchDAO.selectWatch(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("watch-form.jsp");
        request.setAttribute("watch", existingWatch);
        dispatcher.forward(request, response);
    }

    private void insertWatch(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String gender = request.getParameter("gender");
        int price = Integer.parseInt(request.getParameter("price"));
        Watch newWatch = new Watch(title, type, gender, price);
        watchDAO.insertWatch(newWatch);
        response.sendRedirect("list");
    }

    private void updateWatch(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String gender = request.getParameter("gender");
        int price = Integer.parseInt(request.getParameter("price"));

        Watch book = new Watch(id, title, type, gender, price);
        watchDAO.updateWatch(book);
        response.sendRedirect("list");
    }

    private void deleteWatch (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        watchDAO.deleteWatch(id);
        response.sendRedirect("list");
    }
}
