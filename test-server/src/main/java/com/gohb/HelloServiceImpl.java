package com.gohb;

import com.gohb.rpc.api.HelloObject;
import com.gohb.rpc.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloServiceImpl implements HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String hello(HelloObject object) {
        logger.info("���յ���{}", object.getMessage());
        return "���ǵ��õķ���ֵ��id=" + object.getId();
    }
}
