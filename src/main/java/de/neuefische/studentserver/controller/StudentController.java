package de.neuefische.studentserver.controller;

import de.neuefische.studentserver.model.Student;
import de.neuefische.studentserver.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("student")
public class StudentController {

    StudentService studentService = new StudentService();

    @GetMapping
    public List<Student> getStudents() {
                return studentService.list();

    }


}
