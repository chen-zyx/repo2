package com.aaa.demo.controller;


import com.aaa.demo.entity.Dept;
import com.aaa.demo.entity.Emp;
import com.aaa.demo.service.IDeptService;
import com.aaa.demo.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 查询所有员工
     * @param
     * @return
     */
   @RequestMapping("/getEmp")
   @ResponseBody
    public List<Emp>  getEmp(){
        return iEmpService.findAll();
    }

    /**
     * 查询所有部门
     * @param
     * @return
     */
    @RequestMapping("/getDept")
    @ResponseBody
    public List<Dept> getDept(){
        return iDeptService.findAll();
    }


    public String toEdit(){
        return "edit";
    }

    /**
     * 根据id查询员工
     * @param empno
     * @return
     */
    @RequestMapping(value = "/getSingleEmp",method = RequestMethod.POST)
    @ResponseBody
    public Emp getSingleEmp(@Valid @RequestBody(required = false) Map empno){
        Integer empno1= (Integer) empno.get("empno");
       return iEmpService.findByEmpno(empno1);
    }

    /**
     * 修改员工信息
     */
    @RequestMapping("/getUpdateEmp")
    @ResponseBody
    public int getUpdateEmp(@RequestBody Emp emp){
        int i = iEmpService.updateEmp(emp);
        return i;
    }

    /**
     * 修改员工信息
     */
    @RequestMapping("/getDeleteEmp")
    @ResponseBody
    public int getDeleteEmp(@RequestBody Map empno){
        Integer empno1= (Integer) empno.get("empno");
        System.out.println("要删除的员工编号"+empno1);
        return 0;
    }


}
