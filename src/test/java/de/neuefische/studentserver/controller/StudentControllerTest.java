package de.neuefische.studentserver.controller;

import de.neuefische.studentserver.model.Student;
import de.neuefische.studentserver.repo.StudentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    StudentRepo studentRepo;

    @BeforeEach
    public void clearRepo() {
        studentRepo.clearRepo();
    }

    @Test
    public void testListStudents() {
        // given
        String url = "http://localhost:" + port + "/student";
        studentRepo.add(new Student(20, "Sammy Jones"));
        studentRepo.add(new Student(21, "Tilda Dunne"));

        // when
        ResponseEntity<Student[]> response = restTemplate.getForEntity(url, Student[].class);

        // then
        assertThat(response.getStatusCode(),is(HttpStatus.OK));
        assertThat(response.getBody(), arrayContainingInAnyOrder(
                new Student (20, "Sammy Jones"),
                new Student(21, "Tilda Dunne")
        ));
    }

    @Test
    public void testGetStudentByName() {
        // given
        String url = "http://localhost:" + port + "/student?search=Sammy";
        studentRepo.add(new Student(20, "Sammy"));
        studentRepo.add(new Student(21, "Tilda"));

        // when
        ResponseEntity<Student[]> response = restTemplate.getForEntity(url, Student[].class);

        // then
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), arrayContainingInAnyOrder(new Student(20, "Sammy")));
    }

    /*
    @Test
    public void testAddStudent() {
        // given
        String url = "http://localhost:" + port + "/student";

        // when
        ResponseEntity<Student[]> response = restTemplate.put(url, new Student(22, "Hannah Miller"));

        // then
        assertThat(response.getStatusCode(),is(HttpStatus.OK));
        assertThat(response.getBody(), arrayContainingInAnyOrder(
                new Student (22, "Hannah Miller")
        ));
    }

     */


/*
    @Test
    public void testDeleteStudent() {
        // given
        String url = "http://localhost:" + port + "/student/21";
        studentRepo.add(new Student(20, "Sammy"));
        studentRepo.add(new Student(21, "Tilda"));

        // when
        restTemplate.delete(url);

        // then
        assertThat(studentRepo.list(), List.of(new Student(20, "Sammy")));
        assertThat(studentRepo.getById(21), is(Optional.empty()));


    }


 */



}
