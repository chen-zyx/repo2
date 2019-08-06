package com.chen.test_project_day01.dao;

import com.chen.test_project_day01.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色管理dao接口
 */
@Mapper
@Repository
public interface IRoleDao {

    /**
     * 查询所有角色
     * @return
     */
    public List<Role> listAll();

}
