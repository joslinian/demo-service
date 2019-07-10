package com.startech.demo.service;

import com.startech.demo.persistence.Student;
import com.startech.demo.persistence.StudentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentPersistence persistence;

    public List<Student> getAllStudents() {
        return persistence.findAll();
    }

    public Student getStudentById(final Long id) {
        final Optional<Student> student = persistence.findById(id);
        return student.orElse(null);
    }

    public void save(final List<Student> students) {
        persistence.saveAll(students);
    }
}
