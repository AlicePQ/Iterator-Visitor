package visitor;

import dominio.Estudiante;
import dominio.Docente;

public class ValidacionDatosVisitor implements UsuarioVisitor {

    @Override
    public void visit(Estudiante e) {
        if (!e.datosCompletos()) {
            System.out.println("Estudiante " + e.getCodigo()
                + " tiene datos incompletos. Notificar.");
        } else {
            String telefonos = (e.getTelefonos() == null || e.getTelefonos().isEmpty())
                ? "ninguno" : String.join(", ", e.getTelefonos());
            System.out.println("Validación exitosa: Estudiante agregado -> "
                + e.getCodigo() + " | Nombre: " + e.getNombre()
                + " | Dirección: " + e.getDireccion()
                + " | Teléfonos: " + telefonos);
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
        } else {
            String telefonos = (d.getTelefonos() == null || d.getTelefonos().isEmpty())
                ? "ninguno" : String.join(", ", d.getTelefonos());
            System.out.println("Validación exitosa: Docente agregado -> "
                + d.getCodigo() + " | Nombre: " + d.getNombre()
                + " | Dirección: " + d.getDireccion()
                + " | Teléfonos: " + telefonos);
        }
    }
}

