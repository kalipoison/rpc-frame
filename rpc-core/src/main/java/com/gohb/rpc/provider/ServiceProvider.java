package com.gohb.rpc.provider;

/**
 * ������ṩ����ʵ������
 */
public interface ServiceProvider {


    <T> void addServiceProvider(T service);

    Object getServiceProvider(String serviceName);

}
