package de.neuefische.studentserver.service;

import de.neuefische.studentserver.model.Student;
import de.neuefische.studentserver.repo.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    @Test
    @DisplayName("list() should return all students")
    public void testList() {
        // given
        StudentRepo studentRepo = mock(StudentRepo.class);
        when(studentRepo.list()).thenReturn(
                List.of(
                        new Student(1, "Lara"),
                        new Student(2, "Tim"),
                        new Student(3, "Jennifer")
                )
        );
        StudentService studentService = new StudentService(studentRepo);

        // when
        List<Student> actual = studentService.list();

        // then
        List<Student> expected = List.of(
                new Student(1, "Lara"),
                new Student(2, "Tim"),
                new Student(3, "Jennifer")
        );
        Assertions.assertEquals(expected, actual);
        verify(studentRepo).list();
    }


    @Test
    @DisplayName("add(studentToAdd) should return studentToAdd")
    public void testAdd() {
        // given
        StudentRepo studentRepo = mock(StudentRepo.class);
        Student studentToAdd = new Student(4, "Samuel");
        when(studentRepo.add(studentToAdd)).thenReturn(
                studentToAdd);
        StudentService studentService = new StudentService(studentRepo);

        // when
        Student actual = studentService.add(studentToAdd);

        // then
        Assertions.assertEquals(studentToAdd, actual);
        //assertThat(actual, is(studentToAdd)); // alternative using hamcrest
        verify(studentRepo).add(studentToAdd);
    }


    @Test
    @DisplayName("getById should return student with matching id")
    public void testGetById() {
        // given
        StudentRepo studentRepo = mock(StudentRepo.class);
        int id = 3;
        Student studentWithMatchingId = new Student(3, "Jennifer");
        when(studentRepo.getById(id)).thenReturn(
                Optional.of(studentWithMatchingId));
        StudentService studentService = new StudentService(studentRepo);

        // when
        Student actual = studentService.getById(id);

        // then
        Assertions.assertEquals(studentWithMatchingId, actual);
        verify(studentRepo).getById(id);
    }


    @Test
    @DisplayName("getById of a non-existing id should throw an IllegalArgumentException")
    public void testGetByNonExistingId() {
        // given
        StudentRepo studentRepo = mock(StudentRepo.class);
        int id = 100;
        when(studentRepo.getById(id)).thenThrow(
                new IllegalArgumentException("Student not found with id " + id)
        );
        StudentService studentService = new StudentService(studentRepo);

        // when - then
        try {
            studentService.getById(id);
            fail("Exception not thrown!");
        } catch (Exception e) {
            Assertions.assertEquals("Student not found with id 100", e.getMessage());
        }
        verify(studentRepo).getById(id);
    }


    @Test
    @DisplayName("getByName should return student with matching name")
    public void testGetByName() {

    }
}
