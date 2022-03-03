package com.gohb.rpc.entity;

import com.gohb.rpc.enumeration.ResponseCode;
import lombok.Data;

import java.io.Serializable;

/**
 * �ṩ��ִ����ɻ������������߷��صĽ������
 */
@Data
public class RpcResponse<T> implements Serializable {

    public RpcResponse() {}

    /**
     * ��Ӧ״̬��
     */
    private Integer statusCode;

    /**
     * ��Ӧ״̬������Ϣ
     */
    private String message;

    /**
     * ��Ӧ����
     */
    private T data;

    public static <T> RpcResponse<T> success(T data) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setStatusCode(ResponseCode.SUCCESS.getCode());
        response.setData(data);
        return response;
    }

    public static <T> RpcResponse<T> fail(ResponseCode code) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setStatusCode(code.getCode());
        response.setMessage(code.getMessage());
        return response;
    }

}
