package org.ether.qqbot.my_message_handler;

import org.ether.qqbot.entity.MyPayload;

/**
 * @author IntoEther-7
 * @date 2023/7/22 21:54
 * @project QQBot
 */
public interface MessageHandler {
    public abstract MyPayload handle(MyPayload serverMessage);
    // 可以考虑换成下面的
    // public abstract MyPayload handle(MyPayload request, MyPayload response);
}
