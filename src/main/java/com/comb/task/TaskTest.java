package com.comb.task;

import com.comb.base.service.BaseCityService;
import com.comb.commons.pojo.EasyUIRequestPagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ycfeng on 2016/8/10.
 */
@Component
public class TaskTest {
    /**
     * 定时器的任务方法不能有返回值（如果有返回值，spring初始化的时候会告诉你有个错误、需要设定一个proxytargetclass的某个值为true）
     */
    @Autowired
    private BaseCityService baseCityService ;
//http://lavasoft.blog.51cto.com/62575/181907/
//http://blog.csdn.net/cutesource/article/details/4965520
    //http://www.cnblogs.com/davidwang456/p/3878625.html
 //   @Scheduled(cron= QuartzCronExp.CRONTEST)   //每5秒执行一次
    public void myTest(){
        EasyUIRequestPagination requestPagination = new EasyUIRequestPagination();
        requestPagination.setRows(20);
        requestPagination.setRows(2);


        System.out.println("进入测试"+baseCityService.getBaseCity(requestPagination));
    }


}
