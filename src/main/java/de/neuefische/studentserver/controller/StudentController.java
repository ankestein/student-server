package de.neuefische.studentserver.controller;

import de.neuefische.studentserver.model.Student;
import de.neuefische.studentserver.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("student")
public class StudentController {

    private StudentService studentService = new StudentService();

    @GetMapping
    public List<Student> getStudents() {
                return studentService.list();
    }

    @PutMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.add(student);
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getById(id);
    }



}
