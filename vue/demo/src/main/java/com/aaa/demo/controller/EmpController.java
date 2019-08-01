package com.aaa.demo.controller;


import com.aaa.demo.entity.Dept;
import com.aaa.demo.entity.Emp;
import com.aaa.demo.service.IDeptService;
import com.aaa.demo.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmpController {
   @Autowired
    private IEmpService iEmpService;

   @Autowired
   private IDeptService iDeptService;

    @RequestMapping("/to")
    public String to(){
        return "demo1";
    }
    @RequestMapping("/to1")
    public String to1(){
        return "demo2";
    }

   @RequestMapping("/getEmp")
   @ResponseBody
    public List<Emp>  getEmp(){
        return iEmpService.findAll();
    }

    @RequestMapping("/getDept")
    @ResponseBody
    public List<Dept> getDept(){
        return iDeptService.findAll();
    }

}
