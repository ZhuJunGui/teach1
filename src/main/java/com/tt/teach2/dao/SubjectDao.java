package com.tt.teach2.dao;

import com.tt.teach2.pojo.Subject;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SubjectDao {
    @Select("SELECT subject.*,grade.gradeName AS gradeName FROM SUBJECT,grade WHERE subject.gradeID=grade.gradeID")
    List<Subject> getSubject();

    @Delete("delete from subject where subjectNo = #{subjectNo}")
    int deleteSubject(Integer subjectNo);

    @Update("update subject set classHour = #{classHour} where subjectNo = #{subjectNo}")
    int updateSubject(Subject subject);

    @Insert("insert into subject(subjectName,classHour,gradeID) values (#{subjectName},#{classHour},#{gradeID})")
    int addSubject(Subject subject);

    @Select("select * from grade")
    List<Subject> getGrade();
}
