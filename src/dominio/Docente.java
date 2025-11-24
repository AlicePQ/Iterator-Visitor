package dominio;

import visitor.UsuarioVisitor;

public class Docente extends Usuario {

    public boolean codigoValido4Digitos() {
        return codigo != null && codigo.matches("\\d{1,4}");
    }

    @Override
    public void accept(UsuarioVisitor v) {
        v.visit(this);
    }
}
