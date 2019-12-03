package Controller_Servlets;

import Beans.UsersBean;
import Model_DAO.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

//    public loginServlet() {
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // извлекаем значения, введенные пользователем,
        // и сохраняем переменные экземпляра для дальнейшего использования.
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UsersBean usersBean = new UsersBean();

        usersBean.setLogin(login);
        usersBean.setPassword(password);
        //установка логина и пароля через объект usersBean,
        // для возможности получения их будущем.

        LoginDao loginDao = new LoginDao();
        //создание объекта для LoginDao
        if(loginDao == null)
            System.out.println(" Объект логин не создан");

        try {
            String userValidate = loginDao.authenticateUser(usersBean);
            // вызов функции authenticateUser


            //        if (userValidate.equals("success"))
//            // если функция возвращается успешно,
//            // то пользователь будет переведен на домашнюю страницу
//        {
//            request.setAttribute("login", login);
//            // с setAttribute () мы можем определить пару «ключ» и значение,
//            // чтобы м могли получить ее в будущем, используя getAttribute («ключ»)
//            request.getRequestDispatcher("products.jsp").forward(request, response);
//            //RequestDispatcher используется для отправки элемента управления на вызванную страницу


            if (userValidate.equals("Admin_role"))
            {
                System.out.println("Admin's Home");

                HttpSession session = request.getSession();
                //create session
                session.setAttribute("admin", login);
                //setting session attribute
                request.setAttribute("login_temp", login);

                request.getRequestDispatcher("watch-list.jsp").forward(request, response);
            }
            else if (userValidate.equals("Editor_role"))
            {
                System.out.println("Editor's Home");

                HttpSession session = request.getSession();
                session.setAttribute("editor", login);
                request.setAttribute("login_temp", login);

                request.getRequestDispatcher("watch-list.jsp").forward(request, response);
            }
            else if (userValidate.equals("User_role"))
            {
                System.out.println("Users's Home");

                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(10*60);
                session.setAttribute("user", login);
                request.setAttribute("login_temp", login);

                request.getRequestDispatcher("watch-list.jsp").forward(request, response);
            }
            else {
                System.out.println("Error message = " + userValidate);
                request.setAttribute("errMessage", userValidate);
                //Если функция authenticateUser () возвращает другую строку, чем SUCCESS,
                // она будет снова отправлена на страницу входа.
                // Здесь сообщение об ошибке, возвращаемое функцией, было сохранено в ключе errMessage.
                request.getRequestDispatcher("index.html").forward(request, response);
                //пересылка запроса
            }
        }

        catch (IOException e1) {
            e1.printStackTrace();
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        doGet(request, response);

    }


}

