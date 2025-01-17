package com.nhnacademy.study.login;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@Slf4j
public class LoginServlet extends HttpServlet {
    private String initParamId;
    private String initParamPwd;

    @Override
    public void init(ServletConfig config) throws ServletException {
        initParamId = config.getInitParameter("id");
        initParamPwd = config.getInitParameter("pwd");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //session이 있으면 가져오고 없으면 null(login 화면으로 이동)
        HttpSession session = request.getSession(false);
        if (Objects.isNull(session) || Objects.isNull(session.getAttribute("id"))) {
            response.sendRedirect("/login.html");
        } else {
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");

            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset='utf-8'>");
                out.println("</head>");
                out.println("<body>");
                out.println("login success : id = " + session.getAttribute("id") + "<br/>");
                out.println("<a href='/logout'>logout</a>");
                out.println("</body>");
                out.println("</html>");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        if(initParamId.equals(id) && initParamPwd.equals(pwd)){
            //session이 있으면 가져오고 없으면 생성
            HttpSession session = request.getSession();
            log.info("로그인 성공!");
            session.setAttribute("id", id);
            response.sendRedirect("/login");
        }else{
            log.error("아이디/패스워드가 일치하지 않습니다.");
            response.sendRedirect("/login.html");
        }
    }
}




















