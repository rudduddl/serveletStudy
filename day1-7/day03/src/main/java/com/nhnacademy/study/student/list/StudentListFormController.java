package com.nhnacademy.study.student.list;

import com.nhnacademy.study.Command;
import com.nhnacademy.study.student.Student;
import com.nhnacademy.study.student.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class StudentListFormController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        // Student list 구하기
        List<Student> studentList = studentRepository.getStudents();
        // 학생 목록을 request에 설정
        request.setAttribute("studentList", studentList);

        return "/student/list.jsp";
    }

}
