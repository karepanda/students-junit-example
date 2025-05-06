package org.application.rest.studentsjunitexample;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return this.students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
