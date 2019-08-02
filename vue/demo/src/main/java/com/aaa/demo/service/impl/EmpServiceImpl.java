package com.aaa.demo.service.impl;


import com.aaa.demo.dao.IEmpDao;
import com.aaa.demo.entity.Emp;
import com.aaa.demo.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private IEmpDao iEmpDao;

    @Override
    public List<Emp> findAll() {
        return iEmpDao.findAll();
    }

    @Override
    public Emp findByEmpno(Integer empno) {
        return iEmpDao.findByEmpno(empno);
    }

    @Override
    public int updateEmp(Emp emp) {
        return iEmpDao.updateEmp(emp);
    }
}
