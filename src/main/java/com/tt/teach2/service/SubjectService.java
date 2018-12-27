package com.tt.teach2.service;

import com.tt.teach2.pojo.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getSubject();

    int deleteSubject(Integer subjectNo);

    int updateSubject(Subject subject);

    int addSubject(Subject subject);

    List<Subject> getGrade();
}
