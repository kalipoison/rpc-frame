package com.gohb.rpc.transport;


import com.gohb.rpc.entity.RpcRequest;
import com.gohb.rpc.serializer.CommonSerializer;


/**
 * 客户端类通用接口
 */
public interface RpcClient {

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    Object sendRequest(RpcRequest rpcRequest);


}
