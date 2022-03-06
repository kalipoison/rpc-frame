package com.gohb;

import com.gohb.rpc.transport.RpcClient;
import com.gohb.rpc.transport.RpcClientProxy;
import com.gohb.rpc.api.HelloObject;
import com.gohb.rpc.api.HelloService;
import com.gohb.rpc.transport.netty.client.NettyClient;
import com.gohb.rpc.serializer.ProtobufSerializer;

/**
 * 测试用Netty消费者
 */
public class NettyTestClient {

    public static void main(String[] args) {
        RpcClient client = new NettyClient();
        client.setSerializer(new ProtobufSerializer());
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);

    }

}

