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

@WebServlet("/searchServlet")
// Наследуем класс от HttpServlet и переопределяем метод doGet();
public class searchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try {
            // Получение из запроса значения параметра. Наименование параметра определено значением name.
            // String getParameter(String name)

            String title = request.getParameter("title");

            // массив (список) - таблица колец
            // поиск происходит функцией searchRing из RingsDao
            ArrayList<Rings> rings = RingsDao.searchRing(title);
            // условие: если список не пустой
            if (rings!= null) {
                //передаем данные на jsp страницу
                request.setAttribute("rings", rings);
                request.getRequestDispatcher("searchRings.jsp").forward(request, response);
            }
            else {
                // если ошибка - на страницу ошибки
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
