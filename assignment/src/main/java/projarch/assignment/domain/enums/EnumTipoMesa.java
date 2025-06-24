package projarch.assignment.domain.enums;

public enum EnumTipoMesa {
    TABULEIRO(1),
    CARTAS(2);

    private final int codigo;
    EnumTipoMesa(int codigo) {
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
    }
    public static EnumTipoMesa fromCodigo(int codigo) {
        for (EnumTipoMesa tipo : EnumTipoMesa.values()) {
            if (tipo.getCodigo() == codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código inválido para EnumTipoMesa: " + codigo);
    }
    public static EnumTipoMesa fromString(String tipo) {
        for (EnumTipoMesa e : EnumTipoMesa.values()) {
            if (e.name().equalsIgnoreCase(tipo)) {
                return e;
            }
        }
        return null;
    }
}