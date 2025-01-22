package com.nhnacademy.study;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhnacademy.study.student.Student;
import com.nhnacademy.study.student.StudentRepository;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.lang.invoke.ConstantCallSite;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JsonStudentRepository implements StudentRepository {
    private final ObjectMapper objectMapper;
    private List<Student> students = new ArrayList<>(); // students 변수 선언 및 초기화
    //json 저장 경로
    private static final String JSON_FILE_PATH="/home/nhnacademy/Desktop/bootcamp/web/serveletStudy/day1-7/day03/src/main/java/com/nhnacademy/study/json/student.json";

    public JsonStudentRepository() {
        this.objectMapper = new ObjectMapper();
        //LocalDatetime json 직렬화/역직렬화 가능하도록 설정
        objectMapper.registerModule(new JavaTimeModule());
        log.error("나 실행됐어~");
        //JSON_FILE_PATH 경로에 json 파일이 존재하면 삭제합니다.
//        Path path = Paths.get(JSON_FILE_PATH);
        File file = new File(JSON_FILE_PATH);
        if(file.exists()){
            file.delete();
            log.info("기존 JSON 파일이 삭제되었습니다." + JSON_FILE_PATH);
        }

    }

    // 역직렬화로 파일 읽어오기
    private synchronized List<Student> readJsonFile(){
        //todo json 파일이 존재하지 않다면 비어있는 List<Student> 리턴
        Path path = Paths.get(JSON_FILE_PATH);
        if(Files.notExists(path)){
            return new ArrayList<>();
        }
        File file = new File(JSON_FILE_PATH);

        //json read & 역직렬화 (json string -> object)
        try(FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ){
            students = objectMapper.readValue(bufferedReader, new TypeReference<List<Student>>() {});
            return students;
        } catch(JsonProcessingException e){
            throw new RuntimeException(e);
        } catch(IOException e){
            throw new RuntimeException(e);
        }

    }

    // 직렬화
    private synchronized void writeJsonFile(List<Student> studentList){
        // List<Student> 객체를 -> json 파일로 저장 : 직렬화
        File file = new File(JSON_FILE_PATH);

        try(
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            objectMapper.writeValue(bufferedWriter,studentList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Student student) {
        //json String -> Object 형태로 변화 (직렬화)
        List<Student> students = readJsonFile();
        //List에 student 추가
        students.add(student);
        //List<Student>객체를 -> json String 형태로 저장(직렬화)
        writeJsonFile(students);
    }

    @Override
    public void update(Student student) {
        List<Student> students = readJsonFile();
        boolean isUpdated = false;

        // 기존 학생 정보를 수정
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(student.getId())) {
                students.set(i, student);
                isUpdated = true;
                break;
            }
        }

        if (!isUpdated) {
            throw new IllegalArgumentException("해당 ID를 가진 학생이 존재하지 않습니다: " + student.getId());
        }

        // 업데이트된 데이터를 다시 파일에 저장
        writeJsonFile(students);
    }

    @Override
    public void deleteById(String id) {
        List<Student> students = readJsonFile();

        // ID로 학생 삭제
        boolean isDeleted = students.removeIf(student -> student.getId().equals(id));

        if (!isDeleted) {
            throw new IllegalArgumentException("해당 ID를 가진 학생이 존재하지 않습니다: " + id);
        }

        // 삭제 후 데이터를 다시 파일에 저장
        writeJsonFile(students);
    }

    @Override
    public Student getStudentById(String id) {
        List<Student> students = readJsonFile();

        // ID로 학생 검색
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null); // 찾지 못하면 null 반환
    }

    @Override
    public List<Student> getStudents() {
        // 모든 학생 목록 반환
        return readJsonFile();
    }

    @Override
    public boolean existById(String id) {
        List<Student> students = readJsonFile();

        // ID로 학생 존재 여부 확인
        return students.stream()
                .anyMatch(student -> student.getId().equals(id));
    }

}
