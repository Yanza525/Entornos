package entorrnos;

import java.util.List;

public class Usuario {
	private int telefono;
	private String nombre;
	private List<Mensaje> enviados;
	private List<Mensaje> recibidos;
	//private int clave;
	
	public Usuario (int t, String n) {
		this.telefono=t;
		this.nombre=n;
	}
	public Usuario (int t) {
		this.telefono=t;
	}
	
	
	
}
