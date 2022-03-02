package com.gohb.rpc.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * Զ�̷������õ��ṩ�ߣ�����ˣ�
 */
public class RpcServer {

    private final ExecutorService threadPool;

    private final Logger logger = LoggerFactory.getLogger(RpcServer.class);

    public RpcServer() {
        int corePoolSize = 5;
        int maxinumPoolSize = 10;
        long keepAliveTime = 60;
        BlockingQueue<Runnable> workingQueue = new ArrayBlockingQueue<>(100);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadPool = new ThreadPoolExecutor(corePoolSize, maxinumPoolSize, keepAliveTime, TimeUnit.SECONDS, workingQueue, threadFactory);
    }

    public void register(Object service, int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("��������������....");
            Socket socket;
            while ((socket = serverSocket.accept()) != null) {
                logger.info("�ͻ������ӣ�IpΪ��" + socket.getInetAddress() + ":" + socket.getPort());
                threadPool.execute(new RequestHandler(socket, service));
            }
        } catch (IOException e) {
            logger.error("����ʱ�д�������", e);
        }
    }
}
