package com.chen.test_project_day01.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private Integer uid;
    private String uname;
    private String upasswd;
    private Integer uage;
    private String uaddr;
    private String headimg;
    private List<Role> roleList;

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpasswd() {
        return upasswd;
    }

    public void setUpasswd(String upasswd) {
        this.upasswd = upasswd;
    }

    public Integer getUage() {
        return uage;
    }

    public void setUage(Integer uage) {
        this.uage = uage;
    }

    public String getUaddr() {
        return uaddr;
    }

    public void setUaddr(String uaddr) {
        this.uaddr = uaddr;
    }
}
