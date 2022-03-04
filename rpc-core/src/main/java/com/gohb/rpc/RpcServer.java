package com.gohb.rpc;


import com.gohb.rpc.serializer.CommonSerializer;

/**
 * 服务器类通用接口
 */
public interface RpcServer {

    void start(int port);

    void setSerializer(CommonSerializer serializer);

}
