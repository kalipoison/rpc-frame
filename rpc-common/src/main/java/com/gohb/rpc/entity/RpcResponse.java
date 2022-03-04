package com.gohb.rpc.entity;

import com.gohb.rpc.enumeration.ResponseCode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * �ṩ��ִ����ɻ������������߷��صĽ������
 */
@Data
@NoArgsConstructor
public class RpcResponse<T> implements Serializable {


    /**
     * ��Ӧ��Ӧ�������
     */
    private String requestId;

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

    public static <T> RpcResponse<T> success(T data, String requestId) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setRequestId(requestId);
        response.setStatusCode(ResponseCode.SUCCESS.getCode());
        response.setData(data);
        return response;
    }

    public static <T> RpcResponse<T> fail(ResponseCode code, String requestId) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setRequestId(requestId);
        response.setStatusCode(code.getCode());
        response.setMessage(code.getMessage());
        return response;
    }

}
