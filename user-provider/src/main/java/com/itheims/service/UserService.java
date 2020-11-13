package com.itheims.service;

import com.itheims.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User findById(Integer id);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll();

    /**
     * 增加用户
     * @param user
     */
    public void add(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    public void deleteById(Integer id);

    /**
     * 修改用户信息
     * @param user
     */
    public void update(User user);

}
