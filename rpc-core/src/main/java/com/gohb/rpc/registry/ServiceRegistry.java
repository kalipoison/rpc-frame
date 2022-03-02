package com.gohb.rpc.registry;

/**
 * ����ע���ͨ�ýӿ�
 */
public interface ServiceRegistry {

    /**
     * ��һ������ע���ע���
     * @param service ��ע��ķ���ʵ��
     * @param <T> ����ʵ����
     */
    <T> void register(T service);

    /**
     * ���ݷ������ƻ�ȡ����ʵ��
     * @param serviceName ��������
     * @return ����ʵ��
     */
    Object getService(String serviceName);

}
