package com.tt.teach2.service;

import com.tt.teach2.pojo.Student;

import java.util.List;

public interface StudentService {
    Student doLogin(Student student);

    List<Student> getStudentList();

    int deleteStudent(Integer stuNo);

    int updateStudent(Student student);
}
