package com.chen.test_project_day01.service.impl;

import com.chen.test_project_day01.dao.IRoleDao;
import com.chen.test_project_day01.entity.Role;
import com.chen.test_project_day01.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao iRoleDao;
    @Override
    public List<Role> listAll() {
        return iRoleDao.listAll();
    }
}
