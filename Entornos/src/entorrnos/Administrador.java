package entorrnos;

import java.util.List;

public class Administrador extends Usuario {
private List <Usuario> usuarios;

	public Administrador(int t, List <Usuario> usuarios) {
		super(t);
		this.setUsuarios(usuarios);
	}

	public List <Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List <Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
    public void verMensajesEnviados() {
        for (Usuario usuario : usuarios) {
            usuario.verMensajesEnviados();
        }
    }

    @Override
    public void verMensajesRecibidos() {
        for (Usuario usuario : usuarios) {
            usuario.verMensajesRecibidos();
        }
    }

    @Override
    public void verMensajesRecibidosDe(String emisor) {
        for (Usuario usuario : usuarios) {
            usuario.verMensajesRecibidosDe(emisor);
        }
    }

    
    public void verMensajesDe (int t) {
    	for (Usuario usuario: usuarios) {
    		if (usuario.getTelefono()==t) {
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
