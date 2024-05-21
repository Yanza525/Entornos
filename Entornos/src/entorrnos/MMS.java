package entorrnos;

public class MMS extends Mensaje{
	private String nombreArchivo;
	private String tamaño;
	
	public MMS (int i, int destinatario,String n, String tamano) {
		super(i,destinatario);
		this.nombreArchivo=n;
		this.tamaño=tamano;
	}

	@Override
	public String toString() {
		
		return "MMS: Archivo--> " + nombreArchivo+ " , tamaño --> "+ tamaño;
	}

}
