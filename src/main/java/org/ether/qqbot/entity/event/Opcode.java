package org.ether.qqbot.entity.event;

import java.util.HashMap;
import java.util.Map;

public enum Opcode {
    DISPATCH(0, "Dispatch", "Receive", "服务端进行消息推送"),
    HEARTBEAT(1, "Heartbeat", "Send/Receive", "客户端或服务端发送心跳"),
    IDENTIFY(2, "Identify", "Send", "客户端发送鉴权"),
    RESUME(6, "Resume", "Send", "客户端恢复连接"),
    RECONNECT(7, "Reconnect", "Receive", "服务端通知客户端重新连接"),
    INVALID_SESSION(9, "Invalid Session", "Receive", "当identify或resume的时候，如果参数有错，服务端会返回该消息"),
    HELLO(10, "Hello", "Receive", "当客户端与网关建立ws连接之后，网关下发的第一条消息"),
    HEARTBEAT_ACK(11, "Heartbeat ACK", "Receive/Reply", "当发送心跳成功之后，就会收到该消息"),
    HTTP_CALLBACK_ACK(12, "HTTP Callback ACK", "Reply", "仅用于 http 回调模式的回包，代表机器人收到了平台推送的数据");

    private int code;
    private String name;
    private String clientOption;
    private String desc;


    public static final Map<Integer, Opcode> map = new HashMap<>();

    Opcode(int code, String name, String clientOption, String desc) {
        this.code = code;
        this.name = name;
        this.clientOption = clientOption;
        this.desc = desc;
    }

    static {
        for (Opcode opcode : Opcode.values()) {
            map.put(opcode.code, opcode);
        }
    }

    @Override
    public String toString() {
        return "Opcode{" + "code=" + code + ", name='" + name + '\'' + ", clientOption='" + clientOption + '\'' + ", " +
                "desc='" + desc + '\'' + '}';
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getClientOption() {
        return clientOption;
    }

    public String getDesc() {
        return desc;
    }
}
