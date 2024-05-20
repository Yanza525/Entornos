package entorrnos;

public class MMS extends Mensaje{
	private String nombreArchivo;
	private String tamaño;
	
	public MMS (Usuario emisor, Usuario receptor, String n, String t) {
		super(emisor, receptor);
		this.nombreArchivo=n;
		this.tamaño=t;
	}

}
