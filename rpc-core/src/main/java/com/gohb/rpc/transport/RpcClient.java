package com.gohb.rpc.transport;


import com.gohb.rpc.entity.RpcRequest;
import com.gohb.rpc.serializer.CommonSerializer;


/**
 * 客户端类通用接口
 */
public interface RpcClient {

    Object sendRequest(RpcRequest rpcRequest);

    void setSerializer(CommonSerializer serializer);

}
