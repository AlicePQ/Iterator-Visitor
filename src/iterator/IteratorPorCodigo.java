package iterator;

import dominio.Usuario;
import java.util.TreeSet;

public class IteratorPorCodigo implements iterator.Iterator<Usuario> {

    private java.util.Iterator<Usuario> interno;

    public IteratorPorCodigo(TreeSet<Usuario> coleccion) {
        this.interno = coleccion.iterator();
    }

    @Override
    public boolean hasMore() {
        return interno.hasNext();
    }

    @Override
    public Usuario getNext() {
        return interno.next();
    }
}
