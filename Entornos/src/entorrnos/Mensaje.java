package entorrnos;

/**
 * La clase Mensaje representa un mensaje genérico con un emisor y un receptor.
 */
public abstract class Mensaje {
    private int emisor;
    private int receptor;

    /**
     * Constructor que inicializa un mensaje con el emisor y receptor.
     *
     * @param e el número de teléfono del emisor
     * @param r el número de teléfono del receptor
     */
    public Mensaje(int e, int r) {
        this.emisor = e;
        this.receptor = r;
    }

    /**
     * Obtiene el número de teléfono del emisor del mensaje.
     *
     * @return el número de teléfono del emisor
     */
    public int getEmisor() {
        return emisor;
    }

    /**
     * Establece el número de teléfono del emisor del mensaje.
     *
     * @param emisor el nuevo número de teléfono del emisor
     */
    public void setEmisor(int emisor) {
        this.emisor = emisor;
    }

    /**
     * Obtiene el número de teléfono del receptor del mensaje.
     *
     * @return el número de teléfono del receptor
     */
    public int getReceptor() {
        return receptor;
    }

    /**
     * Establece el número de teléfono del receptor del mensaje.
     *
     * @param receptor el nuevo número de teléfono del receptor
     */
    public void setReceptor(int receptor) {
        this.receptor = receptor;
    }

    /**
     * Devuelve una representación en cadena del mensaje.
     *
     * @return una cadena que representa el mensaje
     */
    @Override
    public abstract String toString();
}

