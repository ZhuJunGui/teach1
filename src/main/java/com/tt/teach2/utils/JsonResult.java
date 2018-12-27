package com.tt.teach2.utils;

import java.util.Date;

public class JsonResult {
    //响应状态码
    private Integer status;
    //相应信息
    private String msg;
    //相应数据
    private Object myData;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getMyData() {
        return myData;
    }

    public void setMyData(Object myData) {
        this.myData = myData;
    }

    public JsonResult(Integer status, String msg, Object myData) {
        this.status = status;
        this.msg = msg;
        this.myData = myData;
    }

    public JsonResult() {
    }

    //成功以后调用OK
    public static JsonResult ok(String msg, Object myData) {
        return new JsonResult(200, msg, myData);
    }

    //失败的时候调用no
    public static JsonResult no(String msg, Object myData) {
        return new JsonResult(502, msg, myData);
    }
}
