package com.startech.demo.controller;

import com.startech.demo.persistence.Student;
import com.startech.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/all-students", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Student getStudentById(@RequestParam("id") final Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping(path = "/add-student", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void createStudentRecords(@RequestBody List<Student> students) {
        studentService.save(students);
    }
}
