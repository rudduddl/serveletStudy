package com.nhnacademy.study.student;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.time.LocalDateTime;
import java.util.Random;

@WebListener
public class WebApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Random random = new Random();
        ServletContext context = sce.getServletContext();
        StudentRepository studentRepository = new MapStudentRepository();

        // 랜덤 학생 데이터 생성 및 저장
        for (int i = 1; i <= 10; i++) {
            String id = Integer.toString(i);
            String name = "Student" + i;
            int age = random.nextInt(20, 31);
            Gender gender = (i % 2 == 0) ? Gender.M : Gender.F; // 짝수는 MALE, 홀수는 FEMALE
            LocalDateTime createdAt = LocalDateTime.now().minusDays(random.nextInt(365)); // 1년 이내 생성일
            Student student = new Student(id, name, gender, age, createdAt);

            studentRepository.save(student); // 저장
        }

        // StudentRepository를 애플리케이션 스코프에 저장
        context.setAttribute("studentRepository", studentRepository);
        System.out.println("StudentRepository 초기화 및 저장 완료.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 애플리케이션 종료 시 리소스 정리 등 필요한 작업 수행 가능
        System.out.println("애플리케이션 종료.");
    }
}
