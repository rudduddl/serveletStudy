//package com.nhnacademy.study.student.view;
//
//import com.nhnacademy.study.student.Student;
//import com.nhnacademy.study.student.StudentRepository;
//import jakarta.servlet.ServletConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//
//import javax.xml.namespace.QName;
//import java.io.IOException;
//
//@Slf4j
//@WebServlet(name="studentViewServlet", urlPatterns = "/student/view")
//public class StudentViewServlet extends HttpServlet {
//    private StudentRepository studentRepository;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        this.studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
//        if (studentRepository == null) {
//            throw new ServletException("StudentRepository is not initialized in the context.");
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException {
//        String id = request.getParameter("id");
//        if (id == null ) {
//            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "모든 필드를 입력해야 합니다.");
//            return;
//        }
//        // student 조회
//        Student student = studentRepository.getStudentById(id);
//        if (student == null) {
//            response.sendError(HttpServletResponse.SC_NOT_FOUND, "해당 ID의 학생을 찾을 수 없습니다.");
//            return;
//        }
//
//        // student 조회
//        request.setAttribute("student",student);
//
//        // /student/view.jsp <-- forward
////        request.getRequestDispatcher("/student/view.jsp").forward(request, response);
//        request.setAttribute("view", "/student/view.jsp");
//    }
//
//}
