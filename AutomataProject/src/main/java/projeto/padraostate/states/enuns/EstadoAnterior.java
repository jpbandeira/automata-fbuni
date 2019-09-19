package projeto.padraostate.states.enuns;

public enum EstadoAnterior {
	
	PEDIDONOVO("Pedido Novo", 1),
	PAGAMENTOREALIZADO("Pagamento Realizado", 2),
	APROVADO("Aprovado", 3);	
	
	private String descricao;
	private Integer codigo;
    
    private EstadoAnterior(String descricao ,int codigo) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static  EstadoAnterior toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }

        for(EstadoAnterior estadoAnterior : EstadoAnterior.values()){
            if (codigo.equals(estadoAnterior.getCodigo())){
                return  estadoAnterior;
            }
        }

        throw new IllegalArgumentException("Id invalido: " + codigo);
    }

	
}
