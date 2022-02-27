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
    NOT_FOUND_METHOD(500,"δ�ҵ�ָ������"),
    NOT_FOUND_CLASS(500,"δ�ҵ�ָ����");

    private final int code;
    private final String message;

}
