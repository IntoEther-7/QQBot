package org.ether.qqbot.my_message_handler.impl;

/**
 * @author IntoEther-7
 * @date 2023/7/22 22:27
 * @project QQBot
 */

import org.ether.qqbot.entity.MyPayload;
import org.ether.qqbot.my_message_handler.MessageHandler;

import java.util.HashMap;

/**
 * 有很多原因都会导致连接断开，断开之后短时间内重连会补发中间遗漏的事件，以保障业务逻辑的正确性。断开重连不需要发送Identify请求。在连接到 Gateway 之后，需要发送 Opcode 6 Resume消息，结构如下：
 * <p>
 * {
 * "op": 6,
 * "d": {
 * "token": "my_token",
 * "session_id": "session_id_i_stored",
 * "seq": 1337
 * }
 * }
 */
public class ResumeConnectionHandler implements MessageHandler {

    private MyPayload payload;
    private String token;
    private HashMap<String, Object> map;

    public ResumeConnectionHandler(String token) {
        payload = new MyPayload();
        this.token = token;
        map = new HashMap<>();

        payload.setOp(6);
        map.put("token", this.token);
        map.put("session_id", null);
    }

    /**
     * 需要最新消息来恢复连接
     *
     * @param newestMess
     * @return
     */
    @Override
    public MyPayload handle(MyPayload newestMess) {
        map.put("seq", newestMess.getS());
        return payload;
    }
}
