package com.nhnacademy.study.login;

import com.nhnacademy.study.utils.CookieUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Objects;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        //session이 있으면 가져오고 없으면 null
        HttpSession session = request.getSession(false);

        if(Objects.nonNull(session)){
            session.invalidate();
        }

        Cookie cookie = CookieUtils.getCookie(request, "JSESSIONID");
        if(Objects.nonNull(cookie)){
            cookie.setValue("");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        response.sendRedirect("/login.html");

    }
}
