package entorrnos;

import java.util.ArrayList;
import java.util.List;

public class ClasesdePrueba {
	//HOLA
//Este será el esqueleto de la app que usaremos para crear los Junit
	public static class Usuario {
		private String telefono;
		private List<Mensaje> enviados;
		private List<Mensaje> recibidos;

		public Usuario (String telefono) {
			if (telefono == null || telefono.isEmpty() || !telefono.matches("\\d{9}")) {
				throw new IllegalArgumentException ("Numero dde telefono invalido");
			}
			
			this.telefono= telefono;
			this.enviados = new ArrayList<>();
			this.recibidos= new ArrayList<>();
			
		}
		public String getTelefono() {
			return telefono;
		}
		public void enviarMensaje (Mensaje mensaje) {
			this.enviados.add(mensaje);
		}
		
		public void recibirMensaje (Mensaje mensaje) {
			this.recibidos.add(mensaje);
		}
		
		public List<Mensaje> getMensajes(){
			List <Mensaje> todosLosMensajes = new ArrayList<>();
			todosLosMensajes.addAll(recibidos);
			return todosLosMensajes;
		}
	}
	
	public static abstract class Mensaje {
		protected Usuario emisor;
		protected Usuario receptor;
		
		public Mensaje (Usuario emisor, Usuario receptor) {
			this.emisor= emisor;
			this.receptor= receptor;
			
		}
		public Usuario getEmisor() {
			return emisor;
		}
		public Usuario getReceptor() {
			return receptor;
		}
	}
	
	public static class MensajeTexto extends Mensaje {
		private String texto;
		public MensajeTexto (Usuario emisor, Usuario receptor, String texto) {
			super(emisor,receptor);
			if (texto==null || texto.isEmpty()) {
				throw new IllegalArgumentException ("El texto está vacio");
				
			}
			this.texto= texto ;
		}
		
		public String getTexto () {
			return texto;
		}
	}
}
