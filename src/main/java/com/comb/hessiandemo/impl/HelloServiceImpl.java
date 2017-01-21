package com.comb.hessiandemo.impl;

import com.comb.hessiandemo.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by ycfeng on 2016/10/25.
 */
@Service("com.xuser.hessiandemo.HelloService")
public class HelloServiceImpl implements HelloService {

    /* (non-Javadoc)
     * @see com.gsoft.geloin.service.HelloService#sayHello(java.lang.String)
     */
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name + "!");
    }

}
