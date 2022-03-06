package com.gohb.rpc.transport;


import com.gohb.rpc.serializer.CommonSerializer;

/**
 * ��������ͨ�ýӿ�
 */
public interface RpcServer {

    void start();

    void setSerializer(CommonSerializer serializer);

    <T> void publishService(T service, Class<T> serviceClass);

}
