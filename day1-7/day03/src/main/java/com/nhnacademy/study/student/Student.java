package com.nhnacademy.study.student;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Student implements Serializable {
    // 아이디
    private String id;
    // 이름
    private String name;
    // 성별
    private Gender gender;
    //나이
    private  int age;
    // 생성일
    private LocalDateTime createdAt;

    // 기본 생성자 (필수)
    public Student() {
    }

    // 모든 필드를 초기화하는 생성자 (선택 사항)
    public Student(String id, String name, Gender gender, int age, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.createdAt = createdAt;
    }

    // Getter 및 Setter 메서드
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // 추가: 객체 정보를 문자열로 반환 (디버깅용)
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", createdAt=" + createdAt +
                '}';
    }
}
