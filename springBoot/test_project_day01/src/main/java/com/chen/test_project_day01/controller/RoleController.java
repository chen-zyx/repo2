package com.chen.test_project_day01.controller;

import com.chen.test_project_day01.entity.Role;
import com.chen.test_project_day01.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("/getRoles")
    @ResponseBody
    public List<Role> getRoles() {
        List<Role> roleList = iRoleService.listAll();
        return roleList;
    }


}
