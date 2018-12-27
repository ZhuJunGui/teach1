package com.tt.teach2.service;

import com.tt.teach2.pojo.Result;
import com.tt.teach2.pojo.Subject;

import java.util.List;

public interface ResultService {
    List<Subject> getSubject();

    List<Result> getResultList();
}
