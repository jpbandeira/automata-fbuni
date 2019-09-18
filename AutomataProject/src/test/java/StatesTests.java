import org.junit.Before;
import org.junit.Test;
import projeto.padraostate.states.*;

import static org.junit.Assert.*;

public class StatesTests {

    private PedidoNovo pedidoNovo;
    private PagamentoRealizado pagamentoRealizado;
    private Aprovado aprovado;
    private Trasportado trasportado;
    private Entregue entregue;
    private Impedido impedido;
    private Cancelado cancelado;
    private Finalizado finalizado;

    @Before
    public void before(){
        this.pedidoNovo = new PedidoNovo();
        this.pagamentoRealizado = new PagamentoRealizado();
        this.aprovado = new Aprovado();
        this.trasportado = new Trasportado();
        this.entregue = new Entregue();
        this.impedido = new Impedido();
        this.cancelado = new Cancelado();
        this.finalizado = new Finalizado();
    }

    @Test
    public void teste(){
        assertEquals("", "");
    }

}
