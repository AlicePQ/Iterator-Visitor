package coleccion;

import dominio.Usuario;
import iterator.Iterator;

public interface UsuarioCollection {

    void agregar(Usuario u);
    Iterator<Usuario> createIteratorPorCodigo();
    Iterator<Usuario> createIteratorPorNombre();
}
