package cn.zijun.ordermenue.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Title WebSocket
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/2/24
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {
    private Session session;

    /**
     * 选用线程安全的set
     */
    private static CopyOnWriteArraySet<WebSocket>webSocketSet= new CopyOnWriteArraySet<>();

    @OnOpen
    public void opOpen(Session session){
        this.session=session;
        webSocketSet.add(this);
        log.info("[websocket消息]有新的连接，总数：{}",webSocketSet.size());
    }

    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        log.info("[websocket消息]连接断开，总数：{}",webSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message){
        log.info("[websocket消息]收到客户端发来的消息，总数：{}",webSocketSet.size());
    }

    public void sendMessage(String message){
        for (WebSocket webSocket:webSocketSet){
            log.info("[websocket消息]收到客户端发来的消息，总数：{}",webSocketSet.size());
            try{
                webSocket.session.getBasicRemote().sendText(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
