package clrobotic.websockets;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
import com.redtogreen.rpa.websocket.WSBotException;
import com.redtogreen.rpa.websocket.WSBotMessage;
import com.redtogreen.rpa.websocket.WebSocketBotErrorListener;
import com.redtogreen.rpa.websocket.WebSocketBotMessageListener;

public class WebSocketBotServer extends WebSocketServer{

	private static final Logger log = LoggerFactory.getLogger(WebSocketBotServer.class);
	private List<WebSocketBotMessageListener> messageListener = new ArrayList<>();
	private List<WebSocketBotErrorListener> errorListener = new ArrayList<>();
	
	public void addMessageListener(WebSocketBotMessageListener listener){
		if(this.messageListener == null){
			this.messageListener = new ArrayList<>();
		}
		this.messageListener.add(listener);
	}
	
	public void addErrorListener(WebSocketBotErrorListener listener){
		if(this.errorListener == null){
			this.errorListener = new ArrayList<>();
		}
		this.errorListener.add(listener);
	}
	
	public WebSocketBotServer(InetSocketAddress address) {
		super(address);
	}

    public WebSocketBotServer(int port) throws UnknownHostException {
        super(new InetSocketAddress(port));
        this.init();
    }
	
	protected final void init()  {
		log.info("WS Bot init");		
	}
	
	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		log.info(conn.getRemoteSocketAddress().getAddress().getHostAddress() + " close WS Bot");
	}

	@Override
	public void onError(WebSocket conn, Exception arg1) {
		log.info("Error en el WS " + conn.getRemoteSocketAddress().getAddress().getHostAddress());
		
		WSBotException wsBotException = new WSBotException("Error en bot", arg1);
		wsBotException.setIp(conn.getRemoteSocketAddress().getAddress().getHostAddress());
		
		if(this.errorListener != null && !this.errorListener.isEmpty()){
			this.errorListener.forEach(botErrorListener -> {
				botErrorListener.onError(wsBotException);
			});
		}
		
	}

	@Override
	public void onMessage(WebSocket conn, String wsMessage) {
		log.info("Incoming Message WS Bot ("+conn.getRemoteSocketAddress().getAddress().getHostAddress()+") :: ".concat(wsMessage));
		Gson gson = new Gson();
        WSBotMessage resp;
        WSBotMessage req;
        
        if (wsMessage != null && wsMessage.length() > 1 && wsMessage.contains("message")) {

        	try{
        		resp = new WSBotMessage();
        		req = gson.fromJson(wsMessage, WSBotMessage.class);
        		req.setIp(conn.getRemoteSocketAddress().getAddress().getHostAddress());
        		this.sendToMessageListener(req);
        	}catch(Exception e){
        		log.error("Malformed message Exception");
        		log.error(e.getMessage());
        	}
        }
		
	}

	public void sendToMessageListener(WSBotMessage msg){
        if (this.messageListener != null && !this.messageListener.isEmpty()){
        	for (WebSocketBotMessageListener webSocketBotMessageListener : messageListener) {
        		webSocketBotMessageListener.onMessage(msg);
			}
        }
	}
	
	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		log.info(conn.getRemoteSocketAddress().getAddress().getHostAddress() .concat(" open WS Bot"));
		
	}
	
}