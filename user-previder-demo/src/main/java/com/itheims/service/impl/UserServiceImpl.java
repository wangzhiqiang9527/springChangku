package com.itheims.service.impl;

import com.itheims.dao.UserDao;
import com.itheims.pojo.User;
import com.itheims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id) {
        return userDao.findById(id).get();
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 增加用户
     *
     * @param user
     */
    @Override
    public void add(User user) {

    }

    /**
     * 根据id删除用户
     *
     * @param id
     */
    @Override
    public void deleteById(Integer id) {

    }

    /**
     * 修改用户信息
     *
     * @param user
     */
    @Override
    public void update(User user) {

    }
}
