package entorrnos;

public class MMS extends Mensaje{
	private String nombreArchivo;
	private String tamaño;
	
	public MMS (String e, String r,String n, String t) {
		super(e,r);
		this.nombreArchivo=n;
		this.tamaño=t;
	}

	@Override
	public String toString() {
		
		return "MMS: Archivo--> " + nombreArchivo+ " , tamaño --> "+ tamaño;
	}

}
