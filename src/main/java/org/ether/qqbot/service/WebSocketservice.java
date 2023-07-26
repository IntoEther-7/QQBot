package org.ether.qqbot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ether.qqbot.entity.MyMethods;
import org.ether.qqbot.entity.MyPayload;
import org.ether.qqbot.entity.event.Intents;
import org.springframework.messaging.handler.annotation.Payload;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.WebSocket;
import java.util.HashMap;

/**
 * @author IntoEther-7
 * @date 2023/7/20 15:48
 * @project QQBot
 */

/**
 * 一个用来监听的服务, 需要有监听的信号量
 */
public abstract class WebSocketservice implements WebSocket {
    public final String CURR_ENV;
    public final String TOKEN;
    public final Intents INTENTS;

    public WebSocketservice(String CURR_ENV, String TOKEN, Intents INTENTS) {
        this.CURR_ENV = CURR_ENV;
        this.TOKEN = TOKEN;
        this.INTENTS = INTENTS;
    }

    /**
     * 连接到 Gateway
     * @return 网关地址
     */
    public URL conn2Gateway() throws IOException {
        URL src = new URL(CURR_ENV + MyMethods.WSS.getMETHOD());
        String str = (String) new ObjectMapper().readValue(src, HashMap.class).get("url");
        return new URL(str);
    }

}
