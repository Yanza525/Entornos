package entorrnos;

public abstract class Mensaje {
	private Usuario emisor;
	private Usuario receptor;
	public Mensaje(Usuario emisor, Usuario receptor) {
		this.emisor=emisor;
		this.receptor=receptor;
	}
}
