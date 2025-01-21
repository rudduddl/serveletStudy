//package com.nhnacademy.study.error;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//import static jakarta.servlet.RequestDispatcher.ERROR_STATUS_CODE;
//
//@WebServlet(name="errorServlet", urlPatterns="/error/error")
//public class ErrorServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException {
//        // get the status code
//        request.setAttribute("status_code", request.getAttribute(ERROR_STATUS_CODE));
//
//        // get exception_type
//        Exception exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
//        request.setAttribute("exception_type", exception != null ? exception.getClass().getName() : "N/A");
//
//        // Get the exception message (if available)
//        String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
//        request.setAttribute("message", message != null ? message : "N/A");
//
//        // Get the request URI that caused the error
//        String requestURI = (String) request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
//        request.setAttribute("request_uri", requestURI != null ? requestURI : "N/A");
//
//        request.getRequestDispatcher("/error/error.jsp").forward(request, response);
//    }
//}
