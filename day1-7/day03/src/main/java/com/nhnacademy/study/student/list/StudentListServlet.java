//package com.nhnacademy.study.student.list;
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
//import java.io.IOException;
//import java.util.List;
//
//@Slf4j
//@WebServlet(name="studentListServlet", urlPatterns = "/student/list")
//public class StudentListServlet extends HttpServlet {
//    private StudentRepository studentRepository;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        studentRepository = (StudentRepository)config.getServletContext().getAttribute("studentRepository");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Student list 구하기
//        List<Student> studentList = studentRepository.getStudents();
//
//        // 학생 목록을 request에 설정
//        request.setAttribute("studentList", studentList);
//
//
//        // view 설정 (JSP 경로)
//        request.setAttribute("view", "/student/list.jsp");
//    }
//
//
//}
