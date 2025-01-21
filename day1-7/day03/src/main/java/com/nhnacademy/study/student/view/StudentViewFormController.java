package com.nhnacademy.study.student.view;

import com.nhnacademy.study.Command;
import com.nhnacademy.study.student.Student;
import com.nhnacademy.study.student.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentViewFormController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        String id = request.getParameter("id");
        if (id == null ) {
            throw new IllegalArgumentException("모든 필드를 입력해야 합니다.");
        }
        // student id 조회
        Student student = studentRepository.getStudentById(id);
        if (student == null) {
            throw new IllegalArgumentException("해당 ID의 학생을 찾을 수 없습니다.");
        }

        // student 조회
        request.setAttribute("student",student);

        return "/student/view.jsp";
    }
}
