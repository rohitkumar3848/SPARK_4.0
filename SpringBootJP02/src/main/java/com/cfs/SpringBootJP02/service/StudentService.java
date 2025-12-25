package com.cfs.SpringBootJP02.service;

import com.cfs.SpringBootJP02.entity.StudentEntity;
import com.cfs.SpringBootJP02.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service = Business Logic Layer
@Service
public class StudentService {

    private final StudentRepo studentRepo;

    // Constructor Injection (Best Practice)
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo=studentRepo;
    }

    // Create student
    public StudentEntity  createStudent(StudentEntity studentEntity){
        // save() → INSERT / UPDATE
        return studentRepo.save(studentEntity);
    }

    // Get all students
    public List<StudentEntity> getAllStudents(){
        return studentRepo.findAll();
    }

    //find by id
    public StudentEntity getStudentById(Long id){
        return studentRepo.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
    }

    //delete student
    public void deleteStudentById(Long id){
        if(!studentRepo.existsById(id)){
            throw new RuntimeException("Student not found");
        }
        studentRepo.deleteById(id);
    }

    //updateStudent
    public StudentEntity updateStudent(Long id,StudentEntity studentEntity){
        //check user exist or not
        StudentEntity student=studentRepo.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
        student.setName(studentEntity.getName());
        student.setEmail(studentEntity.getEmail());
        return studentRepo.save(student);
    }

    // Partial update (PATCH)
    public StudentEntity updateName(Long id,String name){
        //check user exist or not
        StudentEntity student=studentRepo.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
        student.setName(name);
        return studentRepo.save(student);
    }

}
