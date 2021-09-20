package de.neuefische.studentserver.service;

import de.neuefische.studentserver.model.Student;
import de.neuefische.studentserver.repo.StudentRepo;

import java.util.List;

public class StudentService {

    StudentRepo studentRepo = new StudentRepo();

    public List<Student> list() {
        return studentRepo.list();
    }




}
