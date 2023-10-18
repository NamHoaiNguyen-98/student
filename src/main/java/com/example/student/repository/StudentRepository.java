package com.example.student.repository;

import com.example.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * FROM student s where s.name like %?%", nativeQuery = true)
    List<Student> searchByName(String name);
    @Query(value = "SELECT * FROM student s order by s.name desc ", nativeQuery = true)
    List<Student> sortByNameDesc();
    @Query(value = "SELECT * FROM student s order by s.name asc ", nativeQuery = true)
    List<Student> sortByNameAsc();
    @Query(value = "SELECT * FROM student s order by s.age desc ", nativeQuery = true)
    List<Student> sortByAgeDesc();
    @Query(value = "SELECT * FROM student s order by s.age asc ", nativeQuery = true)
    List<Student> sortByAgeAsc();



}
