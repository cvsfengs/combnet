package com.comb.commons.utils.zookeeper.console.apiproxy;

import org.apache.log4j.Logger;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 */
public class AbstractZooKeeper implements Watcher {

    protected Logger logger = Logger.getLogger(AbstractZooKeeper.class);
    protected ZooKeeper zooKeeper;
    protected CountDownLatch countDownLatch = new CountDownLatch(1);
    //连接zk集群
    public ZooKeeper connect(String hosts,int timeout) throws IOException, InterruptedException {
        zooKeeper = new ZooKeeper(hosts, timeout,this);
        countDownLatch.await();
        return zooKeeper;
    }
    //zk处理
    @Override
    public void process(WatchedEvent event) {
        if (event.getState() == KeeperState.SyncConnected) {

        }
        countDownLatch.countDown();
    }
    //关闭集群
    public void close() throws InterruptedException {
        zooKeeper.close();
    }
}
