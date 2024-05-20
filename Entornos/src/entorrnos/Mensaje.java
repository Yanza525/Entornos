package entorrnos;

public abstract class Mensaje {
	private String emisor;
	private String receptor;
	
	public Mensaje (String e, String r) {
		this.emisor=e;
		this.receptor=r;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getReceptor() {
		return receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	@Override
	public abstract String toString();
}
