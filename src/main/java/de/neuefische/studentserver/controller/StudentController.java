package de.neuefische.studentserver.controller;

import de.neuefische.studentserver.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("student")
public class StudentController {

    @GetMapping
    public List<Student> getStudents() {
        List<Student> students = List.of(
                new Student(1, "Tim Burton"),
                new Student(2, "Lisa Jones")
        );
        return students;

    }


}
