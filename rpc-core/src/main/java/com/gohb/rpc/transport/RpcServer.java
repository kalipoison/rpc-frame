package com.gohb.rpc.transport;


import com.gohb.rpc.serializer.CommonSerializer;

/**
 * ��������ͨ�ýӿ�
 */
public interface RpcServer {

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    void start();

    <T> void publishService(T service, Class<T> serviceClass);

}
