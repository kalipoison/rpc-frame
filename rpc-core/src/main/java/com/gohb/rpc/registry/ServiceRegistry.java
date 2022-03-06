package com.gohb.rpc.registry;

import java.net.InetSocketAddress;

/**
 * ����ע���ͨ�ýӿ�
 */
public interface ServiceRegistry {

    /**
     * ��һ������ע���ע���
     * @param serviceName ��������
     * @param inetSocketAddress �ṩ����ĵ�ַ
     */
    void register(String serviceName, InetSocketAddress inetSocketAddress);


    /**
     * ���ݷ������ƻ�ȡ����ʵ��
     * @param serviceName ��������
     * @return ����ʵ��
     */
    InetSocketAddress lookupService(String serviceName);


}
