package com.tt.teach2.pojo;

import java.io.Serializable;

/**
 * @作者：zhujungui
 * @时间：2018/12/25 9:08
 * @描述：实体类Grade——》对应数据库年级表
 */
public class Grade implements Serializable {
    private Integer gradeID;
    private String gradeName;

    public Integer getGradeID() {
        return gradeID;
    }

    public void setGradeID(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Grade() {
    }

    public Grade(Integer gradeID, String gradeName) {
        this.gradeID = gradeID;
        this.gradeName = gradeName;
    }
}
