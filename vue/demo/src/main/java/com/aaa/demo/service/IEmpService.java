package com.aaa.demo.service;

import com.aaa.demo.entity.Emp;
import org.apache.ibatis.annotations.Update;

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
    /**
     * 根据员工编号查询员工信息
     * @return
     */
    public Emp findByEmpno(Integer empno);

    /**
     * 修改员工信息
     * @return
     */
    public int updateEmp(Emp emp);


}
