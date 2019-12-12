package Controller_Servlets;

import Beans.Rings;
import Model_DAO.RingsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/listRings")
public class listRings extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String list = request.getParameter("listRings");

        if (list!=null) {
            if (list.equals("all")) {
                ArrayList<Rings> rings = new ArrayList<>();
                StringBuffer stringBuffer = new StringBuffer();
                RingsDao ringsDao = new RingsDao();
                rings = ringsDao.getAllRing();

                for (int i=0; i < rings.size(); i++) {
                    System.out.println(rings.get(i));
                }

                for (int i=0; i<rings.size(); i++) {
                    stringBuffer.append("<tr>");
                    stringBuffer.append("<td>" + rings.get(i).getId()+ "<td>");
                    stringBuffer.append("<td>" + rings.get(i).getTitle() + "<td>");
                    stringBuffer.append("<td>" + rings.get(i).getBrand() + "<td>");
                    stringBuffer.append("<td>" + rings.get(i).getMetal() + "<td>");
                    stringBuffer.append("<td>" + rings.get(i).getVstavka() + "<td>");
                    stringBuffer.append("<td>" + rings.get(i).getProba() + "<td>");
                    stringBuffer.append("<td>" + rings.get(i).getPrise() + "<td>");
                    stringBuffer.append("<tr>");
                }

                response.setCharacterEncoding("utf-8");
                response.setContentType("text/html");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write(stringBuffer.toString());
            }
        }
        else {
            request.getRequestDispatcher("listRings.jsp").forward(request, response);
        }
    }
}
