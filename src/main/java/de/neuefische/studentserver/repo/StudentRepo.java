package de.neuefische.studentserver.repo;

import de.neuefische.studentserver.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void delete(int id) {
        Student student = getById(id);
        if (student == null) {
            return;
        }
        students.remove(student);
    }

    public List<Student> getByName(String search) {
        List<Student> studentsMatchingName = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equals(search)) {
                studentsMatchingName.add(student);
            }
        }
        return studentsMatchingName;

    }

}
