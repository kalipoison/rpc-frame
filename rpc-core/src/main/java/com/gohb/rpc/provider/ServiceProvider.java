package com.gohb.rpc.provider;

/**
 * ������ṩ����ʵ������
 */
public interface ServiceProvider {


    <T> void addServiceProvider(T service, Class<T> serviceClass);

    Object getServiceProvider(String serviceName);

}
