package com.comb.user.service.impl;

import com.comb.commons.utils.result.ResultEnum;
import com.comb.commons.utils.result.ResultObject;
import com.comb.user.dao.UserDao;
import com.comb.user.pojo.User;
import com.comb.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ycfeng on 2016/8/2.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private ResultObject resultObject;
    @Override
    public ResultObject getUser(User user) {
        User getUser = userDao.getUser(user);
        if(getUser==null){
            resultObject.setStatus(ResultEnum.ERROR.getStatus());
            resultObject.setMsg(ResultEnum.ERROR.getMsg());
            return resultObject ;
        }else {
            resultObject.setMsg(ResultEnum.SUCCESS.getMsg());
            resultObject.setStatus(ResultEnum.SUCCESS.getStatus());
            resultObject.setObj(getUser);
            return resultObject;
        }
    }

}
