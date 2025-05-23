package org.application.rest.studentsjunitexample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return this.students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(int id) {
        return students.stream()
                .filter((student) -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public String[] getStudentsNamesByDepartment(String department) {
        return students.stream()
                .filter((student) -> student.getDepartment().equals(department))
                .map(Student::getName)
                .toArray(String[]::new);
    }

    public Integer[] getStudentsIdsByDepartment(String department) {
        return students.stream()
                .filter((student) -> student.getDepartment().equals(department))
                .map(Student::getId)
                .toArray(Integer[]::new);
    }

    public List<String> getStudentsNamesListByDepartment(String department) {
        return students.stream()
                .filter((student) -> student.getDepartment().equals(department))
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    public List<Integer> getStudentsIdsListByDepartment(String department) {
        return students.stream()
                .filter((student) -> student.getDepartment().equals(department))
                .map(Student::getId)
                .collect(Collectors.toList());    }
}
