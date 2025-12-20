package com.cfs.SpringBoot04.service;

import com.cfs.SpringBoot04.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepo  studentRepo;

    public String getStudentData() {
        return studentRepo.getStudentData();
    }
}
