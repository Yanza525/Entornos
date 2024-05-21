package entorrnos;

public abstract class Mensaje {
	private int emisor;
	private int receptor;
	
	public Mensaje (int e, int r) {
		this.emisor=e;
		this.receptor=r;
	}

	public int getEmisor() {
		return emisor;
	}

	public void setEmisor(int emisor) {
		this.emisor = emisor;
	}

	public int getReceptor() {
		return receptor;
	}

	public void setReceptor(int receptor) {
		this.receptor = receptor;
	}

	@Override
	public abstract String toString();
}
