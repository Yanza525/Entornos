package entorrnos;

/**
 * La clase SMS representa un mensaje de texto que hereda de la clase Mensaje.
 */
public class SMS extends Mensaje {
    private String texto;

    /**
     * Constructor que inicializa un SMS con el emisor, receptor y el texto del mensaje.
     *
     * @param e el número de teléfono del emisor
     * @param r el número de teléfono del receptor
     * @param texto el contenido del mensaje de texto
     */
    public SMS(int e, int r, String texto) {
        super(e, r);
        this.texto = texto;
    }
    
    public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
     * Devuelve una representación en cadena del SMS.
     *
     * @return una cadena que representa el SMS
     */
    @Override
    public String toString() {
        return "SMS: " + texto;
    }
}

