package bugsbusters.lucatickets.pagos.controller.error;

public enum CodigoError {
    FONDOS("400.0001", "No hay fondos suficientes en la cuenta"),
    CLIENTE("400.0002", "No se encuentran los datos del cliente"),
    NUMERO("400.0003", "El número de la tarjeta no es válido"),
    CVV("400.0004", "El formato del CVV no es válido"),
    MES("400.0005", "El mes (caducidad) no es correcto"),
    ANO("400.0006", "El año (caducidad) no es correcto"),
    FECHA("400.0007", "La fecha de caducidad debe ser posterior al día actual"),
    NOMBRE("400.0008", "El formato del nombre no es correcto"),
    SISTEMA("500.0001", "El sistema se encuentra inestable");

    private final String codigo;
    private final String mensaje;

    CodigoError(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }
}
