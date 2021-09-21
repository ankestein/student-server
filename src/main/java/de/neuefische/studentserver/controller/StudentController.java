package de.neuefische.studentserver.controller;

import de.neuefische.studentserver.model.Student;
import de.neuefische.studentserver.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("student")
public class StudentController {

    private StudentService studentService = new StudentService();

    /*
    @GetMapping
    public List<Student> getStudents() {
                return studentService.list();
    }
    */

    @PutMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.add(student);
    }


    @GetMapping("{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getById(id);
    }


    @GetMapping()
    public List<Student> listStudentByName(@RequestParam Optional<String> search) {
        if (search.isPresent()) {
            return studentService.getStudentByName(search.get());
        }
        return studentService.list();
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

}
