package com.cfs.SpringBoot04.repo;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepo {
    public String getStudentData(){
        return "--Hello Student method call--";
    }
}
