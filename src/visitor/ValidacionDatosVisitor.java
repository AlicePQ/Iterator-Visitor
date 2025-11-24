package visitor;

import dominio.Estudiante;
import dominio.Docente;

public class ValidacionDatosVisitor implements UsuarioVisitor {

    @Override
    public void visit(Estudiante e) {
        if (!e.datosCompletos()) {
            System.out.println("Estudiante " + e.getCodigo()
                + " tiene datos incompletos. Notificar.");
        }
    }

    @Override
    public void visit(Docente d) {
        if (!d.datosCompletos()) {
            System.out.println("Docente " + d.getCodigo()
                + " tiene datos incompletos. Notificar.");
        } else if (!d.codigoValido4Digitos()) {
            System.out.println("Docente " + d.getCodigo()
                + " tiene código inválido (>4 dígitos). Notificar.");
        }
    }
}

