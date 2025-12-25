package com.cfs.SpringBootJP02.repo;

import com.cfs.SpringBootJP02.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository = Data Access Layer
// JpaRepository<StudentEntity, Long> ka matlab:
// Student → Entity
// Long → Primary key type
@Repository
public interface StudentRepo extends JpaRepository<StudentEntity,Long> {

    // humne kuch bhi method nahi likha
    // Fir bhi ye methods mil jaate hain:
    // save(), findById(), findAll(), deleteById()
}
