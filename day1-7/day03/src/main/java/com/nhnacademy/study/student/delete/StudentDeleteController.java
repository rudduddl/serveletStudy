package com.nhnacademy.study.student.delete;

import com.nhnacademy.study.Command;
import com.nhnacademy.study.student.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentDeleteController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        String id = request.getParameter("id");
        studentRepository.deleteById(id);
        // view를 return합니다.
        return "redirect:/student/list.do";

    }
}