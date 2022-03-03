package com.gohb.rpc.netty.client;

import com.gohb.rpc.RpcClient;
import com.gohb.rpc.codec.CommonDecoder;
import com.gohb.rpc.codec.CommonEncoder;
import com.gohb.rpc.entity.RpcRequest;
import com.gohb.rpc.entity.RpcResponse;
import com.gohb.rpc.serializer.HessianSerializer;
import com.gohb.rpc.serializer.JsonSerializer;
import com.gohb.rpc.serializer.KryoSerializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NIO��ʽ���Ѳ�ͻ�����
 */
public class NettyClient implements RpcClient {

    private static final Logger logger = LoggerFactory.getLogger(NettyClient.class);

    private String host;
    private int port;
    private static final Bootstrap bootstrap;

    public NettyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    static {
        EventLoopGroup group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new CommonDecoder())
                                .addLast(new CommonEncoder(new HessianSerializer()))
                                .addLast(new NettyClientHandler());
                    }
                });
    }

    @Override
    public Object sendRequest(RpcRequest rpcRequest) {
        try {

            ChannelFuture future = bootstrap.connect(host, port).sync();
            logger.info("�ͻ������ӵ������� {}:{}", host, port);
            Channel channel = future.channel();
            if(channel != null) {
                channel.writeAndFlush(rpcRequest).addListener(future1 -> {
                    if(future1.isSuccess()) {
                        logger.info(String.format("�ͻ��˷�����Ϣ: %s", rpcRequest.toString()));
                    } else {
                        logger.error("������Ϣʱ�д�����: ", future1.cause());
                    }
                });
                channel.closeFuture().sync();
                AttributeKey<RpcResponse> key = AttributeKey.valueOf("rpcResponse");
                RpcResponse rpcResponse = channel.attr(key).get();
                return rpcResponse.getData();
            }

        } catch (InterruptedException e) {
            logger.error("������Ϣʱ�д�����: ", e);
        }
        return null;
    }

}
