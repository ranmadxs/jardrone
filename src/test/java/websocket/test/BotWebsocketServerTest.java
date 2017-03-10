package websocket.test;

import java.io.IOException;

import org.java_websocket.WebSocketImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.redtogreen.rpa.bot.websocket.WebSocketBotServer;
import com.redtogreen.rpa.websocket.WebSocketBotBasicMessageListener;

public class BotWebsocketServerTest {

	private final Logger log = LoggerFactory.getLogger(BotWebsocketServerTest.class);
	
	@Test
	public void testWebsocketServer(){
		log.info("Test WS Server");
	}
	
    public static void main(String[] args) throws InterruptedException, IOException {
        try {            
        	WebSocketBotBasicMessageListener listener = new WebSocketBotBasicMessageListener();
            WebSocketImpl.DEBUG = true;
            int port = 8887; // 843 flash policy port

            WebSocketBotServer s = new WebSocketBotServer(port);
            s.addMessageListener(listener);
            s.start();
            System.out.println("CoreWSServer started on port: " + s.getPort());

        } catch (Exception e) {

        }

    }	
	
	
}
