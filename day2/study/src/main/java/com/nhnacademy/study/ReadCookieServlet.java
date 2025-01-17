package com.nhnacademy.study;

import com.nhnacademy.study.utils.CookieUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

@Slf4j
public class ReadCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = CookieUtils.getCookie(request,  "locale");
        log.debug("cookie : {}", cookie);

        if(Objects.isNull(cookie)){
            response.sendError(500, "cookie not found");
            log.debug("error cookie is null");
            return;
        }

        String locale = cookie.getValue();

        String helloValue = ResourceBundle.getBundle("message", new Locale(locale)).getString("hello");

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        try(PrintWriter out = response.getWriter()){
            out.println(helloValue);
        }
    }
}
