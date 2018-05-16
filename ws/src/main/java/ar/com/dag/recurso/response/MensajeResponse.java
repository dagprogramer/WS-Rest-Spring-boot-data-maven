package ar.com.dag.recurso.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MensajeResponse {
	
	@JsonProperty(value="mensaje")
    private String mensaje;

	public MensajeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MensajeResponse(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "MensajeResponse [mensaje=" + mensaje + "]";
	}
    
    
    
}
