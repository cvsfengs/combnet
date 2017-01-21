package com.comb.user.dao;

import com.comb.user.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/7/29.
 */
@Repository
public interface UserDao {
    /**
     * 传入一个用户对象,返回用户对象实例
     */
    User getUser (User user);

}
