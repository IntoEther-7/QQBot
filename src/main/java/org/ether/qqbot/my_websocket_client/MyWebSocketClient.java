package org.ether.qqbot.my_websocket_client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.ether.qqbot.entity.MyPayload;
import org.ether.qqbot.entity.event.Intents;
import org.ether.qqbot.my_message_handler.HeartbeatMessageHandler;
import org.ether.qqbot.my_message_handler.IdentifyMessageHandler;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;

/**
 * @author IntoEther-7
 * @date 2023/7/22 21:24
 * @project QQBot
 */
@Slf4j
public class MyWebSocketClient extends WebSocketClient {

    private ObjectMapper mapper = new ObjectMapper();
    private HeartbeatMessageHandler heartbeatMessageHandler;
    private final SynchronousQueue<MyPayload> deque = new SynchronousQueue<>();
    private final String token; // token, 初始化需要
    private final Intents intents; // token, 初始化需要
    private Thread heartbeatRun; // 心跳线程

    public MyWebSocketClient(URI serverUri, String token, Intents intents) {
        super(serverUri);
        this.token = token;
        this.intents = intents;
    }

    public MyWebSocketClient(URI serverUri, String token, Intents intents, Draft protocolDraft) {
        super(serverUri, protocolDraft);
        this.token = token;
        this.intents = intents;
    }

    public MyWebSocketClient(URI serverUri, String token, Intents intents, Map<String, String> httpHeaders) {
        super(serverUri, httpHeaders);
        this.token = token;
        this.intents = intents;
    }

    public MyWebSocketClient(URI serverUri, String token, Intents intents, Draft protocolDraft,
                             Map<String, String> httpHeaders) {
        super(serverUri, protocolDraft, httpHeaders);
        this.token = token;
        this.intents = intents;
    }

    public MyWebSocketClient(URI serverUri, String token, Intents intents, Draft protocolDraft,
                             Map<String, String> httpHeaders, int connectTimeout) {
        super(serverUri, protocolDraft, httpHeaders, connectTimeout);
        this.token = token;
        this.intents = intents;
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        log.info("连接已建立");
    }


    /**
     * 用于接收消息并处理
     * CODE     名称              客户端操作                   描述
     * 0        Dispatch            Receive             服务端进行消息推送
     * 1        Heartbeat           Send/Receive        客户端或服务端发送心跳
     * 2        Identify            Send                客户端发送鉴权
     * 6        Resume              Send                客户端恢复连接
     * 7        Reconnect           Receive             服务端通知客户端重新连接
     * 9        Invalid Session     Receive             当identify或resume的时候，如果参数有错，服务端会返回该消息
     * 10       Hello               Receive             当客户端与网关建立ws连接之后，网关下发的第一条消息
     * 11       Heartbeat ACK       Receive/Reply       当发送心跳成功之后，就会收到该消息
     * 12       HTTP Callback ACK   Reply               仅用于 http 回调模式的回包，代表机器人收到了平台推送的数据
     * <p>
     * opcode
     * 0 -> 服务端消息推送, 灵活处理, 可能会是心跳初始化
     * 1 -> 不用处理
     * 2 -> 不用处理
     * 7 -> ResumeConnectionHandler
     * 9 -> 参数有错
     * 10 -> HeartbeatMessageHandler(初始化一个心跳周期Handler定期发送心跳包), IdentifyMessageHandler
     * 11 -> 不用处理
     * 12 -> 不用处理
     *
     * @param s 消息的字符串, 基本都是json格式
     */
    @SneakyThrows
    @Override
    public void onMessage(String s) {
        log.info("收到消息" + s);
        MyPayload message = mapper.readValue(s, MyPayload.class);
        deque.poll();
        deque.put(message);
        // 更新最新消息

        switch (message.getOp()) {
            case 0:
                // TODO: 具体监听此消息所做的业务流程
                if (message.getIntents() == Intents.READY) {
                    // 心跳
                    heartbeatMessageHandler = new HeartbeatMessageHandler();
                    // TODO: 定时任务
                }
                log.info("---------------具体监听此消息所做的业务流程, 待补充----------------");
                break;
            case 7:
                // 鉴权
                MyPayload identifyMessage = new IdentifyMessageHandler(token, intents).handle(null);
                this.send(mapper.writeValueAsString(identifyMessage));
                heartbeatRun = new Thread(() -> {
                    synchronized (deque) {
                        try {
                            this.send(mapper.writeValueAsString(heartbeatMessageHandler.handle(deque.peek())));
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                break;
            case 10:
                break;
        }

    }

    @Override
    public void onClose(int i, String s, boolean b) {
        log.info("关闭连接");
    }

    @Override
    public void onError(Exception e) {
        log.info("出错");
    }
}
