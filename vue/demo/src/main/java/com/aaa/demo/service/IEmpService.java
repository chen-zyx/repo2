package com.aaa.demo.service;

import com.aaa.demo.entity.Emp;

import java.util.List;

/**
 * 员工管理service接口
 */
public interface IEmpService {

    /**
     * 查询所有员工信息
     * @return
     */
    public List<Emp> findAll();


}
