package coleccion;

import dominio.Usuario;
import iterator.Iterator;

public interface UsuarioCollection {
    Iterator<Usuario> createIteratorPorCodigo();
    Iterator<Usuario> createIteratorPorNombre();
}
