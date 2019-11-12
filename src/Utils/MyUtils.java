package Utils;

import Beans.CustomersBean;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

public class MyUtils {
    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

    // сохранить connection в attribute в request
    // данная информация хранения существует только во время запроса (request)
    // до тех пор? пока данные возвращаются приложению пользователя
    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }

    // сохраняем информацию пользователя, который вошел в систему (login) в session
    public static void storeLoginedUser(HttpSession session, CustomersBean loginedUser) {
        // в jsp можно получить доступ через ${loginedUser}
        session.setAttribute("loginedUser", loginedUser);
    }

    // получаем информацию пользователя, сохраненную в session
    public static CustomersBean getLoginedUser(HttpSession session){
        CustomersBean loginedUser = (CustomersBean)session.getAttribute("loginedUser");
        return loginedUser;
    }

    // сохраняем информацию пользователя в cookie
    public static void storeUserCookie(HttpServletResponse response, CustomersBean user) {
        System.out.println("Store user cookie");
        Cookie cookieUsername = new Cookie(ATT_NAME_USER_NAME, user.getUsername());
        // 1 день (в секундах)
        cookieUsername.setMaxAge(24*60*60);
        response.addCookie(cookieUsername);
    }

    public static String getUsernameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    // удаление cookie пользователя
    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieUsername = new Cookie(ATT_NAME_USER_NAME, null);
        // 0 секунд - но данный куки будет сразу недействителен
        cookieUsername.setMaxAge(0);
        response.addCookie(cookieUsername);
    }
}
