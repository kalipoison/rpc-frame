package com.gohb;

import com.gohb.rpc.api.HelloService;
import com.gohb.rpc.serializer.CommonSerializer;
import com.gohb.rpc.serializer.KryoSerializer;
import com.gohb.rpc.transport.socket.server.SocketServer;

/**
 * 测试用服务提供方（服务端）
 */
public class SocketTestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        SocketServer socketServer = new SocketServer("127.0.0.1", 9998, CommonSerializer.HESSIAN_SERIALIZER);
        socketServer.publishService(helloService, HelloService.class);
    }

}
