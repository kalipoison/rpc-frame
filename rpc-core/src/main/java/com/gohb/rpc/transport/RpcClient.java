package com.gohb.rpc.transport;


import com.gohb.rpc.entity.RpcRequest;
import com.gohb.rpc.serializer.CommonSerializer;


/**
 * �ͻ�����ͨ�ýӿ�
 */
public interface RpcClient {

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    Object sendRequest(RpcRequest rpcRequest);


}
