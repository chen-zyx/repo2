package com.chen.test_project_day01.controller;

import com.chen.test_project_day01.common.DefaultMsg;
import com.chen.test_project_day01.common.PageModel;
import com.chen.test_project_day01.entity.Role;
import com.chen.test_project_day01.entity.User;
import com.chen.test_project_day01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    public static final String HEAD_IMG_DIR="D:\\Idea\\IdeaProject\\springBoot\\day01img\\";
    /**
     * 加载用户信息显示页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/show")
    public String show(Model model) {
        return "user/show";
    }

    /**
     * 查询所用户信息，并返回到前台页面
     *
     * @return
     */
    @RequestMapping("/getUsers")
    @ResponseBody
    public PageModel<User> getUsers(@RequestBody PageModel<User> pm) {
        //System.out.println(pm.getCurrentPage()+"当前页面");
        pm= iUserService.listAll(pm);
        return pm;
    }

    /**
     * 接受用户保存的数据,
     */
    @RequestMapping("/saveUpdate")
    @ResponseBody
    public DefaultMsg saveUpdate(@RequestBody User user) {
        DefaultMsg dm = new DefaultMsg();
        Integer count=0;
        if(user.getUid()==null){
            //新增用户
            User user1 = iUserService.findByUname(user.getUname());
            if (user1 == null) {
                count = iUserService.save(user);
                //保存用户角色
                for (Role r:user.getRoleList()) {
                   // System.out.println(r.getRname()+"角色名称");
                    iUserService.saveUserRole(user.getUid(),r.getRid());
                }
            }else{
                dm.setSuccess(0);
                dm.setError("用户名已存在!");
            }
        }else{
            //先删除用户所有角色
            iUserService.deleteUserRole(user.getUid());
            //添加修改后的角色
            for (Role r:user.getRoleList()) {
                // System.out.println(r.getRname()+"角色名称");
                iUserService.saveUserRole(user.getUid(),r.getRid());
            }
            //修改用户信息
            count = iUserService.update(user);
        }
        if (count == 1) {
            dm.setSuccess(1);
        } else {
            dm.setSuccess(0);
            dm.setError("操作失败!");
        }
        return dm;
    }

    /**
     * 删除用户信息
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public DefaultMsg deleteUser(Integer uid){
        System.out.println(uid+"用户编号");
        iUserService.deleteUserRole(uid);
        DefaultMsg dm  = iUserService.delete(uid);
        return dm;
    }

    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file){
        //获取文件真实姓名
        String realName=file.getOriginalFilename();
        System.out.println(realName+"真实姓名");

        //将file临时文件存储到本地
        String dir=HEAD_IMG_DIR;
        //生成保存文件名
        String saveName= UUID.randomUUID().toString();
        try {
            file.transferTo(new File(dir+saveName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return saveName;
    }

    //下载文件
    @RequestMapping("/downLoad")
    public String downLoad(Integer uid, HttpServletResponse response){
        //获取要下载的路径
        User user = iUserService.findById(uid);
        String downloadFilePath = HEAD_IMG_DIR + user.getHeadimg();//被下载的文件在服务器中的路径,
        String fileName = user.getHeadimg();//被下载文件的名称

        File file = new File(downloadFilePath);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }

}
