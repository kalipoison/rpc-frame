package com.gohb.rpc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * ���������ṩ�߷��͵��������
 */
@Data
@AllArgsConstructor
public class RpcRequest implements Serializable {

    public RpcRequest() {}

    /**
     * �����
     */
    private String requestId;

    /**
     * �����ýӿ�����
     */
    private String interfaceName;

    /**
     * �����÷�������
     */
    private String methodName;

    /**
     * ���÷����Ĳ���
     */
    private Object[] parameters;

    /**
     * ���÷����Ĳ�������
     */
    private Class<?>[] paramTypes;

}
