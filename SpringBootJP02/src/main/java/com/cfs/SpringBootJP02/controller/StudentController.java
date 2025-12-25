package com.cfs.SpringBootJP02.controller;

import com.cfs.SpringBootJP02.entity.StudentEntity;
import com.cfs.SpringBootJP02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService  studentService;

    // Constructor Injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // POST → Create
    @PostMapping
    public StudentEntity addStudent(@RequestBody StudentEntity studentEntity) {
        // JSON -> JAVA Object
        return studentService.createStudent(studentEntity);
    }

    // GET → Read
    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return  studentService.getAllStudents();
    }

    // PUT → Full Update
    @PutMapping("/{id}")
    public StudentEntity updateStudent(@PathVariable Long id, @RequestBody StudentEntity studentEntity) {
        return studentService.updateStudent(id,studentEntity);
    }

    // PATCH → Partial Update
    @PatchMapping("/{id}")
    public StudentEntity updateName(@PathVariable Long id,  @RequestBody Map<String, String> payload) {
        return studentService.updateName(id, payload.get("name"));
    }


    // GET -> get 1 student
    @GetMapping("/{id}")
    public StudentEntity getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // DELETE -> delete 1 student
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }
}
