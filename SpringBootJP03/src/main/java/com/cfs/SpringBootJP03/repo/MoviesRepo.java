package com.cfs.SpringBootJP03.repo;

import com.cfs.SpringBootJP03.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

// @Repository = Data Access Layer
// JpaRepository<StudentEntity, Long> ka matlab:
// Student → Entity
// Long → Primary key type
@Repository
public interface MoviesRepo extends JpaRepository<Movies,Long> {
    // humne kuch bhi method nahi likha
    // Fir bhi ye methods mil jaate hain:
    // save(), findById(), findAll(), deleteById()
    List<Movies> findByDueDateBefore(Date dueDate);
}
