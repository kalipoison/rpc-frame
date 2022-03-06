package com.gohb;

import com.gohb.rpc.api.HelloObject;
import com.gohb.rpc.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloServiceImpl2 implements HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl2.class);

    @Override
    public String hello(HelloObject object) {
        logger.info("���յ���Ϣ��{}", object.getMessage());
        return "���δ�������Socket����";
    }
}
