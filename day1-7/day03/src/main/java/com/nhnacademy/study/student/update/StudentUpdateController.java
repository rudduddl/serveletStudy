package com.nhnacademy.study.student.update;

import com.nhnacademy.study.Command;
import com.nhnacademy.study.student.Gender;
import com.nhnacademy.study.student.Student;
import com.nhnacademy.study.student.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.time.LocalDateTime;

public class StudentUpdateController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");

        // 파라미터 null 체크
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String genderParam = request.getParameter("gender");
        String ageParam = request.getParameter("age");

        if (id == null || name == null || genderParam == null || ageParam == null) {
            throw new IllegalArgumentException("모든 필드를 입력해야 합니다.");
        }

        try {
            // 입력된 데이터로 Student 객체 생성
            Gender gender = Gender.valueOf(genderParam.toUpperCase());
            int age = Integer.parseInt(ageParam);

            Student student = new Student(id, name, gender, age, LocalDateTime.now());

            // studentRepository에 저장
            studentRepository.update(student);

            // 저장된 데이터 확인
            Student savedStudent = studentRepository.getStudentById(student.getId());
            return "redirect:/student/view.do?id="+id;

        } catch (IllegalArgumentException e) {
            // Gender 또는 age 변환 실패 시 에러 처리
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
        }
    }
}
