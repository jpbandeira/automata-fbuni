import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import projeto.padraostate.pedido.Pedido;
import projeto.padraostate.states.*;
import projeto.padraostate.states.enuns.EstadoAnterior;

import javax.swing.text.DefaultStyledDocument;

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
    private Pedido pedido;

    @Before
    public void before(){
        this.pedido = new Pedido();
        this.pedidoNovo = new PedidoNovo();
        this.pagamentoRealizado = new PagamentoRealizado();
        this.aprovado = new Aprovado();
        this.trasportado = new Trasportado();
        this.entregue = new Entregue();
        this.impedido = new Impedido();
        this.cancelado = new Cancelado();
        this.finalizado = new Finalizado();
    }

    @After
    public void after(){
        System.out.println("Teste finalizado");
    }

    @Test
    public void testeDeCadeiaSemImpedimento(){
        pedidoNovo.seguirFluxo(pedido);
        pagamentoRealizado.seguirFluxo(pedido);
        aprovado.seguirFluxo(pedido);
        trasportado.seguirFluxo(pedido);
        entregue.seguirFluxo(pedido);

        assertEquals( true, pedido.getEstadoFinal());
    }

    @Test
    public void testeDeCadeiaImpedidaEmPedidoNovoSemSeguirFluxoCompleto(){
        pedidoNovo.impedir(pedido);

        assertEquals("Quando o estado pedido novo foi impedido, o mesmo deve ser setado como estado anterior"
                ,EstadoAnterior.PEDIDONOVO, pedido.getEstadoAnterior());
        assertEquals( "Quando o estado pedido novo foi impedido, o mesmo não deve ser estado final e a não sera aceita"
                ,false, pedido.getEstadoFinal());
    }

    @Test
    public void testeDeCadeiaImpedidaEmPedidoNovoSeguindoFluxoCompleto(){
        pedidoNovo.impedir(pedido);
        impedido.voltarFluxo(pedido);
        pedidoNovo.seguirFluxo(pedido);
        pagamentoRealizado.seguirFluxo(pedido);
        aprovado.seguirFluxo(pedido);
        trasportado.seguirFluxo(pedido);
        entregue.seguirFluxo(pedido);

        assertEquals("Quando o estado pedido novo for impedido e o seguir seu fluxo completo, o ultimo estado tem que ser o final e retornar true," +
                true, pedido.getEstadoFinal());
    }
}
