package com.chen.test_project_day01.entity;

import java.io.Serializable;
import java.util.List;

public class Place implements Serializable {
    private Integer p_id;
    private String name;
    private Integer province;
    private List<Place> children;

    public List<Place> getChildren() {
        return children;
    }

    public void setChildren(List<Place> children) {
        this.children = children;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }
}
