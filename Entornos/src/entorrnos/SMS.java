package entorrnos;

public class SMS extends Mensaje {
	private String texto;
	public SMS (Usuario emisor, Usuario receptor, String texto) {
		super (emisor, receptor);
		this.texto=texto;
	}
}
