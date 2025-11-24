package coleccion;

import dominio.Usuario;
import iterator.Iterator;
import iterator.IteratorPorCodigo;
import iterator.IteratorPorNombre;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Comparator;

public class RepositorioUsuarios implements UsuarioCollection {

    private TreeSet<Usuario> porCodigo;
    private ArrayList<Usuario> porNombre;

    public RepositorioUsuarios(Comparator<Usuario> compCodigo,
                               Comparator<Usuario> compNombre) {
        this.porCodigo = new TreeSet<>(compCodigo);
        this.porNombre = new ArrayList<>();
        // el orden porNombre lo defines tú (inserción o sort por nombre)
    }

    public void agregar(Usuario u) {
        porCodigo.add(u);
        porNombre.add(u);
    }

    @Override
    public Iterator<Usuario> createIteratorPorCodigo() {
        return new IteratorPorCodigo(porCodigo);
    }

    @Override
    public Iterator<Usuario> createIteratorPorNombre() {
        return new IteratorPorNombre(porNombre);
    }
}
