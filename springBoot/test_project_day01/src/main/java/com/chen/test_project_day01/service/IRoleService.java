package com.chen.test_project_day01.service;


import com.chen.test_project_day01.entity.Role;

import java.util.List;

/**
 * 角色管理的service接口
 */
public interface IRoleService {
    /**
     * 查询所有角色
     * @return
     */
    public List<Role> listAll();

}
