package app;

import coleccion.RepositorioUsuarios;
import coleccion.UsuarioCollection;
import dominio.Docente;
import dominio.Estudiante;
import dominio.Usuario;
import iterator.Iterator;
import visitor.UsuarioVisitor;
import visitor.ValidacionDatosVisitor;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {

        // Repositorio configurado con comparadores por código y por nombre
        UsuarioCollection col = new RepositorioUsuarios(
            Comparator.comparing(Usuario::getCodigo),
            Comparator.comparing(Usuario::getNombre)
        );

        // === 1. RECOLECCIÓN DE DATOS DESDE CONSOLA ===
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos usuarios desea registrar? ");
        int cantidad = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n=== Registro de usuario " + (i + 1) + " ===");

            // Tipo de usuario: Estudiante o Docente
            char tipo;
            while (true) {
                System.out.print("Tipo de usuario (E = Estudiante, D = Docente): ");
                String lineaTipo = sc.nextLine().trim().toUpperCase();
                if (lineaTipo.length() == 1 && (lineaTipo.charAt(0) == 'E' || lineaTipo.charAt(0) == 'D')) {
                    tipo = lineaTipo.charAt(0);
                    break;
                } else {
                    System.out.println("Opción inválida. Ingrese 'E' o 'D'.");
                }
            }

            // Datos comunes
            System.out.print("Código: ");
            String codigo = sc.nextLine().trim();

            System.out.print("Nombre: ");
            String nombre = sc.nextLine().trim();

            System.out.print("Dirección: ");
            String direccion = sc.nextLine().trim();

            System.out.print("Teléfonos (separados por coma): ");
            String telLinea = sc.nextLine().trim();

            List<String> telefonos = new ArrayList<>();
            if (!telLinea.isBlank()) {
                String[] partes = telLinea.split(",");
                for (String t : partes) {
                    String tel = t.trim();
                    if (!tel.isBlank()) {
                        telefonos.add(tel);
                    }
                }
            }

            // Crear el objeto correspondiente (Estudiante o Docente)
            Usuario u;

            if (tipo == 'E') {
                Estudiante e = new Estudiante();
                e.setCodigo(codigo);
                e.setNombre(nombre);
                e.setDireccion(direccion);
                e.setTelefonos(telefonos);
                u = e;
            } else {
                Docente d = new Docente();
                d.setCodigo(codigo);
                d.setNombre(nombre);
                d.setDireccion(direccion);
                d.setTelefonos(telefonos);
                // La regla de los 4 dígitos se valida luego con el Visitor (o dentro de Docente)
                u = d;
            }

            // Agregar al repositorio
            col.agregar(u);
        }

        // === 2. APLICAR VISITOR PARA VALIDAR Y NOTIFICAR ===
        UsuarioVisitor visitor = new ValidacionDatosVisitor();

        System.out.println("\n=== Validación por CÓDIGO ===");
        Iterator<Usuario> itCodigo = col.createIteratorPorCodigo();
        while (itCodigo.hasMore()) {
            Usuario u = itCodigo.getNext();
            u.accept(visitor);  // ejecuta visit(Estudiante) o visit(Docente)
        }

        System.out.println("\n=== Validación por NOMBRE ===");
        Iterator<Usuario> itNombre = col.createIteratorPorNombre();
        while (itNombre.hasMore()) {
            Usuario u = itNombre.getNext();
            u.accept(visitor);
        }

        sc.close();
    }
}
