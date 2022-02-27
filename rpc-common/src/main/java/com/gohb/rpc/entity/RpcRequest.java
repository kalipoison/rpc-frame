package com.gohb.rpc.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * ���������ṩ�߷��͵��������
 */
@Data
@Builder
public class RpcRequest implements Serializable {

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
