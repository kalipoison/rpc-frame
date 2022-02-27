package com.gohb;

import com.gohb.rpc.api.HelloService;
import com.gohb.rpc.server.RpcServer;

/**
 * �����÷����ṩ��������ˣ�
 */
public class testServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(helloService, 9000);
    }

}
