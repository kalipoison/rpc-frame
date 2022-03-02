package com.gohb.rpc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * �������õ���Ӧ״̬��
 */
@AllArgsConstructor
@Getter
public enum ResponseCode {

    SUCCESS(200,"���÷����ɹ�"),
    FAIL(500,"���÷���ʧ��"),
    METHOD_NOT_FOUND(500,"δ�ҵ�ָ������"),
    CLASS_NOT_FOUND(500,"δ�ҵ�ָ����");

    private final int code;
    private final String message;

}
