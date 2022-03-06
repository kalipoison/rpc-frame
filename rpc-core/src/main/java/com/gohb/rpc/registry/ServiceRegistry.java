package com.gohb.rpc.registry;

import java.net.InetSocketAddress;

/**
 * ����ע��ӿ�
 */
public interface ServiceRegistry {

    /**
     * ��һ������ע���ע���
     * @param serviceName ��������
     * @param inetSocketAddress �ṩ����ĵ�ַ
     */
    void register(String serviceName, InetSocketAddress inetSocketAddress);

}
