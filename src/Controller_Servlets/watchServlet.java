package Controller_Servlets;

import Beans.WatchsBean;
import Model_DAO.WatchsDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class watchServlet extends HttpServlet {

    private WatchsDAO watchsDAO;

    public void init(){
        watchsDAO = new WatchsDAO();
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
        }
        catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listWatch(HttpServletRequest request, HttpServletResponse response)
        throws  SQLException, IOException, ServletException {
        List <WatchsBean> listWatchsBean = watchsDAO.selectAllWatch();
        request.setAttribute("listWatchsBean", listWatchsBean);
        RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("watchs-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        WatchsBean existingWatchsBean = watchsDAO.selectWatch(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("watchs-form.jsp");
        request.setAttribute("watch", existingWatchsBean);
        dispatcher.forward(request, response);

    }

    private void insertWatch(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String gender = request.getParameter("gender");
        int price = Integer.parseInt(request.getParameter("price"));
        WatchsBean newWatchsBean = new WatchsBean(title, type, gender, price);
        watchsDAO.insertWatch(newWatchsBean);
        response.sendRedirect("list");
    }

    private void updateWatch(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String gender = request.getParameter("gender");
        int price = Integer.parseInt(request.getParameter("price"));

        WatchsBean book = new WatchsBean(id, title, type, gender, price);
        watchsDAO.updateWatch(book);
        response.sendRedirect("list");
    }

    private void deleteWatch(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        watchsDAO.deleteWatch(id);
        response.sendRedirect("list");
    }
}
