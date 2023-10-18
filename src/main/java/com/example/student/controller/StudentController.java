package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping
    public ResponseEntity<Iterable<Student>> findAll() {
        Iterable<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findOne(@PathVariable("id") Long id) {
        Optional<Student> student = studentService.findOne(id);
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Student>> searchByName(@Param("name") String name) {
        List<Student> students = studentService.searchByName(name);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

}
