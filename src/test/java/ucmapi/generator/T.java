package ucmapi.generator;

import com.caucho.hessian.client.HessianProxyFactory;
import com.comb.hessiandemo.HelloService;

/**
 * Created by ycfeng on 2016/10/25.
 */
public class T {
    public static void main(String[] args) {
        try {
            String url = "http://localhost:8080/xcore/HelloService";
            HessianProxyFactory factory = new HessianProxyFactory();
            HelloService helloService = (HelloService) factory.create(
                    HelloService.class, url);
            helloService.sayHello("张三");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
