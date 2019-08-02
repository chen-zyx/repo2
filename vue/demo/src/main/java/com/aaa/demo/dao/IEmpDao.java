package com.aaa.demo.dao;

import com.aaa.demo.entity.Emp;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 员工管理dao接口
 */
@Mapper
@Repository
public interface IEmpDao {
    /**
     * 查询所有员工信息
     * @return
     */
    @Select("select * from emp e left join dept d on e.deptno=d.deptno")
    @Results({
            @Result(id = true,column = "empno",property = "empno"),
            @Result(column = "ename",property = "ename"),
            @Result(column = "sal",property = "sal"),
            @Result(column = "job",property = "job"),
            @Result(column = "deptno",property = "dept",one = @One(select = "com.aaa.demo.dao.IDeptDao.findByID",fetchType = FetchType.EAGER))
    })
    public List<Emp> findAll();

    /**
     * 根据员工编号查询员工信息
     * @return
     */
    @Select("select * from emp e left join dept d on e.deptno=d.deptno where e.empno=#{empno}")
    @Results({
            @Result(id = true,column = "empno",property = "empno"),
            @Result(column = "ename",property = "ename"),
            @Result(column = "sal",property = "sal"),
            @Result(column = "job",property = "job"),
            @Result(column = "deptno",property = "dept",one = @One(select = "com.aaa.demo.dao.IDeptDao.findByID",fetchType = FetchType.EAGER))
    })
    public Emp findByEmpno(Integer empno);

    /**
     * 修改员工信息
     * @return
     */
    @Update("update emp set ename=#{ename},job=#{job},sal=#{sal},deptno=#{deptno} where empno=#{empno}")
    public int updateEmp(Emp emp);

}
