package com.tt.teach2.service.impl;

import com.tt.teach2.dao.SubjectDao;
import com.tt.teach2.pojo.Subject;
import com.tt.teach2.service.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Resource
    private SubjectDao subjectDao;

    public List<Subject> getSubject() {
        return subjectDao.getSubject();
    }

    @Transactional
    public int deleteSubject(Integer subjectNo) {
        return subjectDao.deleteSubject(subjectNo);
    }

    @Transactional
    public int updateSubject(Subject subject) {
        return subjectDao.updateSubject(subject);
    }

    @Transactional
    public int addSubject(Subject subject) {
        return subjectDao.addSubject(subject);
    }

    public List<Subject> getGrade() {
        return subjectDao.getGrade();
    }
}
