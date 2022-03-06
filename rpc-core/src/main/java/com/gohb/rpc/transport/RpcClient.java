package com.gohb.rpc.transport;


import com.gohb.rpc.entity.RpcRequest;
import com.gohb.rpc.serializer.CommonSerializer;


/**
 * �ͻ�����ͨ�ýӿ�
 */
public interface RpcClient {

    Object sendRequest(RpcRequest rpcRequest);

    void setSerializer(CommonSerializer serializer);

}
