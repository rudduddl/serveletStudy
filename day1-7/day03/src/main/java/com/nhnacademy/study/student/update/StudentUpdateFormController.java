package com.nhnacademy.study.student.update;

import com.nhnacademy.study.Command;
import com.nhnacademy.study.student.Student;
import com.nhnacademy.study.student.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentUpdateFormController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        // 학생조회
        String id = request.getParameter("id");
        // ID 파라미터 유효성 검증
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("학생 ID가 필요합니다.");
        }

        Student student = studentRepository.getStudentById(id);

        // 학생 데이터가 없을 경우 처리
        if (student == null) {
            throw new IllegalArgumentException("학생을 찾을 수 없습니다.");
        }

        request.setAttribute("student",student);

        return "/student/register.jsp";
    }
}
