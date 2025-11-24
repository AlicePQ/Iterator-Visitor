package dominio;

import visitor.UsuarioVisitor;

public class Estudiante extends Usuario {

    @Override
    public void accept(UsuarioVisitor v) {
        v.visit(this);
    }
}
