package com.gohb;

import com.gohb.rpc.api.HelloService;
import com.gohb.rpc.transport.netty.server.NettyServer;
import com.gohb.rpc.serializer.ProtobufSerializer;

/**
 * ������Netty�����ṩ�ߣ�����ˣ�
 */
public class NettyTestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl2();
        NettyServer server = new NettyServer("127.0.0.1", 9999);
        server.setSerializer(new ProtobufSerializer());
        server.publishService(helloService, HelloService.class);
    }

}
