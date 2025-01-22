package com.nhnacademy.study.front;

import com.nhnacademy.study.Command;
import com.nhnacademy.study.error.ErrorController;
import com.nhnacademy.study.student.delete.StudentDeleteController;
import com.nhnacademy.study.student.list.StudentListFormController;
import com.nhnacademy.study.student.register.StudentRegisterController;
import com.nhnacademy.study.student.register.StudentRegisterFormController;
import com.nhnacademy.study.student.update.StudentUpdateController;
import com.nhnacademy.study.student.update.StudentUpdateFormController;
import com.nhnacademy.study.student.view.StudentViewFormController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 공통 처리 - 응답 content-type, character encoding 지정
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try {
            // 요청 URL과 메서드에 따라 알맞은 Command를 선택
            Command command = resolveCommand(request.getServletPath(), request.getMethod());

            if (command == null) {
                // Command가 없는 경우 에러 처리
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "요청한 페이지를 찾을 수 없습니다.");
                return;
            }

            // Command 실행 후 view 반환
            String view = command.execute(request, response);

            if (view.startsWith(REDIRECT_PREFIX)) {
                // `redirect:`로 시작하면 리다이렉트 처리
                response.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                // 리다이렉트가 아니면 JSP로 포워딩 처리
                RequestDispatcher rd = request.getRequestDispatcher(view);
                rd.forward(request, response);
            }
        } catch (Exception e) {
            // 에러 발생 시 에러 페이지 처리
            log.error("Error occurred in FrontServlet", e);
            request.setAttribute("exception", e);
            RequestDispatcher rd = request.getRequestDispatcher("/error/error.jsp");
            rd.forward(request, response);
        }
    }

    //요청 URL에 따라 실제 요청을 처리할 Servlet 결정
    private Command resolveCommand(String servletPath, String method){
        Command command = null;
        if("/student/list.do".equals(servletPath) && "GET".equalsIgnoreCase(method) ){
            command = new StudentListFormController();
        }else if("/student/view.do".equals(servletPath) && "GET".equalsIgnoreCase(method) ){
            command = new StudentViewFormController();
        }else if("/student/delete.do".equals(servletPath) && "POST".equalsIgnoreCase(method) ){
            command = new StudentDeleteController();
        }else if("/student/update.do".equals(servletPath) && "GET".equalsIgnoreCase(method) ){
            command = new StudentUpdateFormController();
        }else if("/student/update.do".equals(servletPath) && "POST".equalsIgnoreCase(method) ){
            command = new StudentUpdateController();
        }else if("/student/register.do".equals(servletPath) && "GET".equalsIgnoreCase(method) ){
            command = new StudentRegisterFormController();
        }else if("/student/register.do".equals(servletPath) && "POST".equalsIgnoreCase(method) ){
            command = new StudentRegisterController();
        }else if("/error/error.do".equals(servletPath)){
            command = new ErrorController();
        }
        return command;
    }
}
