package com.chen.test_project_day01.common;

/**
 * 用Ajax封装返回的信息
 */
public class DefaultMsg {
    //返回请求成功的信息
    private Integer success=1;
    //返回请求失败的信息
    private String error;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
