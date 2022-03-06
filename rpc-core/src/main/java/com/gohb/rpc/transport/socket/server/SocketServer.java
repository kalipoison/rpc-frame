package com.gohb.rpc.transport.socket.server;

import com.gohb.rpc.handler.RequestHandler;
import com.gohb.rpc.provider.ServiceProvider;
import com.gohb.rpc.provider.ServiceProviderImpl;
import com.gohb.rpc.registry.NacosServiceRegistry;
import com.gohb.rpc.transport.RpcServer;
import com.gohb.rpc.enumeration.RpcError;
import com.gohb.rpc.exception.RpcException;
import com.gohb.rpc.registry.ServiceRegistry;
import com.gohb.rpc.serializer.CommonSerializer;
import com.gohb.rpc.util.ThreadPoolFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * Socket方式远程方法调用的提供者（服务端）
 */
public class SocketServer implements RpcServer {

    private final Logger logger = LoggerFactory.getLogger(SocketServer.class);

    private final ExecutorService threadPool;
    private RequestHandler requestHandler = new RequestHandler();
    private CommonSerializer serializer;
    private final String host;
    private final int port;

    private final ServiceRegistry serviceRegistry;
    private final ServiceProvider serviceProvider;


    public SocketServer(String host, int port) {
        this.host = host;
        this.port = port;
        threadPool = ThreadPoolFactory.createDefaultThreadPool("socket-rpc-server");
        this.serviceRegistry = new NacosServiceRegistry();
        this.serviceProvider = new ServiceProviderImpl();
    }

    @Override
    public <T> void publishService(Object service, Class<T> serviceClass) {
        if(serializer == null) {
            logger.error("未设置序列化器");
            throw new RpcException(RpcError.SERIALIZER_NOT_FOUND);
        }
        serviceProvider.addServiceProvider(service);
        serviceRegistry.register(serviceClass.getCanonicalName(), new InetSocketAddress(host, port));
        start();
    }

    @Override
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("服务器启动……");
            Socket socket;
            while ((socket = serverSocket.accept()) != null) {
                logger.info("消费者连接: {}:{}", socket.getInetAddress(), socket.getPort());
                threadPool.execute(new RequestHandlerThread(socket, requestHandler, serviceRegistry, serializer));
            }
            threadPool.shutdown();
        } catch (IOException e) {
            logger.error("服务器启动时有错误发生:", e);
        }
    }

    @Override
    public void setSerializer(CommonSerializer serializer) {
        this.serializer = serializer;
    }

}
