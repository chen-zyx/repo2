package com.aaa.demo.service;

import com.aaa.demo.entity.Dept;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IDeptService {

    /**
     * 查询所有部门
     * @return
     */
    public List<Dept> findAll();

}
