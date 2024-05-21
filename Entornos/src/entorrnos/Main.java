package entorrnos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
    	 System.out.print("Ingrese su número de teléfono: ");
         int numeroTelefono = Integer.parseInt(scanner.nextLine());

         Usuario usuario = buscarUsuarioPorTelefono(numeroTelefono);

         if (usuario != null) {
             manejarUsuario(usuario);
         } else if (numeroTelefono == 0) { // Usamos 0 como código para administrador
             Administrador admin = new Administrador(0, usuarios);
             manejarAdministrador(admin);
         } else {
             System.out.println("Número de teléfono no registrado. Registrando nuevo usuario...");
             usuario = new Usuario(numeroTelefono);
             usuarios.add(usuario);
             manejarUsuario(usuario);
         }
    }

   

    private static Usuario buscarUsuarioPorTelefono(int numeroTelefono) {
        for (Usuario usuario : usuarios) {
            if (usuario.getTelefono() == numeroTelefono) {
                return usuario;
            }
        }
        return null;
    }

    private static void manejarUsuario(Usuario usuario) {
        int opcion;
        do {
            System.out.println("\nMenú de Usuario");
            System.out.println("1. Enviar mensaje");
            System.out.println("2. Ver mensajes enviados");
            System.out.println("3. Ver mensajes recibidos");
            System.out.println("4. Ver mensajes recibidos de un emisor concreto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    enviarMensaje(usuario);
                    break;
                case 2:
                    usuario.verMensajesEnviados();
                    break;
                case 3:
                    usuario.verMensajesRecibidos();
                    break;
                case 4:
                    System.out.print("Ingrese el número del emisor: ");
                    int emisor = Integer.parseInt(scanner.nextLine());
                    usuario.verMensajesRecibidosDe(emisor);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void manejarAdministrador(Administrador admin) {
        int opcion;
        do {
            System.out.println("\nMenú de Administrador");
            System.out.println("1. Enviar mensaje");
            System.out.println("2. Ver mensajes enviados");
            System.out.println("3. Ver mensajes recibidos");
            System.out.println("4. Ver mensajes recibidos de un emisor concreto");
            System.out.println("5. Ver mensajes de un usuario específico");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese su número de teléfono (admin): ");
                    int remitente = Integer.parseInt(scanner.nextLine());
                    Usuario usuario = new Usuario(remitente);
                    enviarMensaje(usuario);
                    break;
                case 2:
                    admin.verMensajesEnviados();
                    break;
                case 3:
                    admin.verMensajesRecibidos();
                    break;
                case 4:
                    System.out.print("Ingrese el número del emisor: ");
                    int emisor = Integer.parseInt(scanner.nextLine());
                    admin.verMensajesRecibidosDe(emisor);
                    break;

                case 5:
                    System.out.print("Ingrese el número del usuario: ");
                    int numeroUsuario = Integer.parseInt(scanner.nextLine());
                    admin.verMensajesDe(numeroUsuario);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void enviarMensaje(Usuario usuario) {
        System.out.print("Ingrese el número de teléfono del destinatario: ");
        int destinatario = Integer.parseInt(scanner.nextLine());
        System.out.println("Seleccione el tipo de mensaje:");
        System.out.println("1. SMS");
        System.out.println("2. MMS");
        int tipo = Integer.parseInt(scanner.nextLine());

        if (tipo == 1) {
            System.out.print("Ingrese el texto del mensaje: ");
            String contenido = scanner.nextLine();
            SMS sms = new SMS(usuario.getTelefono(), destinatario, contenido);
            usuario.enviarMensaje(sms);
            // Agregar el mensaje a los recibidos del destinatario si está en la agenda
            Usuario receptor = buscarUsuarioPorTelefono(destinatario);
            if (receptor != null) {
                receptor.recibirMensaje(sms);
            }
        } else if (tipo == 2) {
            System.out.print("Ingrese el nombre del archivo: ");
            String nombreArchivo = scanner.nextLine();
            System.out.print("Ingrese el tamaño del archivo (KB): ");
            String tamano = scanner.nextLine();
            MMS mms = new MMS(usuario.getTelefono(), destinatario, nombreArchivo, tamano);
            usuario.enviarMensaje(mms);
            // Agregar el mensaje a los recibidos del destinatario si está en la agenda
            Usuario receptor = buscarUsuarioPorTelefono(destinatario);
            if (receptor != null) {
                receptor.recibirMensaje(mms);
            }
        } else {
            System.out.println("Tipo de mensaje inválido.");
        }
    }
}
