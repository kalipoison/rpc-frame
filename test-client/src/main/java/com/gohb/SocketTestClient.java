package com.gohb;

import com.gohb.rpc.transport.RpcClientProxy;
import com.gohb.rpc.api.HelloObject;
import com.gohb.rpc.api.HelloService;
import com.gohb.rpc.serializer.KryoSerializer;
import com.gohb.rpc.transport.socket.client.SocketClient;

/**
 * �����������ߣ��ͻ��ˣ�
 */
public class SocketTestClient {

    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        client.setSerializer(new KryoSerializer());
        RpcClientProxy proxy = new RpcClientProxy(client);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);
    }

}
