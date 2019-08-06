package com.chen.test_project_day01.service.impl;

import com.chen.test_project_day01.common.DefaultMsg;
import com.chen.test_project_day01.common.PageModel;
import com.chen.test_project_day01.dao.IUserDao;
import com.chen.test_project_day01.entity.Module;
import com.chen.test_project_day01.entity.User;
import com.chen.test_project_day01.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    @Override
    public User findByUname(String uname) {
        return iUserDao.findByUname(uname);
    }

    @Override
    public User findByUnameAndPwd(User user) {
        return iUserDao.findByUnameAndPwd(user);
    }

    @Override
    public int save(User user) {
        return iUserDao.save(user);
    }

    @Override
    public Integer saveUserRole(Integer uid,Integer rid) {
        return iUserDao.saveUserRole(uid,rid);
    }

    @Override
    public Integer deleteUserRole(Integer uid) {
        return iUserDao.deleteUserRole(uid);
    }

    @Override
    public int update(User user) {
        return iUserDao.update(user);
    }

    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    public User findById(Integer uid){
        return iUserDao.findById(uid);
    }

    @Override
    public DefaultMsg delete(Integer uid) {
        DefaultMsg dm = new DefaultMsg();
        int i = iUserDao.delete(uid);
        if(i==1){
            dm.setSuccess(1);
        }else{
            dm.setSuccess(0);
            dm.setError("删除失败");
        }
        return dm;
    }

    @Override
    public PageModel<User> listAll(PageModel<User> pm) {
        //先查询总记录数
        pm.setTotal(iUserDao.getCount(pm));
        //再查询每页数据
        pm.setRows(iUserDao.listAll(pm));
        return pm;
    }

    /**
     * 获取用户菜单
     * @param user
     * @return
     */
    @Override
    public List<Module> findModOfUser(User user) {
        List<Module> firstLevelMod = iUserDao.findFirstLevelMod(user);
        for (Module one:firstLevelMod
             ) {
            List<Module> secondLevelMod = iUserDao.findSecondLevelMod(user, one);
            one.setChildren(secondLevelMod);
        }
        return firstLevelMod;
    }


}
