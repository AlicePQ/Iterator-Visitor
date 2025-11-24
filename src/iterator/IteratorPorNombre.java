package iterator;

import dominio.Usuario;
import java.util.ArrayList;

public class IteratorPorNombre implements iterator.Iterator<Usuario> {

    private ArrayList<Usuario> coleccion;
    private int posicion = 0;

    public IteratorPorNombre(ArrayList<Usuario> coleccion) {
        // aquí podrías ordenar por nombre si quieres
        this.coleccion = coleccion;
    }

    @Override
    public boolean hasMore() {
        return posicion < coleccion.size();
    }

    @Override
    public Usuario getNext() {
        return coleccion.get(posicion++);
    }
}
