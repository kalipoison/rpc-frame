package com.gohb;

import com.gohb.rpc.api.HelloService;
import com.gohb.rpc.server.RpcServer;

/**
 * 测试用服务提供方（服务端）
 */
public class testServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(helloService, 9000);
    }

}
