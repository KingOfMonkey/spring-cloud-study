package com.meiya.springcloudstudy.service1.inter;

public interface RedisMsgInterface {
    /**
     * 注意：方法名最好起这个名称
     * @param message 接受到的message
     */
    void handleMessage(String message);
}
