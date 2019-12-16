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

        // объявляем переменную list и получаем в нее параметр listRings
        String list = request.getParameter("listRings");

        // проверяем условие: если переменная list не равна 0
        if (list!=null) {
            // проверяем условие: если переменная list равняется значению all
            if (list.equals("all")) {
                // создаем новый список rings
                ArrayList<Rings> rings = new ArrayList<>();
                // Класс StringBuffer представляет расширяемые и доступные для изменений последовательности символов,
                // позволяя вставлять символы и подстроки в существующую строку и в любом месте
                StringBuffer stringBuffer = new StringBuffer();
                // создаем новый объект RingsDao()
                RingsDao ringsDao = new RingsDao();
                // переменной rings присваеваем функцию вывода всей продукции
                rings = ringsDao.getAllRing();


                // создаем цикл, объявляем переменную i и присваем ей значение 0
                // затем используя метод size() для получения количества элементов в этом списке
                // увеличиваем переменную на единицу
                for (int i=0; i < rings.size(); i++) {
                    System.out.println(rings.get(i));
                }

                for (int i=0; i<rings.size(); i++) {
                    // Конкатенация строк через StringBuffer с помощью метода append
                    // который обновляет значение объекта в языке программирования Java
                    // добавляет символы в конец существующей последовательности
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

                // установка кодировки
                response.setCharacterEncoding("utf-8");
                // Установка типа содержимого ответа, отправляемого клиенту
                response.setContentType("text/html");
                // Директива no-cache означает, что при повторном запросе к тому же URL
                // ответ можно использовать только после проверки изменений
                response.setHeader("Cache-Control", "no-cache");
                // записываем ответ сервлета
                response.getWriter().write(stringBuffer.toString());
            }
        }
        else {
            // иначе перенаправляем на страницу listRings.jsp
            request.getRequestDispatcher("listRings.jsp").forward(request, response);
        }
    }
}
