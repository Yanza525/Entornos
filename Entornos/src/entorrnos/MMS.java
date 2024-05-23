package entorrnos;

/**
 * La clase MMS representa un mensaje multimedia que hereda de la clase Mensaje.
 */
public class MMS extends Mensaje {
    private String nombreArchivo;
    private String tamaño;

    /**
     * Constructor que inicializa un MMS con el emisor, receptor, nombre del archivo y tamaño del archivo.
     *
     * @param i el número de teléfono del emisor
     * @param destinatario el número de teléfono del receptor
     * @param n el nombre del archivo multimedia
     * @param tamaño el tamaño del archivo multimedia
     */
    public MMS(int i, int destinatario, String n, String tamaño) {
        super(i, destinatario);
        this.nombreArchivo = n;
        this.tamaño = tamaño;
    }

    /**
     * Devuelve una representación en cadena del MMS.
     *
     * @return una cadena que representa el MMS
     */
    @Override
    public String toString() {
        return "MMS: Archivo --> " + nombreArchivo + " , tamaño --> " + tamaño;
    }
}
