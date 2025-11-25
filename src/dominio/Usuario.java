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
    public String getDireccion() { return direccion; }
    public List<String> getTelefonos() { return telefonos; }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefonos(List<String> telefonos) {
        this.telefonos = telefonos;
    }

    public boolean datosCompletos() {
        return codigo != null && !codigo.isBlank()
            && nombre != null && !nombre.isBlank()
            && direccion != null && !direccion.isBlank()
            && telefonos != null && !telefonos.isEmpty();
    }

    public abstract void accept(UsuarioVisitor v);
}
