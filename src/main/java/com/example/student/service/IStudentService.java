package com.example.student.service;

import com.example.student.model.Student;

import java.util.List;

public interface IStudentService extends IGenerateService<Student> {
    List<Student> searchByName(String name);
    List<Student> sortByNameDesc();
    List<Student> sortByNameAcs();
    List<Student> sortByAgeDesc();
    List<Student> sortByAgeAcs();
}
