package entorrnos;

import java.util.ArrayList;
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
		this.enviados=new ArrayList<>();	
		this.recibidos= new ArrayList<>();
		}
	public Usuario (int t) {
		this.telefono=t;
	}
	
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Mensaje> getEnviados() {
		return enviados;
	}
	public void setEnviados(List<Mensaje> enviados) {
		this.enviados = enviados;
	}
	public List<Mensaje> getRecibidos() {
		return recibidos;
	}
	public void setRecibidos(List<Mensaje> recibidos) {
		this.recibidos = recibidos;
	}
	
	
	public void enviarMensaje(Mensaje m) {
		enviados.add(m);			
	}
	
	public void recibirMensaje(Mensaje m) {
		recibidos.add(m);
	}
	
	public void verMensajesEnviados() {
		for (Mensaje m: enviados) {
			System.out.println(m);
		}
	}
	public void verMensajesRecibidos() {
		for (Mensaje m: recibidos) {
			System.out.println(m);
		}	
		}
	
	 public void verMensajesRecibidosDe(String emisor) {
	        for (Mensaje mensaje : recibidos) {
	            if (mensaje.getEmisor().equals(emisor)) {
	                System.out.println(mensaje);
	            }
	        }
	    }
	
}
