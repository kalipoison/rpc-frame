package com.gohb;

import com.gohb.rpc.api.HelloService;
import com.gohb.rpc.registry.DefaultServiceRegistry;
import com.gohb.rpc.registry.ServiceRegistry;
import com.gohb.rpc.server.RpcServer;

/**
 * �����÷����ṩ��������ˣ�
 */
public class testServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry serviceRegistry = new DefaultServiceRegistry();
        serviceRegistry.register(helloService);
        RpcServer rpcServer = new RpcServer(serviceRegistry);
        rpcServer.start(9000);
    }

}
