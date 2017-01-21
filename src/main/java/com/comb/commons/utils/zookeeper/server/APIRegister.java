package com.comb.commons.utils.zookeeper.server;

import com.comb.commons.utils.json.JsonUtil;
import com.comb.commons.utils.serialize.SerializeUtil;
import com.comb.commons.utils.zookeeper.console.apiproxy.ZooKeeperOperator;
import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ycfeng on 2017/1/18.
 */
public class APIRegister /*extends MAPIServer*/{
    private static final String cid ="800701";//todo 此节点需要提前申请 version control
    private static final String basePath = "/combnet/apiNew/apis";
    private static final String ip ="127.0.0.1";
    private ZooKeeper zk = ZooKeeperOperator.getConn().getOriginalZK();
    /*private APIHandler handleChain;*/
    private static final Logger log = LoggerFactory.getLogger(APIRegister.class);
    public APIRegister() {
        /*handleChain = new FilterContainer();
        handleChain.prepend(new AdapterContainer(), new ServiceContainer());*/
        this.register();
    }
    public boolean register() {
        String registerPath = basePath +"/"+ cid+"-"+ip;
        zk.create(registerPath,getAllUrls(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,cb,registerPath);
        return true;
    }
    public byte[] getAllUrls(){//架构的
        byte[] nodes = new byte[0];
        try {
            //ServerNode node = super.getNode();//todo 获取了节点,可用spring mvc 获取
            Object node = new Object();
            String toString = JsonUtil.objectToJson(node);
            //todo 类未放入base先用string
            //APIServerNode copy = new APIServerNode();
            //BeanUtils.copyProperties(node,copy);
            //nodes = HessianSerializerUtils.serialize(copy);
            nodes = SerializeUtil.serialize(toString);
        } catch (Exception e) {
            log.error("hessian序列化失败！",e);
        }
        return nodes;
    }
    private AsyncCallback.StringCallback cb = new AsyncCallback.StringCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            System.out.println(rc+"--"+path + "--"+ctx.toString() + "--"+name);
            log.error("api节点加载完成,basePath:"+path+",");
            loadUrls(path);
        }
    };
    private void loadUrls(String path){
        byte[] data = new byte[0];
        try {
            data = zk.getData(path, null,null);
        } catch (Exception e) {
            log.error("加载api列表失败!", e);
        }
        //APIServerNode apiServerNode = (APIServerNode)HessianSerializerUtils.deserialize(data);
        String apiServerNode = (String)SerializeUtil.unSerialize(data);
        log.error("api启动成功:"+JsonUtil.formatJson(apiServerNode));
    }
}
