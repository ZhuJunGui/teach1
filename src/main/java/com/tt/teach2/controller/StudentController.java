package com.tt.teach2.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.tt.teach2.pojo.Student;
import com.tt.teach2.service.StudentService;
import com.tt.teach2.utils.BaseController;
import com.tt.teach2.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.PrivateKey;
import java.util.List;

/**
 * @作者：zhujungui
 * @时间：2018/12/25 9:16
 * @描述：学生控制器
 */
@Controller
@RequestMapping("/stu")
public class StudentController extends BaseController {

    @Resource
    private StudentService studentService;

    //1.登录接口：
    @RequestMapping("/login")
    public String login() {
        return "/student/login";
    }

    @RequestMapping("/index")
    public String index() {
        String studentName = (String) getSession().getAttribute(SESSION_KEY);
        if (studentName != null) {
            return "/student/index";
        }
        return REDIRECT + "/stu/login";
    }

    @PostMapping("/doLogin")
    public String doLogin() {
        String xuehao = getRequest().getParameter("studentNo");
        Integer studentNo = Integer.parseInt(xuehao);
        String loginPwd = getRequest().getParameter("loginPwd");
        Student student = new Student();
        student.setStudentNo(studentNo);
        student.setLoginPwd(loginPwd);
        Student student1 = studentService.doLogin(student);
        if (student1 != null) {
            getSession().setAttribute(SESSION_KEY, student1.getStudentName());
            return FORWARd + "/stu/index";
        }
        return REDIRECT + "/stu/login";
    }

    //注销请求:http://localhost:8080/stu/logout
    @RequestMapping("/logout")
    public String logout() {
        getSession().removeAttribute(SESSION_KEY);
        return REDIRECT + "/stu/login";
    }

    //学生请求
    @RequestMapping("/student")
    public String student() {
        return "/student/student";
    }

    //查询全部学生信息
    @GetMapping("/getStudentList")
    public @ResponseBody
    Object getStudentList() {
        List<Student> list = studentService.getStudentList();
        return list;
    }

    //删除请求
    @DeleteMapping("/deleteStudent/{stuNo}")
    public @ResponseBody
    Object deleteStudent(@PathVariable Integer stuNo) {
        int result = studentService.deleteStudent(stuNo);
        if (result > 0) {
            return JsonResult.ok("删除成功！", result);
        }
        return JsonResult.no("删除失败！", result);
    }

    //编辑请求

    @PostMapping("/updateStudent")
    public String toString() {
        String xuehao = getRequest().getParameter("stuNo");
        Integer stuNo = Integer.parseInt(xuehao);
        String stuName = getRequest().getParameter("stuName");
        String stuPwd = getRequest().getParameter("stuPwd");
        String stuPhone = getRequest().getParameter("stuPhone");
        Student student=new Student();
        student.setStudentNo(stuNo);
        student.setStudentName(stuName);
        student.setLoginPwd(stuPwd);
        student.setPhone(stuPhone);
        int result =studentService.updateStudent(student);
        if (result>0){
            return FORWARd+"/stu/student";
        }
        return FORWARd+"/stu/student";
    }
}
