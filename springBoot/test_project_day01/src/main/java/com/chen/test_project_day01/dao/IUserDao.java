package com.chen.test_project_day01.dao;

import com.chen.test_project_day01.common.PageModel;
import com.chen.test_project_day01.entity.Module;
import com.chen.test_project_day01.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户管理dao接口
 */
@Mapper
@Repository
public interface IUserDao {
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
    public Integer saveUserRole(@Param("uid") Integer uid,@Param("rid") Integer rid);

    /**
     * 删除用户角色
     * @param uid
     * @return
     */
    public Integer deleteUserRole(Integer uid);
    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    public User findById(Integer uid);
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
    public int delete(Integer uid);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> listAll(PageModel<User> pm);

    /**
     * 查询总记录数
     */
    public int getCount(PageModel<User> pm);

    /**
     * 查询用户对应的菜单
     * @param user
     * @return
     */
    public List<Module> findModOfUser(@Param("user") User user);

    /**
     * 查询用户一级菜单
     */
    public List<Module> findFirstLevelMod(@Param("user") User user);

    /**
     * 查询用户二级菜单
     */
    public List<Module> findSecondLevelMod(@Param("user") User user,@Param("parent") Module parent);

}
