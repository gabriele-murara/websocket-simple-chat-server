/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.murara.chatserver;

import java.net.InetSocketAddress;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

/**
 *
 * @author gabriele
 */
public class ChatServer extends WebSocketServer {

    public ChatServer(int port) {
        super(new InetSocketAddress("0.0.0.0", port));
        String msg = String.format("Listen to 0.0.0.0:%d", port);
        System.out.println(msg);
    }
    
    @Override
    public void onOpen(WebSocket ws, ClientHandshake ch) {
        System.out.println(
            String.format("Opened with HandShake '%s'!", 
            ch.getResourceDescriptor())
        );
    }

    @Override
    public void onClose(WebSocket ws, int i, String string, boolean bln) {
        System.out.println("Closed!");
    }

    @Override
    public void onMessage(WebSocket ws, String string) {
        System.out.println("New Message: " + string);
        String msg = "Grazie per la tua segnalazione. Il messaggio '%s' è stato ricevuto dal server";
        ws.send(String.format(msg, string));
    }

    @Override
    public void onError(WebSocket ws, Exception ex) {
        System.out.println("Error!!!!");
        ex.printStackTrace();
    }
}
