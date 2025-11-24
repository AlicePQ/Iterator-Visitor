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

public class Cliente {

    public static void main(String[] args) {

        UsuarioCollection col = new RepositorioUsuarios(
            Comparator.comparing(Usuario::getCodigo),
            Comparator.comparing(Usuario::getNombre)
        );

        Estudiante e1 = new Estudiante();
        // settear campos...

        Docente d1 = new Docente();
        // settear campos...

        col.agregar(e1);
        col.agregar(d1);

        UsuarioVisitor visitor = new ValidacionDatosVisitor();

        // Recorrido por código
        Iterator<Usuario> itCodigo = col.createIteratorPorCodigo();
        while (itCodigo.hasMore()) {
            Usuario u = itCodigo.getNext();
            u.accept(visitor);
        }

        // Recorrido por nombre (si quieres usarlo también)
        Iterator<Usuario> itNombre = col.createIteratorPorNombre();
        while (itNombre.hasMore()) {
            Usuario u = itNombre.getNext();
            u.accept(visitor);
        }
    }
}
