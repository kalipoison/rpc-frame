package com.gohb.rpc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * �ֽ����б�ʶ���л��ͷ����л���
 */
@AllArgsConstructor
@Getter
public enum SerializerCode {

    JSON(1);

    private final int code;

}
