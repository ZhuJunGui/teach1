package com.tt.teach2.controller;

import com.tt.teach2.pojo.Subject;
import com.tt.teach2.service.SubjectService;
import com.tt.teach2.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/sub")
public class SubjectController {
    @Resource
    private SubjectService subjectService;

    //科目表的请求
    @RequestMapping("/subject")
    public String subject(Model model) {
        List<Subject> list = subjectService.getGrade();
        model.addAttribute("gradeList",list);
        return "/subject/subject";
    }

    //获取科目表所有信息的请求
    @RequestMapping(value = "/getSubject",method = RequestMethod.GET)
    @ResponseBody
    public Object getSubject() {
        List<Subject> list = subjectService.getSubject();
        return list;
    }
    //删除科目的方法
    @RequestMapping(value = "/deleteSubject/{subjectNo}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteSubject(@PathVariable Integer subjectNo) {
        int result = subjectService.deleteSubject(subjectNo);
        if (result>0){
            return JsonResult.ok("删除成功！",result);
        }
        return JsonResult.ok("删除失败！",result);
    }
    //修改小时数的方法updateSubject
    @RequestMapping(value = "/updateSubject",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateSubject(@RequestParam Integer subjectNo, @RequestParam Integer classHour) {
        Subject subject = new Subject();
        subject.setSubjectNo(subjectNo);
        subject.setClassHour(classHour);
        int result = subjectService.updateSubject(subject);
        if (result>0){
           return JsonResult.ok("修改成功！",result);
        }
        return JsonResult.no("修改失败！",result);
    }
    //添加课程的方法
    @RequestMapping(value = "/addSubject", method = RequestMethod.PUT)
    @ResponseBody
    public Object addSubject(@RequestParam String subjectName,@RequestParam Integer classHour,@RequestParam Integer gradeID) {
        Subject subject = new Subject();
        subject.setSubjectName(subjectName);
        subject.setClassHour(classHour);
        subject.setGradeID(gradeID);
        int result = subjectService.addSubject(subject);
        if (result>0){
            return JsonResult.ok("添加成功！",result);
        }
        return JsonResult.no("添加失败！",result);
    }
}
