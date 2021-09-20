package de.neuefische.studentserver.repo;

import de.neuefische.studentserver.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepo {

    List<Student> students = new ArrayList<>();

    public List<Student> list(){
        return students;
    }




}
