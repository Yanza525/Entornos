package entorrnos;

import java.util.List;

/**
 * La clase Administrador representa a un administrador que hereda de la clase Usuario.
 * Un administrador tiene una lista de usuarios que puede gestionar.
 */
public class Administrador extends Usuario {
    private List<Usuario> usuarios;

    /**
     * Constructor que inicializa un administrador con un número de teléfono y una lista de usuarios.
     *
     * @param t el número de teléfono del administrador
     * @param usuarios la lista de usuarios gestionados por el administrador
     */
    public Administrador(int t, List<Usuario> usuarios) {
        super(t);
        this.setUsuarios(usuarios);
    }

    /**
     * Obtiene la lista de usuarios gestionados por el administrador.
     *
     * @return la lista de usuarios
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Establece la lista de usuarios gestionados por el administrador.
     *
     * @param usuarios la nueva lista de usuarios
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Muestra todos los mensajes enviados por todos los usuarios gestionados por el administrador.
     */
    @Override
    public void verMensajesEnviados() {
        for (Usuario usuario : usuarios) {
            usuario.verMensajesEnviados();
        }
    }

    /**
     * Muestra todos los mensajes recibidos por todos los usuarios gestionados por el administrador.
     */
    @Override
    public void verMensajesRecibidos() {
        for (Usuario usuario : usuarios) {
            usuario.verMensajesRecibidos();
        }
    }

    /**
     * Muestra todos los mensajes recibidos de un emisor específico por todos los usuarios gestionados por el administrador.
     *
     * @param emisor el número de teléfono del emisor
     */
    @Override
    public void verMensajesRecibidosDe(int emisor) {
        for (Usuario usuario : usuarios) {
            usuario.verMensajesRecibidosDe(emisor);
        }
    }

    /**
     * Muestra todos los mensajes enviados y recibidos por un usuario específico.
     *
     * @param t el número de teléfono del usuario
     */
    public void verMensajesDe(int t) {
        for (Usuario usuario : usuarios) {
            if (usuario.getTelefono() == t) {
                System.out.println("Mensajes enviados por " + t + ":");
                usuario.verMensajesEnviados();
                System.out.println("Mensajes recibidos por " + t + ":");
                usuario.verMensajesRecibidos();
                return;
            }
        }
        System.out.println("Usuario no encontrado");
    }
}

