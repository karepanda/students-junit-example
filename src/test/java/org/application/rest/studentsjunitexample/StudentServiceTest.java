package org.application.rest.studentsjunitexample;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    public void getStudentsTest(){
        StudentService studentService = new StudentService();

        List<Student> listOfStudents = studentService.getStudents();

        boolean actualResult = listOfStudents.isEmpty();

        assertTrue(actualResult);
        //assertTrue(()-> actualResult);
        //assertTrue(actualResult, "The list of students should be empty");


    }

    @Test
    public void getStudentsTestUsingAssetFalse(){
        StudentService studentService = new StudentService();

        Student student = new Student(1, "John Doe",null);
        List<Student> listOfStudents = studentService.getStudents();
        studentService.addStudent(student);
        boolean actualResult = listOfStudents.isEmpty();

        //assertFalse(actualResult);
        //assertFalse(actualResult, "The list of students should not be empty");
        //assertFalse(()-> actualResult);
        //assertFalse(()-> actualResult, "The list of students should not be empty");
        //assertFalse(actualResult, () -> "The list of students should not be empty");
        assertFalse(() -> actualResult, () -> "The list of students should not be empty");
    }

    @Test
    public void addStudentTest(){
        StudentService studentService = new StudentService();
        Student student = new Student(1, "John Doe",null);

        studentService.addStudent(student);

        List<Student> listOfStudents = studentService.getStudents();

        boolean actualResult = listOfStudents.contains(student);

        assertTrue(actualResult);
    }

    @Test
    public void getStudentByIdTestAssertNull(){
        StudentService studentService = new StudentService();
        Student student = new Student(1, "John Doe",null);

        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(2);

        //assertNull(actualObject);
        //assertNull(actualObject, "The student should not be found");
        assertNull(actualObject, () -> "The student should not be found");
    }

    @Test
    void getStudentByIdTestAssertNotNull(){
        StudentService studentService = new StudentService();
        Student student = new Student(1, "John Doe",null);

        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(1);

        //assertNotNull(actualObject);
        //assertNotNull(actualObject, "The student should be found");
        assertNotNull(actualObject, () -> "The student should be found");
    }

    @Test
    public void getStudentByNameTest(){
        StudentService studentService = new StudentService();
        Student student = new Student(1, "John Doe",null);

        studentService.addStudent(student);

        Student actualResult = studentService.getStudentById(1);

        assertEquals(1, actualResult.getId());
        assertEquals("John Doe",actualResult.getName());

        assertEquals(student, actualResult);
        assertEquals(1, actualResult.getId(), "Student ID is not equal");
        assertEquals("John Doe", actualResult.getName(), () ->"Student name is not equal");
    }

    @Test
    public void getStudentByIdTestAssertNotEquals(){
        StudentService studentService = new StudentService();
        Student student = new Student(1, "John Doe",null);
        Student student1 = new Student(2, "Jane Doe",null);

        studentService.addStudent(student);
        studentService.addStudent(student1);


        Student actualResult = studentService.getStudentById(1);

        assertNotEquals(2, actualResult.getId());
        assertNotEquals("Jane Doe", actualResult.getName());

        assertNotEquals(2, actualResult.getId(), "Student ID is equal");
        assertNotEquals("Jane Doe", actualResult.getName(), () ->"Student name is equal");
        assertNotEquals(student1, actualResult);
    }

    @Test
    public void getStudentNameByDepartmentTestAssertArrayEquals(){
        StudentService studentService = new StudentService();
        Student student = new Student(1, "John Doe", "Science");
        Student student1 = new Student(2, "Jane Doe", "Science");
        Student student2 = new Student(3, "John Smith", "Art");

        studentService.addStudent(student);
        studentService.addStudent(student1);
        studentService.addStudent(student2);

        String[] actualResult = studentService.getStudentsNamesByDepartment("Science");
        String[] expectedResult = new String[]{"John Doe", "Jane Doe"};

        assertArrayEquals(expectedResult, actualResult);

        assertArrayEquals(expectedResult, actualResult, "The student names are not equal");
        assertArrayEquals(expectedResult, actualResult, () -> "The student names are not equal");

    }

    @Test
    public void getStudentIdByDepartmentTestAssertArrayEquals(){
        StudentService studentService = new StudentService();
        Student student = new Student(1, "John Doe", "Science");
        Student student1 = new Student(2, "Jane Doe", "Science");
        Student student2 = new Student(3, "John Smith", "Art");

        studentService.addStudent(student);
        studentService.addStudent(student1);
        studentService.addStudent(student2);

        Integer[] actualResult = studentService.getStudentsIdsByDepartment("Science");
        Integer[] expectedResult = new Integer[]{1, 2};

        assertArrayEquals(expectedResult, actualResult);

        assertArrayEquals(expectedResult, actualResult, "The student IDs are not equal");
        assertArrayEquals(expectedResult, actualResult, () -> "The student IDs are not equal");

    }

    @Test
    public void getStudentNameByDepartmentTestAssertList(){
        StudentService studentService = new StudentService();
        Student student = new Student(1, "John Doe", "Science");
        Student student1 = new Student(2, "Jane Doe", "Science");
        Student student2 = new Student(3, "John Smith", "Art");

        studentService.addStudent(student);
        studentService.addStudent(student1);
        studentService.addStudent(student2);

        List<String> actualResult = studentService.getStudentsNamesListByDepartment("Science");
        List<String> expectedResult = Arrays.asList("John Doe", "Jane Doe");

        //assertIterableEquals(expectedResult, actualResult);
        //assertIterableEquals(expectedResult, actualResult, "The student names are not equal");
        assertIterableEquals(expectedResult, actualResult, () -> "The student names are not equal");

    }

    @Test
    public void getStudentIdByDepartmentTestAssertList(){
        StudentService studentService = new StudentService();
        Student student = new Student(1, "John Doe", "Science");
        Student student1 = new Student(2, "Jane Doe", "Science");
        Student student2 = new Student(3, "John Smith", "Art");

        studentService.addStudent(student);
        studentService.addStudent(student1);
        studentService.addStudent(student2);

        List<Integer> actualResult = studentService.getStudentsIdsListByDepartment("Science");
        List<Integer> expectedResult = Arrays.asList(1, 2);

        //assertIterableEquals(expectedResult, actualResult);
        //assertIterableEquals(expectedResult, actualResult, "The student IDs are not equal");
        assertIterableEquals(expectedResult, actualResult, () -> "The student IDs are not equal");

    }

    @Test
    public void getStudentNameByDepartmentTestAssertThrows(){

        StudentService studentService = new StudentService();
        Student student = new Student(1, "John Doe", "Science");

        studentService.addStudent(student);

        assertThrows(StudentNotFoundException.class, () -> {
            studentService.getStudentByName("Non Existent");
        }, "Expected getStudentByName to throw, but it didn't");
    }
    @Test
    public void getStudentNameByDepartmentTestAssertThrowsExactly(){

        StudentService studentService = new StudentService();
        Student student = new Student(1, "John Doe", "Science");
        studentService.addStudent(student);

        assertThrowsExactly(StudentNotFoundException.class, () -> {
            studentService.getStudentByName("Umesh");
        });

    }


}