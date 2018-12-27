package com.tt.teach2.controller;

import com.tt.teach2.pojo.Result;
import com.tt.teach2.pojo.Subject;
import com.tt.teach2.service.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @作者：zhujungui
 * @时间：2018/12/26 14:45
 * @描述：成绩——控制器
 */
@Controller
@RequestMapping("/res")
public class ResultController {
    @Resource
    private ResultService resultService;

    //成绩表的请求
    @RequestMapping("/result")
    public String result(Model model) {
        List<Subject> list = resultService.getSubject();
        model.addAttribute("subjectList", list);
        return "/result/result";
    }

    //查询全部成绩的请求

    @GetMapping("/getResultList")
    public @ResponseBody
    Object getResultList() {
        List<Result> list = resultService.getResultList();
        return list;
    }
}
