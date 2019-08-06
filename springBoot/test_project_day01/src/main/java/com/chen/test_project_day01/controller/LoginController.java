package com.chen.test_project_day01.controller;

import com.chen.test_project_day01.common.DefaultMsg;
import com.chen.test_project_day01.entity.Module;
import com.chen.test_project_day01.entity.User;
import com.chen.test_project_day01.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private IUserService iUserService;

    /**
     * 跳转到登录界面
     * @return
     */
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }
    /**
     * 跳转到首页
     */
    @RequestMapping("toWelcome")
    public String toWelcome(){
        return "welcome";
    }

    /**
     * 进行登录判断
     * @param user
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public DefaultMsg login(@RequestBody User user){
        final DefaultMsg dm = new DefaultMsg();
        System.out.println("用户名"+user.getUname());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUname(), user.getUpasswd());
        try{
            subject.login(token);
        }catch (AuthenticationException a){
            a.printStackTrace();
            dm.setSuccess(0);
            dm.setError("用户名或密码错误!");
        }
        return dm;
       /* User user1 = iUserService.findByUnameAndPwd(user);
        if(user1!=null){
            System.out.println(user1.getUname()+"--"+user1.getUaddr());
            dm.setSuccess(1);
        }else{
            dm.setSuccess(0);
            dm.setError("用户名或密码错误!");
        }*/
    }
    /**
     * 跳转到主界面
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    /**
     * 跳转到权限不足
     */
    @RequestMapping("/toPermit")
    public String toPermit(){
        return "nopermit";
    }

    @RequestMapping("/getModules")
    @ResponseBody
    public List<Module> getModules(){
        User user= (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println(user);
        List<Module> moduleList = iUserService.findModOfUser(user);
       /* for (Module m:moduleList
             ) {
            System.out.println(m.getMname());
            List<Module> children = m.getChildren();
            for (Module c:children
                 ) {
                System.out.println(c.getMname()+"---");
            }
        }*/
        return moduleList;
    }

}
