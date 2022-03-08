package com.gohb;

import com.gohb.rpc.serializer.CommonSerializer;
import com.gohb.rpc.transport.RpcClientProxy;
import com.gohb.rpc.api.HelloObject;
import com.gohb.rpc.api.HelloService;
import com.gohb.rpc.serializer.KryoSerializer;
import com.gohb.rpc.transport.socket.client.SocketClient;

/**
 * 测试用消费者（客户端）
 */
public class SocketTestClient {

    public static void main(String[] args) {
        SocketClient client = new SocketClient(CommonSerializer.KRYO_SERIALIZER);
        RpcClientProxy proxy = new RpcClientProxy(client);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        for(int i = 0; i < 20; i ++) {
            String res = helloService.hello(object);
            System.out.println(res);
        }
    }

}
