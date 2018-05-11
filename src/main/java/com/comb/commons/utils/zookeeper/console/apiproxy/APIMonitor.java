package com.comb.commons.utils.zookeeper.console.apiproxy;

import com.comb.commons.utils.json.JsonUtil;
import com.comb.commons.utils.serialize.SerializeUtil;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.util.*;

/**
 */
@Controller
public class APIMonitor {

   // private ZooKeeper zk = ZooKeeperOperator.getConn().getOriginalZK();
    private final String base_path = "/u/aw/ais" ;
    private int i = 0 ;
    private int MAX_TRY = 10 ;//最大失败尝试次数
    private List<APIServerNode> apiServer = new ArrayList<APIServerNode>();
    private Map<String,TreeSet<String>> routeMenu = new HashMap<String, TreeSet<String>>();//路由表
    private Map<String,APIServerNode> versionIpMenu = new HashMap<String,APIServerNode>();//版本-ip
    private Map<String,TreeSet<String>> groupAndVersion = new HashMap<String, TreeSet<String>>();

    //public Map<String,List<APIServerNode>> menuValues = new HashMap<String, List<APIServerNode>>();//机器-apiList
    private static final Logger log = LoggerFactory.getLogger(APIMonitor.class);
    public APIMonitor() {
        reloadAndRegister();
    }
    private void reloadAndRegister(){
        ZooKeeper zooKeeper = ZooKeeperOperator.getConn().getOriginalZK();
        try {
            List<String> parentNodes = zooKeeper.getChildren(base_path, watcherNodes);//监听使用者增加或减少
            for (String child : parentNodes) {
                byte[] childData = zooKeeper.getData(base_path + "/" + child, null, null);
                String node = (String)SerializeUtil.unSerialize(childData);
                String[] split = child.split("-");
                String cid = split[0];
                String serverIp = split[1];
                String groupId = cid.substring(0,3);
                String version = cid.substring(3, 6);
                TreeSet<String> versions = groupAndVersion.get(groupId);
                if(versions==null){
                    versions = new TreeSet<String>();
                }
                versions.add(version);
                groupAndVersion.put(groupId,versions);
                TreeSet<String> vs = routeMenu.get(cid);
                if(vs==null){
                    vs = new TreeSet<String>();
                }
                APIServerNode apiServerNode = JsonUtil.jsonToObject(node, APIServerNode.class);
                vs.add(serverIp);
                routeMenu.put(cid,vs);
                versionIpMenu.put(serverIp,apiServerNode);
                log.error("加载api列表成功:node,"+child);
            }
            System.out.println("-=-=-=-=-=-=-=-="+ JsonUtil.objectToJson(routeMenu));
            System.out.println("````````````````"+ JsonUtil.objectToJson(versionIpMenu));
        } catch (Exception e) {
            log.error("加载api列表失败,第【"+i+"】次尝试");
            if(i<MAX_TRY){
                i++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                cleanRout();
                reloadAndRegister();// try again
            }
        }
        log.error("加载api列表刷新成功" + JsonUtil.objectToJson(apiServer));
    }
    private Watcher watcherNodes = new Watcher() {
        @Override
        public void process(WatchedEvent event) {
            if(event.getType().equals(Event.EventType.NodeChildrenChanged)){
                cleanRout();
                reloadAndRegister();
            }
        }
    };
    private void cleanRout(){
         getRouteMenu().clear();
         getVersionIpMenu().clear();
    }
    public Map<String, TreeSet<String>> getRouteMenu() {
        return routeMenu;
    }

    public Map<String, TreeSet<String>> getGroupAndVersion() {
        return groupAndVersion;
    }

    public Map<String, APIServerNode> getVersionIpMenu() {
        return versionIpMenu;
    }

}
