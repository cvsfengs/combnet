package com.comb.commons.utils.zookeeper.console.apiproxy;

import com.comb.commons.utils.json.JsonUtil;
import org.apache.log4j.Logger;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * Created by ycfeng on 2017/1/18.
 */
public class ZooKeeperOperator<T> extends AbstractZooKeeper {

    private static Logger logger = Logger.getLogger(ZooKeeperOperator.class);
    private static final int DEFAULT_VERSION = -1;
    private static final String servers = "10.104.90.238:5181" ;
    private static final int timeout = 4000 ;
    public static ZooKeeperOperator getConn(){
        ZooKeeperOperator zkOperator = new ZooKeeperOperator();
        try {
            zkOperator.connect(servers, timeout);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return zkOperator;
    }
    private void ZooKeeperOperator(){}
    public ZooKeeper getOriginalZK(){
        return super.zooKeeper;
    }
    public void create(String path, byte[] data, CreateMode mode){
        try {
            this.zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, mode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create(String path, CreateMode createMode, T obj){
        this.create(path, JsonUtil.objectToJson(obj).getBytes(), createMode);
    }

    public void create(String path, byte[] data){
        try {
            this.zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create(String path, T obj){
        this.create(path, JsonUtil.objectToJson(obj).getBytes(), CreateMode.PERSISTENT);
    }
    /**
     * 获取子节点信息
     */
    public List<String> getChildren(String path){
        List<String> list = null;
        try {
            list = this.zooKeeper.getChildren(path, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list.isEmpty()) {
            logger.info(path + "中没有节点");
        } else {
            for (String child : list) {
                System.out.println("节点：" + child);
            }
        }
        return list;
    }
    public byte[] getData(String path){
        try {
            return this.zooKeeper.getData(path, true, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public byte[] getData(String path, Watcher watcher){
        try {
            return this.zooKeeper.getData(path, watcher, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public T getObject(String path, Class<T> clazz){
        return JsonUtil.jsonToObject(new String(this.getData(path)), clazz);
    }
    public boolean nodeExist(String path){
        try {
            if(this.zooKeeper.exists(path, null)==null){
                return false ;
            }
            return true ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false ;
    }
    @Deprecated
    public Stat setDate(String path, byte[] data, int version){
        try {
            return this.zooKeeper.setData(path, data, version);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Deprecated
    public Stat setDate(String path, byte[] data){
        try {
            return this.zooKeeper.setData(path, data, DEFAULT_VERSION);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Stat setDate(String path, Object data) {
        try {
            return this.zooKeeper.setData(path, JsonUtil.objectToJson(data).getBytes(), DEFAULT_VERSION);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteNode(final String path, int version){
        try {
            this.zooKeeper.delete(path, version);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void list(final String path, int version) {
        try {
            this.zooKeeper.getData(path, new Watcher() {
                @Override
                public void process(WatchedEvent event) {

                }
            }, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteNode(final String path){
        try {
            this.zooKeeper.delete(path, DEFAULT_VERSION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override//进行节点变更监听并不好
    public void process(WatchedEvent event) {
        super.process(event);
        System.out.println("[path:]" + event.getPath());
        System.out.println("[state:]" + event.getState() + ",value:" + event.getState().getIntValue());
        System.out.println("[type:]" + event.getType());
    }
}
