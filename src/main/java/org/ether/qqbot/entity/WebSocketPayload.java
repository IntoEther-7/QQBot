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
    private Integer s; // ��Ϣ���к�seq
    private String t; // ��Ϣ����
    private Object d; // ��Ϣ����
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
     * ��Ϣ���к�seq
     *
     * @return
     */
    public int getS() {
        return s;
    }

    /**
     * ��Ϣ���к�seq
     *
     * @param s
     */
    public void setS(int s) {
        this.s = s;
    }

    /**
     * ��Ϣ����
     *
     * @return
     */
    public String getT() {
        return t;
    }

    /**
     * ��Ϣ����
     *
     * @param t
     */
    public void setT(String t) {
        this.t = t;
        this.intents = Intents.valueOf(t);
    }

    /**
     * ��Ϣ����
     *
     * @return
     */
    public Object getD() {
        return d;
    }

    /**
     * ��Ϣ����
     *
     * @param d
     */
    public void setD(Object d) {
        this.d = d;
    }
}

