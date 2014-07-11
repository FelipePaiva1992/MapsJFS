package model;

public class Localizacao {
	
	private String latitudeOrigem;
	private String longitudeOrigem;
	private String latitudeDestino;
	private String longitudeDestino;
	private String polylinha;
	
	
	
	public String getPolylinha() {
		return polylinha;
	}
	public void setPolylinha(String polylinha) {
		this.polylinha = polylinha;
	}
	public String getLatitudeOrigem() {
		return latitudeOrigem;
	}
	public void setLatitudeOrigem(String latitudeOrigem) {
		this.latitudeOrigem = latitudeOrigem;
	}
	public String getLongitudeOrigem() {
		return longitudeOrigem;
	}
	public void setLongitudeOrigem(String longitudeOrigem) {
		this.longitudeOrigem = longitudeOrigem;
	}
	public String getLatitudeDestino() {
		return latitudeDestino;
	}
	public void setLatitudeDestino(String latitudeDestino) {
		this.latitudeDestino = latitudeDestino;
	}
	public String getLongitudeDestino() {
		return longitudeDestino;
	}
	public void setLongitudeDestino(String longitudeDestino) {
		this.longitudeDestino = longitudeDestino;
	}
	
	
}
