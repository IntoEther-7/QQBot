package org.ether.qqbot.entity;

import lombok.Data;
import org.ether.qqbot.entity.event.Intents;
import org.ether.qqbot.entity.event.Opcode;

/**
 * @author IntoEther-7
 * @date 2023/7/22 16:05
 * @project QQBot
 */
@Data
public class MyPayload {
    private int op; // opcode, https://bot.q.qq.com/wiki/develop/api/gateway/opcode.html
    private Opcode opcode;
    private Object d; // 事件内容
    private int s; // 下行消息序列号
    private String t; // 事件类型
    private Intents intents;

    public void setOp(int op) {
        this.op = op;
        opcode = Opcode.map.get(op);
    }

    public void setT(String t) {
        this.t = t;
        intents = Intents.map.get(t);
    }

}
