package com.tt.teach2.dao;

import com.tt.teach2.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @作者：zhujungui
 * @时间：2018/12/25 9:21
 * @描述：数据访问层的接口
 */
@Mapper
@Repository
public interface StudentDao {
    @Select("select * from student where studentNo=#{studentNo} and loginPwd=#{loginPwd}")
    Student doLogin(Student student);

    @Select("select student.*,grade.gradeName AS gradeName from student,grade where student.gradeId = grade.gradeId")
    List<Student> getStudentList();

    @Delete("delete  from student where studentNo=#{stuNo}")
    int deleteStudent(Integer stuNo);
    @Update("update student set loginPwd=#{loginPwd},studentName=#{studentName},phone=#{phone} where studentNo=#{studentNo}")
    int updateStudent(Student student);
}
