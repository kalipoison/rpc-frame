package com.gohb.rpc.registry;

import java.net.InetSocketAddress;

/**
 * �����ֽӿ�
 */
public interface ServiceDiscovery {

    /**
     * ���ݷ������Ʋ��ҷ���ʵ��
     *
     * @param serviceName ��������
     * @return ����ʵ��
     */
    InetSocketAddress lookupService(String serviceName);

}
