package com.nhnacademy.study.error;

import com.nhnacademy.study.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ErrorController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        // get the status code
        Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        request.setAttribute("status_code", statusCode);

        // get exception type
        Exception exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        request.setAttribute("exception_type", exception != null ? exception.getClass().getName() : "N/A");

        // get the exception message (if available)
        String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        request.setAttribute("message", message != null ? message : "N/A");

        // get the request URI that caused the error
        String requestURI = (String) request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        request.setAttribute("request_uri", requestURI != null ? requestURI : "N/A");

        // 에러를 처리할 JSP 경로 반환
        return "/error/error.jsp";
    }
}
