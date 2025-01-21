//package com.nhnacademy.study.student.update;
//
//import com.nhnacademy.study.student.Gender;
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
//import java.time.LocalDateTime;
////doGet일때는 register.jsp를 보여주고 doPost일때는 view.jsp 보여줌
//@Slf4j
//@WebServlet(name = "studentUpdateServlet", urlPatterns = "/student/update")
//public class StudentUpdateServlet extends HttpServlet {
//    private StudentRepository studentRepository;
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        //todo init studentRepository
//        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
//        if (studentRepository == null) {
//            throw new ServletException("StudentRepository is not initialized in the context.");
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        // 학생조회
//        String id = request.getParameter("id");
//
//        // ID 파라미터 유효성 검증
//        if (id == null || id.isEmpty()) {
//            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "학생 ID가 필요합니다.");
//            return;
//        }
//
//        Student student = studentRepository.getStudentById(id);
//
//        // 학생 데이터가 없을 경우 처리
//        if (student == null) {
//            response.sendError(HttpServletResponse.SC_NOT_FOUND, "학생을 찾을 수 없습니다.");
//            return;
//        }
//
//        request.setAttribute("student",student);
//
//        request.setAttribute("view", "/student/register.jsp");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 파라미터 null 체크
//        String id = request.getParameter("id");
//        String name = request.getParameter("name");
//        String genderParam = request.getParameter("gender");
//        String ageParam = request.getParameter("age");
//
//        if (id == null || name == null || genderParam == null || ageParam == null) {
//            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "모든 필드를 입력해야 합니다.");
//            return;
//        }
//
//        try {
//            // 입력된 데이터로 Student 객체 생성
//            Gender gender = Gender.valueOf(genderParam.toUpperCase());
//            int age = Integer.parseInt(ageParam);
//
//            Student student = new Student(id, name, gender, age, LocalDateTime.now());
//
//            // studentRepository에 저장
//            studentRepository.update(student);
//
//            // 저장된 데이터 확인
//            Student savedStudent = studentRepository.getStudentById(student.getId());
//            log.debug("저장된 학생: {}", savedStudent);
//
//
//            // 성공적으로 저장되면 해당 학생 상세 페이지로 리다이렉트
////            response.sendRedirect(request.getContextPath() + "/student/view?id=" + id);
//            request.setAttribute("view", "redirect:/student/view.do?id=" + id);
//
//        } catch (IllegalArgumentException e) {
//            // Gender 또는 age 변환 실패 시 에러 처리
//            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "유효하지 않은 입력값입니다.");
//        }
//    }
//
//}