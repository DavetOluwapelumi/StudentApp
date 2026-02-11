package com.student.StudentApp.services;

import com.student.StudentApp.models.Students;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Students> students = new ArrayList<>();

    public List<Students> getAllStudents() {
        return students;
    }

    public List<Students> addStudent(Students student) {
        students.add(student);
        return students;
    }

    public Students updateStudent(Long id, Students newStudent) {
        for (Students s : students) {
            if (s.getId().equals(id)) {
                s.setName(newStudent.getName());
                s.setCourse(newStudent.getCourse());
            }


        }

        return newStudent;
    }

    public void deleteStudent(Long id) {

                    students.removeIf(s -> s.getId().equals(id));


    }
}