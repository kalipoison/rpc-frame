package com.gohb.rpc.provider;

import com.gohb.rpc.enumeration.RpcError;
import com.gohb.rpc.exception.RpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Ĭ�ϵķ���ע����������˱��ط���
 */
public class ServiceProviderImpl implements ServiceProvider {

    private static final Logger logger = LoggerFactory.getLogger(ServiceProviderImpl.class);

    private static final Map<String, Object> serviceMap = new ConcurrentHashMap<>();
    private static final Set<String> registeredService = ConcurrentHashMap.newKeySet();

    @Override
    public <T> void addServiceProvider(T service, Class<T> serviceClass) {
        String serviceName = service.getClass().getCanonicalName();
        if(registeredService.contains(serviceName)) return;
        registeredService.add(serviceName);
        serviceMap.put(serviceName, service);
        logger.info("��ӿ�: {} ע�����: {}", service.getClass().getInterfaces(), serviceName);
    }

    @Override
    public Object getServiceProvider(String serviceName) {
        Object service = serviceMap.get(serviceName);
        if(service == null) {
            throw new RpcException(RpcError.SERVICE_NOT_FOUND);
        }
        return service;
    }
}
