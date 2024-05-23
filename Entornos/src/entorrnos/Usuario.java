package entorrnos;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Usuario representa a un usuario con un número de teléfono, nombre y listas de mensajes enviados y recibidos.
 */
public class Usuario {
    private int telefono;
    private String nombre;
    private List<Mensaje> enviados = new ArrayList<>();
    private List<Mensaje> recibidos = new ArrayList<>();

    /**
     * Constructor que inicializa un usuario con un número de teléfono y nombre.
     *
     * @param t el número de teléfono del usuario
     * @param n el nombre del usuario
     */
    public Usuario(int t, String n) {
        this.telefono = t;
        this.nombre = n;
        this.enviados = new ArrayList<>();
        this.recibidos = new ArrayList<>();
    }

    /**
     * Constructor que inicializa un usuario solo con un número de teléfono.
     *
     * @param t el número de teléfono del usuario
     */
    public Usuario(int t) {
        this.telefono = t;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     *
     * @return el número de teléfono del usuario
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuario.
     *
     * @param telefono el nuevo número de teléfono del usuario
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return el nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre el nuevo nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de mensajes enviados por el usuario.
     *
     * @return la lista de mensajes enviados
     */
    public List<Mensaje> getEnviados() {
        return enviados;
    }

    /**
     * Establece la lista de mensajes enviados por el usuario.
     *
     * @param enviados la nueva lista de mensajes enviados
     */
    public void setEnviados(List<Mensaje> enviados) {
        this.enviados = enviados;
    }

    /**
     * Obtiene la lista de mensajes recibidos por el usuario.
     *
     * @return la lista de mensajes recibidos
     */
    public List<Mensaje> getRecibidos() {
        return recibidos;
    }

    /**
     * Establece la lista de mensajes recibidos por el usuario.
     *
     * @param recibidos la nueva lista de mensajes recibidos
     */
    public void setRecibidos(List<Mensaje> recibidos) {
        this.recibidos = recibidos;
    }

    /**
     * Envía un mensaje y lo agrega a la lista de mensajes enviados.
     *
     * @param m el mensaje a enviar
     */
    public void enviarMensaje(Mensaje m) {
        enviados.add(m);
    }

    /**
     * Recibe un mensaje y lo agrega a la lista de mensajes recibidos.
     *
     * @param m el mensaje a recibir
     */
    public void recibirMensaje(Mensaje m) {
        recibidos.add(m);
    }

    /**
     * Muestra todos los mensajes enviados por el usuario.
     */
    public void verMensajesEnviados() {
        for (Mensaje m : enviados) {
            System.out.println(m);
        }
    }

    /**
     * Muestra todos los mensajes recibidos por el usuario.
     */
    public void verMensajesRecibidos() {
        for (Mensaje m : recibidos) {
            System.out.println(m);
        }
    }

    /**
     * Muestra todos los mensajes recibidos por el usuario de un emisor específico.
     *
     * @param emisor el número de teléfono del emisor
     */
    public void verMensajesRecibidosDe(int emisor) {
        for (Mensaje mensaje : recibidos) {
            if (mensaje.getEmisor() == emisor) {
                System.out.println(mensaje);
            }
        }
    }
}

