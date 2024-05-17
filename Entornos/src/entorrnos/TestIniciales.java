package entorrnos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestIniciales {
	private ClasesdePrueba.Usuario usuario1;
	private ClasesdePrueba.Usuario usuario2;
	private ClasesdePrueba.MensajeTexto mensaje1;
	private ClasesdePrueba.MensajeTexto mensaje2;

	@Before
	public void setUp() {
		usuario1 = new ClasesdePrueba.Usuario("65698111");
		usuario1 = new ClasesdePrueba.Usuario("65698222");
		mensaje1 = new ClasesdePrueba.MensajeTexto(usuario1, usuario2, "Mensaje de prueba 1");
		mensaje2 = new ClasesdePrueba.MensajeTexto(usuario2, usuario1, "Mensaje de prueba 2");

		usuario1.enviarMensaje(mensaje1);
		usuario2.recibirMensaje(mensaje1);

		usuario2.enviarMensaje(mensaje2);
		usuario1.recibirMensaje(mensaje2);
	}

	// Test para enviar mensajes

	@Test
	public void testMensajeSMS() {
		ClasesdePrueba.MensajeTexto mensajeSMS = new ClasesdePrueba.MensajeTexto(usuario1, usuario2,
				"Hola, ¿cómo estás?");
		usuario1.enviarMensaje(mensajeSMS);
		assertEquals(3, usuario1.getMensajes().size());
		assertEquals(usuario2, mensajeSMS.getReceptor());
		assertEquals("Hola, ¿cómo estás?", mensajeSMS.getTexto());
	}

	@Test
	public void testFalloNoReceptor() {
		ClasesdePrueba.Usuario usuario3 = new ClasesdePrueba.Usuario("333333333");
		ClasesdePrueba.MensajeTexto mensajeSMS = new ClasesdePrueba.MensajeTexto(usuario1, usuario3,
				"Hola, ¿cómo estás?");
		usuario1.enviarMensaje(mensajeSMS);
	}

	@Test
	public void testFalloNoEmisor() {
		ClasesdePrueba.Usuario usuario3 = new ClasesdePrueba.Usuario("333333333");
		ClasesdePrueba.MensajeTexto mensajeSMS = new ClasesdePrueba.MensajeTexto(usuario3, usuario2,
				"Hola, ¿cómo estás?");
		usuario3.enviarMensaje(mensajeSMS);
	}

	// Test para ver mis mensajes

	@Test
	public void testVerMisMensajes() {
		List<ClasesdePrueba.Mensaje> mensajes = usuario1.getMensajes();
		assertNotNull(mensajes);
		assertEquals(2, mensajes.size());
	}

	@Test
	public void testFalloUsuarioVacio() {
		new ClasesdePrueba.Usuario("");
	}

	@Test
	public void testFalloUsuarioNoNumerico() {
		new ClasesdePrueba.Usuario("abcd");
	}

	@Test
	public void testFalloUsuarioLongitud() {
		new ClasesdePrueba.Usuario("1234");
	}

	@Test
	public void testMensajeSinMEnsaje() {
		ClasesdePrueba.Usuario usuario3 = new ClasesdePrueba.Usuario("333333333");
		List<ClasesdePrueba.Mensaje> mensajes = usuario3.getMensajes();
		assertNotNull(mensajes);
		assertEquals(0, mensajes.size());
	}

}