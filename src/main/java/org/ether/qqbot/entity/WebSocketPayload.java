package org.ether.qqbot.entity;

import lombok.Data;
import org.ether.qqbot.entity.event.Intents;
import org.ether.qqbot.entity.event.Opcode;

/**
 * @author IntoEther-7
 * @date 2023/7/7 15:16
 * @project ZhihuProject
 */
@Data
public class WebSocketPayload {
    private Integer op; // opcode
    private Integer s; // 消息序列号seq
    private String t; // 消息类型
    private Object d; // 消息内容
    private Opcode opcode;
    private Intents intents;

    /**
     * opcode
     *
     * @return
     */
    public int getOp() {
        return op;
    }

    /**
     * opcode
     *
     * @param op
     */
    public void setOp(int op) {
        this.op = op;
        opcode = Opcode.map.get(op);
    }

    /**
     * 消息序列号seq
     *
     * @return
     */
    public int getS() {
        return s;
    }

    /**
     * 消息序列号seq
     *
     * @param s
     */
    public void setS(int s) {
        this.s = s;
    }

    /**
     * 消息类型
     *
     * @return
     */
    public String getT() {
        return t;
    }

    /**
     * 消息类型
     *
     * @param t
     */
    public void setT(String t) {
        this.t = t;
        this.intents = Intents.valueOf(t);
    }

    /**
     * 消息内容
     *
     * @return
     */
    public Object getD() {
        return d;
    }

    /**
     * 消息内容
     *
     * @param d
     */
    public void setD(Object d) {
        this.d = d;
    }
}

