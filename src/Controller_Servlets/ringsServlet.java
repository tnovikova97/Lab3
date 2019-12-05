package Controller_Servlets;

import Beans.Rings;
import Model_DAO.RingsDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ringsServlet")
public class ringsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/rings.jsp";
    private static String LIST_RINGS = "/listRings.jsp";
    private RingsDao ringsDao;

    public ringsServlet() {
        super();
        ringsDao = new RingsDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            ringsDao.deleteRing(id);
            forward = LIST_RINGS;
            request.setAttribute("rings", ringsDao.getAllRing());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Rings rings = ringsDao.getRingById(id);
            request.setAttribute("rings", rings);
        } else if (action.equalsIgnoreCase("listRings")) {
            forward = LIST_RINGS;
            request.setAttribute("rings", ringsDao.getAllRing());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF8");

        Rings rings = new Rings();
        rings.setName(request.getParameter("name"));
        rings.setBrand(request.getParameter("brand"));
        rings.setMetal(request.getParameter("metal"));
        rings.setVstavka(request.getParameter("vstavka"));
        rings.setProba(Integer.parseInt(request.getParameter("proba")));
        rings.setSize(Float.parseFloat(request.getParameter("size")));
        rings.setPrice(Integer.parseInt(request.getParameter("prise")));
        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            ringsDao.addRing(rings);
        }
        else {
            rings.setId(Integer.parseInt(id));
            ringsDao.updateRing(rings);
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_RINGS);
        request.setAttribute("rings1", ringsDao.getAllRing());
        view.forward(request, response);
    }
}
