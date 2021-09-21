package de.neuefische.studentserver.service;

import de.neuefische.studentserver.model.Student;
import de.neuefische.studentserver.repo.StudentRepo;

import java.util.List;

public class StudentService {

    private StudentRepo studentRepo = new StudentRepo();

    public List<Student> list() {
        return studentRepo.list();
    }

public Student add(Student student){
        return studentRepo.add(student);
}


    public Student getById(int id) {
        return studentRepo.getById(id);
    }
}
