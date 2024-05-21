package entorrnos;

public class SMS extends Mensaje {
	private String texto;
	
	public SMS (int e, int r, String texto) {
		super(e,r);
		this.texto=texto;
	}

	@Override
	public String toString() {
		return "SMS: "+ texto;
	}
	
}
