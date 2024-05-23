package entorrnos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestFinales {
    private Usuario usuario1;
    private Usuario usuario2;
    private Mensaje mensaje1;
    private Mensaje mensaje2;

    // Método que se ejecuta antes de cada prueba para inicializar los objetos
    @Before
    public void setUp() {
        usuario1 = new Usuario(65698111); // Inicializa usuario1 con un número de teléfono
        usuario2 = new Usuario(65698222); // Inicializa usuario2 con un número de teléfono
        mensaje1 = new SMS(usuario1.getTelefono(), usuario2.getTelefono(), "Mensaje de prueba 1"); // Crea un mensaje de usuario1 a usuario2
        mensaje2 = new SMS(usuario2.getTelefono(), usuario1.getTelefono(), "Mensaje de prueba 2"); // Crea un mensaje de usuario2 a usuario1

        usuario1.enviarMensaje(mensaje1); // usuario1 envía mensaje1
        usuario2.recibirMensaje(mensaje1); // usuario2 recibe mensaje1

        usuario2.enviarMensaje(mensaje2); // usuario2 envía mensaje2
        usuario1.recibirMensaje(mensaje2); // usuario1 recibe mensaje2
    }

    // Prueba para enviar un mensaje SMS y verificar los detalles
    @Test
    public void testMensajeSMS() {
        Mensaje mensajeSMS = new SMS(usuario1.getTelefono(), usuario2.getTelefono(), "Hola, ¿cómo estás?");
        usuario1.enviarMensaje(mensajeSMS); // usuario1 envía un nuevo mensaje
        assertEquals(2, usuario1.getEnviados().size()); // Verifica que usuario1 ha enviado 2 mensajes
        assertEquals(usuario2.getTelefono(), mensajeSMS.getReceptor()); // Verifica el receptor del mensaje
        assertEquals("Hola, ¿cómo estás?", ((SMS) mensajeSMS).getTexto()); // Verifica el texto del mensaje
    }

    // Prueba para enviar un mensaje a un usuario que no es parte del setUp inicial
    @Test
    public void testFalloNoReceptor() {
        Usuario usuario3 = new Usuario(333333333); // Inicializa un tercer usuario
        Mensaje mensajeSMS = new SMS(usuario1.getTelefono(), usuario3.getTelefono(), "Hola, ¿cómo estás?");
        usuario1.enviarMensaje(mensajeSMS); // usuario1 envía un mensaje a usuario3
        assertTrue(usuario1.getEnviados().contains(mensajeSMS)); // Verifica que el mensaje está en la lista de mensajes enviados por usuario1
    }

    // Prueba para enviar un mensaje de un usuario que no es parte del setUp inicial
    @Test
    public void testFalloNoEmisor() {
        Usuario usuario3 = new Usuario(333333333); // Inicializa un tercer usuario
        Mensaje mensajeSMS = new SMS(usuario3.getTelefono(), usuario2.getTelefono(), "Hola, ¿cómo estás?");
        usuario3.enviarMensaje(mensajeSMS); // usuario3 envía un mensaje a usuario2
        assertTrue(usuario3.getEnviados().contains(mensajeSMS)); // Verifica que el mensaje está en la lista de mensajes enviados por usuario3
    }

    // Prueba para verificar los mensajes recibidos por usuario1
    @Test
    public void testVerMisMensajes() {
        List<Mensaje> mensajes = usuario1.getRecibidos(); // Obtiene los mensajes recibidos por usuario1
        assertNotNull(mensajes); // Verifica que la lista de mensajes no es nula
        assertEquals(1, mensajes.size()); // Verifica que usuario1 ha recibido 1 mensaje
    }

    // Prueba para crear un usuario con un número de teléfono vacío (0)
    @Test
    public void testFalloUsuarioVacio() {
        Usuario usuarioVacio = new Usuario(0); // Crea un usuario con número de teléfono 0
        assertEquals(0, usuarioVacio.getTelefono()); // Verifica que el número de teléfono es 0
        assertNull(usuarioVacio.getNombre()); // Verifica que el nombre del usuario es null
    }

    // Prueba para crear un usuario con un valor no numérico, espera un fallo
    @Test
    public void testFalloUsuarioNoNumerico() {
        try {
            new Usuario(Integer.parseInt("abcd")); // Intenta crear un usuario con un valor no numérico
            fail("Expected NumberFormatException"); // Falla la prueba si no se lanza la excepción
        } catch (NumberFormatException e) {
            // La prueba pasa si se lanza NumberFormatException
        }
    }

    // Prueba para crear un usuario con un número de teléfono de longitud inválida
    @Test
    public void testFalloUsuarioLongitud() {
        Usuario usuarioCorto = new Usuario(1234); // Crea un usuario con un número de teléfono de longitud corta
        assertEquals(1234, usuarioCorto.getTelefono()); // Verifica el número de teléfono
        assertNull(usuarioCorto.getNombre()); // Verifica que el nombre del usuario es null
    }

    // Prueba para verificar que un usuario sin mensajes no tiene mensajes recibidos
    @Test
    public void testMensajeSinMensaje() {
        Usuario usuario3 = new Usuario(333333333); // Inicializa un tercer usuario
        List<Mensaje> mensajes = usuario3.getRecibidos(); // Obtiene los mensajes recibidos por usuario3
        assertNotNull(mensajes); // Verifica que la lista de mensajes no es nula
        assertEquals(0, mensajes.size()); // Verifica que usuario3 no ha recibido mensajes
    }
}
