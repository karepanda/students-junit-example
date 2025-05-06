package org.application.rest.studentsjunitexample;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    public void getStudentsTest(){
        StudentService studentService = new StudentService();

        List<Student> listOfStudents = studentService.getStudents();

        boolean actualResult = listOfStudents.isEmpty();

        assertTrue(actualResult);
        assertTrue(()-> actualResult);
        assertTrue(actualResult, "The list of students should be empty");
    }

    @Test
    public void addStudentTest(){
        StudentService studentService = new StudentService();
        Student student = new Student(1, "John Doe");

        studentService.addStudent(student);

        List<Student> listOfStudents = studentService.getStudents();

        boolean actualResult = listOfStudents.contains(student);

        assertTrue(actualResult);
    }

    @Test
    public void getStudentByIdTest(){
        StudentService studentService = new StudentService();
        Student student = new Student(1, "John Doe");

        studentService.addStudent(student);

        int actualResult = student.getId();

        assertEquals(1, actualResult);
    }

    @Test
    public void getStudentByNameTest(){
        StudentService studentService = new StudentService();
        Student student = new Student(1, "John Doe");

        studentService.addStudent(student);

        String actualResult = student.getName();

        assertEquals(student.getName(), actualResult);
    }

}