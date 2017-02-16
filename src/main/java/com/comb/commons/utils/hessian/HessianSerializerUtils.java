package com.comb.commons.utils.hessian;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.caucho.hessian.io.AbstractHessianInput;
import com.caucho.hessian.io.AbstractHessianOutput;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.SerializerFactory;
/**
 * Created by ycfeng on 2016/10/25.
 */
public class HessianSerializerUtils /*extends HessianServlet*/ {

//    public static void main(String[] args) {
//        String[] a = new String[]{"a","b"};
//        byte[] serialize = SerializeUtil.serialize(a);
//        System.out.println(serialize);
//        String[] o = (String[])SerializeUtil.unSerialize(serialize);
//        System.out.println(o[1]);
//    }


    //缓存各个项目的classloader 对应的序列化工厂
    private static final ConcurrentHashMap<ClassLoader, SerializerFactory> serialFactory = new ConcurrentHashMap<ClassLoader, SerializerFactory>();

    private static final Logger LOG = LogManager.getLogger(HessianSerializerUtils.class);

    private HessianSerializerUtils() {

    }

    /**
     * 序列化方法
     * @param obj
     * @return
     */
    public static byte[] serialize(Object obj) {

        ByteArrayOutputStream ops = new ByteArrayOutputStream();
        AbstractHessianOutput out = new Hessian2Output(ops);

        out.setSerializerFactory(getSerializerFactory());
        try {
            out.writeObject(obj);
            out.close();
        } catch (IOException e) {
            LOG.error("hessian序列化失败", e);
            throw new RuntimeException(e);
        }

        byte[] bytes = ops.toByteArray();
        return bytes;
    }

    /**
     * 反序列化方法
     * @param bytes
     * @return
     */
    public static Object deserialize(byte[] bytes) {
        ByteArrayInputStream ips = new ByteArrayInputStream(bytes);
        AbstractHessianInput in = new Hessian2Input(ips);

        in.setSerializerFactory(getSerializerFactory());
        Object value = null;
        try {
            value = in.readObject();
            in.close();
        } catch (IOException e) {
            LOG.error("hessian反序列化失败", e);
            throw new RuntimeException(e);
        }

        return value != null ? value : bytes;
    }

    /**
     * 获取 序列化工厂
     */
    private static SerializerFactory getSerializerFactory() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        SerializerFactory factory = serialFactory.get(loader);
        if (factory == null) {
            synchronized (HessianSerializerUtils.class) {
                factory = serialFactory.get(loader);
                if (factory == null) {
                    factory = new SerializerFactory();
                    serialFactory.put(loader, factory);
                    return factory;
                } else {
                    return factory;
                }
            }
        } else {
            return factory;
        }
    }

}
