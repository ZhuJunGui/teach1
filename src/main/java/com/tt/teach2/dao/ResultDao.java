package com.tt.teach2.dao;

import com.tt.teach2.pojo.Result;
import com.tt.teach2.pojo.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @作者：zhujungui
 * @时间：2018/12/26 14:45
 * @描述：数据访问层接口
 */
@Repository
@Mapper
public interface ResultDao {
    @Select("select * from subject")
    List<Subject> getSubject();

    @Select("SELECT result.*,student.studentName AS  studentName,subject.subjectName AS subjectName FROM result,student,SUBJECT WHERE result.studentNo=student.studentNo AND  result.subjectNo=SUBJECT.subjectNo ORDER BY result.examDate DESC")
    List<Result> getResultList();
}
