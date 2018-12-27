package com.tt.teach2.service.impl;

import com.tt.teach2.dao.StudentDao;
import com.tt.teach2.pojo.Student;
import com.tt.teach2.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @作者：zhujungui
 * @时间：2018/12/25 9:20
 * @描述：业务逻辑层——业务逻辑层不会去找数局访问层
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public Student doLogin(Student student) {
        return studentDao.doLogin(student);
    }

    @Override
    public List<Student> getStudentList() {
        return studentDao.getStudentList();
    }

    @Transactional
    public int deleteStudent(Integer stuNo) {
        return studentDao.deleteStudent(stuNo);
    }

    @Transactional
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }
}
