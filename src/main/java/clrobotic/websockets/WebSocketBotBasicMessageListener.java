package clrobotic.websockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketBotBasicMessageListener implements WebSocketBotMessageListener{
	
	private final Logger log = LoggerFactory.getLogger(WebSocketBotBasicMessageListener.class);
	
	public void onMessage(WSBotMessage wsBotMessage){
		if (wsBotMessage != null){
			log.info(wsBotMessage.getMessage());
		}
	}
		
}