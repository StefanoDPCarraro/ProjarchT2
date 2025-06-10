package projarch.assignment.domain.enums;

public enum EnumTipoEletronico {
    AVENTURA(1),
    ESTRATEGIA(2),
    SIMULACAO(3);
    private final int codigo;
    EnumTipoEletronico(int codigo) {
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
    }
    public static EnumTipoEletronico fromCodigo(int codigo) {
        for (EnumTipoEletronico tipo : EnumTipoEletronico.values()) {
            if (tipo.getCodigo() == codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código inválido para EnumTipoEletronico: " + codigo);
    }
}
