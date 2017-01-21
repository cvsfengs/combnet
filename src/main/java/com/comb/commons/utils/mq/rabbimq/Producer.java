package com.comb.commons.utils.mq.rabbimq;

import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.lang.SerializationUtils;
/**
 * Created by Administrator on 2016/9/16.
 */
public class Producer extends EndPoint{

    public Producer(String endPointName) throws IOException{
        super(endPointName);
    }

    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",endPointName, null, SerializationUtils.serialize(object));
    }
}
