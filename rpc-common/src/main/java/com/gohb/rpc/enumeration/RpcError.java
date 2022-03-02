package com.gohb.rpc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RpcError {

    SERVICE_INVOCATION_FAILURE("������ó���ʧ��"),
    SERVICE_CAN_NOT_BE_NULL("ע��ķ��񲻵�Ϊ��");

    private final String message;

}
