package com.chen.test_project_day01.entity;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {
    private Integer rid;
    private String rname;
    private List<User> userList;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
