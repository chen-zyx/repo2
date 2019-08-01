package com.aaa.demo.dao;

import com.aaa.demo.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 部门管理dao接口
 */
@Mapper
@Repository
public interface IDeptDao {

    /**
     * 查询所有部门
     * @return
     */
    @Select("select * from dept")
    public List<Dept> findAll();

    @Select("select * from dept where deptno=#{deptno}")
    public Dept findByID(Integer deptno);

}
