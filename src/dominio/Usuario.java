package dominio;

import java.util.List;
import visitor.UsuarioVisitor;

public abstract class Usuario {
    protected String codigo;
    protected String nombre;
    protected String direccion;
    protected List<String> telefonos;

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }

    public boolean datosCompletos() {
        return codigo != null && !codigo.isBlank()
            && nombre != null && !nombre.isBlank()
            && direccion != null && !direccion.isBlank()
            && telefonos != null && !telefonos.isEmpty();
    }

    public abstract void accept(UsuarioVisitor v);
}
