package com.gohb;

import com.gohb.rpc.api.HelloService;
import com.gohb.rpc.registry.DefaultServiceRegistry;
import com.gohb.rpc.registry.ServiceRegistry;
import com.gohb.rpc.serializer.KryoSerializer;
import com.gohb.rpc.socket.server.SocketServer;

/**
 * 测试用服务提供方（服务端）
 */
public class SocketTestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry serviceRegistry = new DefaultServiceRegistry();
        serviceRegistry.register(helloService);
        SocketServer socketServer = new SocketServer(serviceRegistry);
        socketServer.setSerializer(new KryoSerializer());
        socketServer.start(9000);
    }

}
