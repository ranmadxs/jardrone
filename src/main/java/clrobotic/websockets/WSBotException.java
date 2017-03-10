package clrobotic.websockets;

public class WSBotException extends Exception{

	private static final long serialVersionUID = 1214846859572598762L;
	
	private String ip;
	private String descripcion;
	private String codigo;
	
	public WSBotException(String message, Throwable cause) {
	    super(message, cause);
	}
	
	public WSBotException(String descripcion, String codigo) {
		super(descripcion);
		this.descripcion = descripcion;
		this.codigo = codigo;
	}	
	
	public String getDescripcion() {
		return descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}