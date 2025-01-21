//package com.nhnacademy.study.student.register;
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
//
//@Slf4j
//@WebServlet(name = "studentRegisterServlet", urlPatterns = "/student/register")
//public class StudentRegisterServlet extends HttpServlet {
//
//    private StudentRepository studentRepository;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        // studentRepository를 ServletContext에서 초기화
//        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
//        if (studentRepository == null) {
//            throw new ServletException("StudentRepository is not initialized in the context.");
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // /student/register.jsp 로 포워딩
//        req.getRequestDispatcher("/student/register.jsp").forward(req, resp);
//        req.setAttribute("view", "redirect:/student/register.jsp");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 파라미터 null 체크
//        String id = req.getParameter("id");
//        String name = req.getParameter("name");
//        String genderParam = req.getParameter("gender");
//        String ageParam = req.getParameter("age");
//
//        if (id == null || name == null || genderParam == null || ageParam == null) {
//            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "모든 필드를 입력해야 합니다.");
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
//            studentRepository.save(student);
//
//            // 저장된 데이터 확인
//            Student savedStudent = studentRepository.getStudentById(student.getId());
//            log.debug("저장된 학생: {}", savedStudent);
//
//
//            // 성공적으로 저장되면 해당 학생 상세 페이지로 리다이렉트
////            resp.sendRedirect(req.getContextPath() + "/student/view?id=" + id);
//            req.setAttribute("view", "redirect:/student/view.do?id=" + id);
//        } catch (IllegalArgumentException e) {
//            // Gender 또는 age 변환 실패 시 에러 처리
//            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "유효하지 않은 입력값입니다.");
//        }
//    }
//}
