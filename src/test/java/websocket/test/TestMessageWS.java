package websocket.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.redtogreen.rpa.websocket.WSBotMessage;

public class TestMessageWS {

	private final Logger log = LoggerFactory.getLogger(TestMessageWS.class);
	
	@Test
	public void testMessage(){
		WSBotMessage message = new WSBotMessage();
		message.setClientId("Chrome");
		message.setType("CMD_HI");
		message.setMessage("Hola");
		message.setType("Example");
		
		Gson gson = new Gson();
		String json = gson.toJson(message);
		log.info(json);
		
	}
	
}
