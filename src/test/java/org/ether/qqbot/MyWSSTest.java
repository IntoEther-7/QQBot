package org.ether.qqbot;

import lombok.extern.slf4j.Slf4j;
import org.ether.qqbot.entity.MyPayload;
import org.ether.qqbot.entity.event.Intents;
import org.ether.qqbot.my_message_handler.MessageHandler;
import org.ether.qqbot.my_websocket_client.MyWebSocketClient;

import java.net.URI;

/**
 * @author IntoEther-7
 * @date 2023/7/22 21:30
 * @project QQBot
 */
@Slf4j
public class MyWSSTest {
    public static void main(String[] args) throws Exception {
        MessageHandler myService = new MessageHandler() {
            @Override
            public MyPayload handle(MyPayload serverMessage) {
                return null;
            }
        };
        MyWebSocketClient client = new MyWebSocketClient(new URI("wss://sandbox.api.sgroup.qq.com/websocket"),
                "Bot " + "102054783.3oetIWBnHYore10nolJp8NeNDScOffPw", Intents.AUDIO_ACTION, myService);
        client.connect();
        while (client.isClosed()) ;
    }
}
