package entorrnos;

/**
 * La clase MMS representa un mensaje multimedia que hereda de la clase Mensaje.
 */
public class MMS extends Mensaje {
    private String nombreArchivo;
    private String tamanio;

    /**
     * Constructor que inicializa un MMS con el emisor, receptor, nombre del archivo y tamanio del archivo.
     *
     * @param i el número de teléfono del emisor
     * @param destinatario el número de teléfono del receptor
     * @param n el nombre del archivo multimedia
     * @param tamanio el tamanio del archivo multimedia
     */
    public MMS(int i, int destinatario, String n, String tamanio) {
        super(i, destinatario);
        this.nombreArchivo = n;
        this.tamanio = tamanio;
    }

    public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	/**
     * Devuelve una representación en cadena del MMS.
     *
     * @return una cadena que representa el MMS
     */
    @Override
    public String toString() {
        return "MMS: Archivo --> " + nombreArchivo + " , tamanio --> " + tamanio;
    }
}
