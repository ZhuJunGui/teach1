package com.tt.teach2.service.impl;

import com.tt.teach2.dao.ResultDao;
import com.tt.teach2.pojo.Result;
import com.tt.teach2.pojo.Subject;
import com.tt.teach2.service.ResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *@作者：zhujungui
 *@时间：2018/12/26 14:46
 *@描述：业务逻辑层
 */
@Service
public class ResultServiceImpl  implements ResultService{
    @Resource
    private ResultDao resultDao;

    @Override
    public List<Subject> getSubject() {
        return resultDao.getSubject();
    }

    @Override
    public List<Result> getResultList() {
        return resultDao.getResultList();
    }
}
