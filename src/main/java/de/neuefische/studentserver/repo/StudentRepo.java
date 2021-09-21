package de.neuefische.studentserver.repo;

import de.neuefische.studentserver.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepo {

    List<Student> students = new ArrayList<>();

    public List<Student> list(){
        return students;
    }

public Student add(Student student){
        students.add(student);
        return student;
}


    public Student getById(int id) {
        for (Student student : students) {
            if(student.getId() == id){
                return student;
            }
        }

        throw new IllegalArgumentException("Student not found with id " + id);
    }

}
