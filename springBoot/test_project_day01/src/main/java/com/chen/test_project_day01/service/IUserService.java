package com.chen.test_project_day01.service;

import com.chen.test_project_day01.common.DefaultMsg;
import com.chen.test_project_day01.common.PageModel;
import com.chen.test_project_day01.entity.Module;
import com.chen.test_project_day01.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户管理service接口
 */
public interface IUserService {
    /**
     * 根据名字查询用户
     * @param uname
     * @return
     */
    public User findByUname(String uname);

    /**
     * 根据用户名和密码查询用户
     * @param user
     * @return
     */
    public User findByUnameAndPwd(User user);
    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int save(User user);

    /**
     * 添加用户角色
     * @param uid
     * @param rid
     * @return
     */
    public Integer saveUserRole(Integer uid,Integer rid);
    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    public User findById(Integer uid);
    /**
     * 删除用户角色
     * @param uid
     * @return
     */
    public Integer deleteUserRole(Integer uid);
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public int update(User user);
    /**
     * 删除用户信息
     * @param uid
     * @return
     */
    public DefaultMsg delete(Integer uid);
    /**
     * 查询所有用户信息
     * @return
     */
    public PageModel<User> listAll(PageModel<User> pm);

    /**
     * 查询用户对应的菜单
     * @param user
     * @return
     */
    public List<Module> findModOfUser(@Param("user") User user);


}
