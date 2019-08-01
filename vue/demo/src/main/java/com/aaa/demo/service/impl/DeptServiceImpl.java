package com.aaa.demo.service.impl;

import com.aaa.demo.dao.IDeptDao;
import com.aaa.demo.entity.Dept;
import com.aaa.demo.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DeptServiceImpl implements IDeptService {
@Autowired
private IDeptDao iDeptDao;

    @Override
    public List<Dept> findAll() {
        return iDeptDao.findAll();
    }
}
