package com.gohb.rpc;


import com.gohb.rpc.serializer.CommonSerializer;

/**
 * ��������ͨ�ýӿ�
 */
public interface RpcServer {

    void start(int port);

    void setSerializer(CommonSerializer serializer);

}
