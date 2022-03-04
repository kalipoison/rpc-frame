package com.gohb.rpc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RpcError {

    SERVICE_INVOCATION_FAILURE("������ó���ʧ��"),
    SERVICE_NOT_FOUND("�Ҳ�����Ӧ�ķ���"),
    SERVICE_NOT_IMPLEMENT_ANY_INTERFACE("ע��ķ���δʵ�ֽӿ�"),
    UNKNOWN_PROTOCOL("��ʶ���Э���"),
    UNKNOWN_SERIALIZER("��ʶ���(��)���л���"),
    UNKNOWN_PACKAGE_TYPE("��ʶ������ݰ�����"),
    SERIALIZER_NOT_FOUND("�Ҳ������л���");

    private final String message;

}
