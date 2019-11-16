package Controller_Servlets;

import Beans.Watches;
import Model_DAO.WatchesDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/watchesServlet")
public class watchesServlet extends HttpServlet {

    private WatchesDAO watchesDAO;

    public void init() {
        watchesDAO = new WatchesDAO();
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
                    insertWatches(request, response);
                    break;
                case "/delete":
                    deleteWatches(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateWatches(request, response);
                    break;
                default:
                    listWatches(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void listWatches(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List <Watches> listWatches = watchesDAO.selectAllWatches();
        request.setAttribute("listWatches", listWatches);
        RequestDispatcher dispatcher = request.getRequestDispatcher("watches-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("watches-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Watches existingWatches = watchesDAO.selectWatches(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("watches-form.jsp");
        request.setAttribute("watches", existingWatches);
        dispatcher.forward(request, response);
    }

    private void insertWatches(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String gender = request.getParameter("gender");
        int price = Integer.parseInt(request.getParameter("price"));
        Watches newWatches = new Watches(title, type, gender, price);
        watchesDAO.insertWatches(newWatches);
        response.sendRedirect("list");
    }

    private void updateWatches(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String gender = request.getParameter("gender");
        int price = Integer.parseInt(request.getParameter("price"));

        Watches book = new Watches(id, title, type, gender, price);
        watchesDAO.updateWatches(book);
        response.sendRedirect("list");
    }

    private void deleteWatches (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        watchesDAO.deleteWatches(id);
        response.sendRedirect("list");
    }
}
