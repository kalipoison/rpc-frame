package com.gohb;

import com.gohb.rpc.api.HelloService;
import com.gohb.rpc.netty.server.NettyServer;
import com.gohb.rpc.registry.DefaultServiceRegistry;
import com.gohb.rpc.registry.ServiceRegistry;

/**
 * ������Netty�����ṩ�ߣ�����ˣ�
 */
public class NettyTestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry registry = new DefaultServiceRegistry();
        registry.register(helloService);
        NettyServer server = new NettyServer();
        server.start(9999);
    }

}