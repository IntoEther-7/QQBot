package org.ether.qqbot.my_message_handler.impl;

import org.ether.qqbot.entity.MyPayload;
import org.ether.qqbot.my_message_handler.MessageHandler;

/**
 * @author IntoEther-7
 * @date 2023/7/22 21:55
 * @project QQBot
 */

/**
 * 处理, op=11处理心跳回复包
 */
public class HeartbeatMessageHandler implements MessageHandler {
    private MyPayload payload;

    private Integer newSeq;

    public void setNewSeq(Integer newSeq) {
        this.newSeq = newSeq;
    }

    public HeartbeatMessageHandler() {
        payload = new MyPayload();
        newSeq = null;

        payload.setOp(1);
        payload.setD(newSeq);
    }

    /**
     * 使用最新数据来设置心跳包
     * @return
     */
    @Override
    public MyPayload handle(MyPayload newestMess) {
        newSeq = newestMess.getS();
        payload.setD(newSeq);
        return payload;
    }
}
