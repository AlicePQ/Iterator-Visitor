package visitor;

import dominio.Estudiante;
import dominio.Docente;

public interface UsuarioVisitor {
    void visit(Estudiante e);
    void visit(Docente d);
}
