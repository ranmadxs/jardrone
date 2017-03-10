package clrobotic.websockets;

import java.io.Serializable;

import com.google.gson.Gson;

public class WSBotMessage implements Serializable{

	private static final long serialVersionUID = -874153811240112126L;
	
    private String clientId;
    private String type;
    private String message;    
    private String ip;       
    
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getClientId() {
		return clientId;
	}
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toJson(){
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
}
