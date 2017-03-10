package websocket.test;


import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

import com.redtogreen.rpa.websocket.WSBotMessage;
import com.redtogreen.rpa.websocket.WebSocketBotClient;

public class BotWSClientTest {

	@Test
	public void testWSClient(){
		
	}
	
	public static void main( String[] args ) throws URISyntaxException, InterruptedException {
		WebSocketBotClient c = new WebSocketBotClient( new URI( "ws://localhost:8887" )); // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
		c.connect();
		Thread.sleep(1000);
		
		if(c.getConnection().isOpen()){
			WSBotMessage message = new WSBotMessage();
			message.setClientId("TestJava");
			message.setType("CMD_HI");
			message.setMessage("HolaJava");
			message.setType("Example");
			
			c.send(message.toJson());
		}
		
	}
	
}