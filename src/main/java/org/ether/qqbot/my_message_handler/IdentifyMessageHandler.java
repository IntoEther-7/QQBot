package org.ether.qqbot.my_message_handler;

/**
 * @author IntoEther-7
 * @date 2023/7/22 21:40
 * @project QQBot
 */

import org.ether.qqbot.entity.MyPayload;
import org.ether.qqbot.entity.event.Intents;

import java.util.HashMap;

/**
 * 专门处理鉴权的事务
 */
public class IdentifyMessageHandler implements MessageHandler{
    int heartbeat_interval;
    int op = 2;
    private HashMap<String, Object> map;
    private MyPayload payload;

    /**
     * 鉴权包示例
     * {
     * "op": 2,
     * "d": {
     * "token": "my_token",
     * "intents": 513,
     * "shard": [0, 4], // 分片才会用
     * }
     * }
     *
     * @return
     */
    public IdentifyMessageHandler(String token, Intents intents) {
        MyPayload payload = new MyPayload();
        payload.setOp(op);
        map.put("token", token);
        map.put("intents", intents.getCode());
    }

    /**
     *
     * @param serverMessage null即可
     * @return
     */
    @Override
    public MyPayload handle(MyPayload serverMessage) {
        return payload;
    }
}
