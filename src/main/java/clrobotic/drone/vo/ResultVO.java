package clrobotic.drone.vo;

import java.io.Serializable;

public class ResultVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4601725497261976589L;

	private Integer total;
    private Integer tiempo;
    private String descripcion;
    private String codigo;
    
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getTiempo() {
		return tiempo;
	}
	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

    
    
	
}
