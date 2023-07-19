package org.ether.qqbot.entity.event;

import java.util.HashMap;
import java.util.Map;

public enum Opcode {
    DISPATCH(0, "Dispatch", "Receive", "����˽�����Ϣ����"), HEARTBEAT(1, "Heartbeat", "Send/Receive", "�ͻ��˻����˷�������"),
    IDENTIFY(2, "Identify", "Send", "�ͻ��˷��ͼ�Ȩ"), RESUME(6, "Resume", "Send", "�ͻ��˻ָ�����"), RECONNECT(7, "Reconnect",
            "Receive", "�����֪ͨ�ͻ�����������"), INVALID_SESSION(9, "Invalid Session", "Receive", "��identify��resume" +
            "��ʱ����������д�����˻᷵�ظ���Ϣ"), HELLO(10, "Hello", "Receive", "���ͻ��������ؽ���ws����֮�������·��ĵ�һ����Ϣ"), HEARTBEAT_ACK(11,
            "Heartbeat ACK", "Receive/Reply", "�����������ɹ�֮�󣬾ͻ��յ�����Ϣ"), HTTP_CALLBACK_ACK(12, "HTTP Callback ACK", "Reply"
            , "������ http �ص�ģʽ�Ļذ�������������յ���ƽ̨���͵�����");

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
}
