package de.neuefische.studentserver.service;

import de.neuefische.studentserver.model.Student;
import de.neuefische.studentserver.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> list() {
        return studentRepo.list();
    }

    public Student add(Student student) {
        return studentRepo.add(student);
    }


    public Student getById(int id) {
        Optional<Student> student = studentRepo.getById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new IllegalArgumentException("ID not found");
        }
    }

    public void deleteStudent(int id) {
        studentRepo.delete(id);
    }

    public List<Student> getStudentByName(String search) {
        return studentRepo.getByName(search);
    }
}
