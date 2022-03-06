package com.gohb.rpc.transport.socket.server;

import com.gohb.rpc.handler.RequestHandler;
import com.gohb.rpc.entity.RpcRequest;
import com.gohb.rpc.entity.RpcResponse;
import com.gohb.rpc.registry.ServiceRegistry;
import com.gohb.rpc.serializer.CommonSerializer;
import com.gohb.rpc.transport.socket.util.ObjectReader;
import com.gohb.rpc.transport.socket.util.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

/**
 * ���� RpcRequest �Ĺ����߳�
 */
public class SocketRequestHandlerThread implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(SocketRequestHandlerThread.class);

    private Socket socket;
    private RequestHandler requestHandler;
    private CommonSerializer serializer;

    public SocketRequestHandlerThread(Socket socket, RequestHandler requestHandler, ServiceRegistry serviceRegistry, CommonSerializer serializer) {
        this.socket = socket;
        this.requestHandler = requestHandler;
        this.serializer = serializer;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            RpcRequest rpcRequest = (RpcRequest) ObjectReader.readObject(inputStream);
            Object result = requestHandler.handle(rpcRequest);
            RpcResponse<Object> response = RpcResponse.success(result, rpcRequest.getRequestId());
            ObjectWriter.writeObject(outputStream, response, serializer);
        } catch (IOException e) {
            logger.error("���û���ʱ�д�������", e);
        }
    }

}
