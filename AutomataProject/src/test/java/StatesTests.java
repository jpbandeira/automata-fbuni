import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import projeto.padraostate.pedido.Pedido;
import projeto.padraostate.states.enuns.EstadoAnterior;

import static org.junit.Assert.assertEquals;

public class StatesTests {

    private Pedido pedido;

    @Before
    public void before(){
        this.pedido = new Pedido();
    }

    @After
    public void after(){
        System.out.println("Teste finalizado");
    }

    @Test
    public void testeDeCadeiaSemImpedimento(){
        pedido.seguirFluxo();
        pedido.seguirFluxo();
        pedido.seguirFluxo();
        pedido.seguirFluxo();
        pedido.seguirFluxo();

        assertEquals( true, pedido.getEstadoFinal());
    }

    @Test
    public void testeDeCadeiaImpedidaEmPedidoNovoSemSeguirFluxoCompleto(){
        pedido.impedir();
        pedido.getState().printarStatus();

        assertEquals("Quando o estado Pedido Novo foi impedido, o mesmo deve ser setado como estado anterior"
                ,EstadoAnterior.PEDIDONOVO, pedido.getEstadoAnterior());
        assertEquals( "Quando o estado Pedido Novo foi impedido, o mesmo não deve ser estado final e a cadeia não sera aceita"
                ,false, pedido.getEstadoFinal());
    }

    @Test
    public void testeDeCadeiaImpedidaEmPagamentoRealizadoSemSeguirFluxoCompleto(){
        pedido.seguirFluxo();
        pedido.impedir();
        pedido.getState().printarStatus();

        assertEquals("Quando o estado Pagamento Realizado foi impedido, o mesmo deve ser setado como estado anterior"
                ,EstadoAnterior.PAGAMENTOREALIZADO, pedido.getEstadoAnterior());
        assertEquals( "Quando o estado Pagamento Realizado foi impedido, o mesmo não deve ser estado final e a não sera aceita"
                ,false, pedido.getEstadoFinal());
    }

    @Test
    public void testeDeCadeiaImpedidaEmAprovadoSemSeguirFluxoCompleto(){
        pedido.seguirFluxo();
        pedido.seguirFluxo();
        pedido.impedir();
        pedido.getState().printarStatus();

        assertEquals("Quando o estado Aprovado foi impedido, o mesmo deve ser setado como estado anterior"
                ,EstadoAnterior.APROVADO, pedido.getEstadoAnterior());
        assertEquals( "Quando o estado Aprovado foi impedido, o mesmo não deve ser estado final e a não sera aceita"
                ,false, pedido.getEstadoFinal());
    }

    @Test
    public void testeDeCadeiaImpedidaEmPedidoNovoSeguindoFluxoCompleto(){
        pedido.impedir();
        pedido.getState().printarStatus();
        pedido.voltarFluxo();
        pedido.seguirFluxo();
        pedido.seguirFluxo();
        pedido.seguirFluxo();
        pedido.seguirFluxo();
        pedido.seguirFluxo();


        assertEquals("Quando o estado Pedido Novo for impedido e o seguir seu fluxo completo, o ultimo estado tem que ser o final e retornar true," ,
                true, pedido.getEstadoFinal());
    }

    @Test
    public void testeDeCadeiaImpedidaEmPagamentoRealizadoSeguindoFluxoCompleto(){
        pedido.seguirFluxo();
        pedido.impedir();
        pedido.getState().printarStatus();
        pedido.voltarFluxo();
        pedido.seguirFluxo();
        pedido.seguirFluxo();
        pedido.seguirFluxo();
        pedido.seguirFluxo();


        assertEquals("Quando o estado Pagamento Realizado for impedido e o seguir seu fluxo completo, o ultimo estado tem que ser o final e retornar true," ,
                true, pedido.getEstadoFinal());
    }

//    @Test
//    public void testeDeCadeiaImpedidaEmAprovadoSeguindoFluxoCompleto(){
//        pedidoNovo.seguirFluxo(pedido);
//        pedidoNovo.printarStatus();
//
//        pagamentoRealizado.seguirFluxo(pedido);
//        pagamentoRealizado.printarStatus();
//
//        aprovado.impedir(pedido);
//
//        impedido.voltarFluxo(pedido);
//        impedido.printarStatus();
//
//        aprovado.seguirFluxo(pedido);
//        aprovado.printarStatus();
//
//        trasportado.seguirFluxo(pedido);
//        trasportado.printarStatus();
//
//        entregue.seguirFluxo(pedido);
//        entregue.printarStatus();
//
//        finalizado.printarStatus();
//
//        assertEquals("Quando o estado Aprovado for impedido e o seguir seu fluxo completo, o ultimo estado tem que ser o final e retornar true," ,
//                true, pedido.getEstadoFinal());
//    }
//
//    @Test
//    public void testeDeCadeiaCanceladoEmPedidoNovoSeguindoFluxoCompleto(){
//
//        pedidoNovo.impedir(pedido);
//        pedidoNovo.printarStatus();
//
//        impedido.seguirFluxo(pedido);
//        impedido.printarStatus();
//
//        cancelado.printarStatus();
//
//        assertEquals("Quando o estado Pedido Novo for Cancelado, ele deve ficar impedido anteriormente, o ultimo estado tem que ser o final e retornar true," ,
//                true, pedido.getEstadoFinal());
//    }
//
//    @Test
//    public void testeDeCadeiaCanceladoEmPagamentoRealizadoSeguindoFluxoCompleto(){
//
//        pedidoNovo.seguirFluxo(pedido);
//        pedidoNovo.printarStatus();
//
//        pagamentoRealizado.impedir(pedido);
//        pagamentoRealizado.printarStatus();
//
//        impedido.seguirFluxo(pedido);
//        impedido.printarStatus();
//
//        cancelado.printarStatus();
//
//        assertEquals("Quando o estado Pagamento Realizado for Cancelado, ele deve ficar impedido anteriormente, o ultimo estado tem que ser o final e retornar true," ,
//                true, pedido.getEstadoFinal());
//    }
//
//    @Test
//    public void testeDeCadeiaCanceladoEmAprovadoSeguindoFluxoCompleto(){
//
//        pedidoNovo.seguirFluxo(pedido);
//        pedidoNovo.printarStatus();
//
//        pagamentoRealizado.seguirFluxo(pedido);
//        pagamentoRealizado.printarStatus();
//
//        aprovado.impedir(pedido);
//        aprovado.printarStatus();
//
//        impedido.seguirFluxo(pedido);
//        impedido.printarStatus();
//
//        cancelado.printarStatus();
//
//        assertEquals("Quando o estado Aprovado for Cancelado, ele deve ficar impedido anteriormente, o ultimo estado tem que ser o final e retornar true," ,
//                true, pedido.getEstadoFinal());
//    }
//
//    @Test
//    public void testeDeCadeiaNaoAceitaEmPedidoNovo(){
//        pedidoNovo.voltarFluxo(pedido);
//        pedidoNovo.printarStatus();
//
//        assertEquals("Quando no estado Pedido Novo, tentar voltar para um estado anterior a ele, a cadeita não deve ser aceita e retornar false, informando que o estado não é o final",
//                false, pedido.getEstadoFinal());
//    }
//
//    @Test
//    public void testeDeCadeiaNaoAceitaEmPagamentoRealizado(){
//        pedidoNovo.seguirFluxo(pedido);
//        pedidoNovo.printarStatus();
//
//        pagamentoRealizado.voltarFluxo(pedido);
//        pagamentoRealizado.printarStatus();
//
//        assertEquals("Quando no estado Pagamento Realizado, tentar voltar para um estado anterior a ele, a cadeita não deve ser aceita e retornar false, informando que o estado não é o final",
//                false, pedido.getEstadoFinal());
//    }
//
//    @Test
//    public void testeDeCadeiaNaoAceitaEmAprovado(){
//        pedidoNovo.seguirFluxo(pedido);
//        pedidoNovo.printarStatus();
//
//        pagamentoRealizado.seguirFluxo(pedido);
//        pagamentoRealizado.printarStatus();
//
//        aprovado.voltarFluxo(pedido);
//        aprovado.printarStatus();
//
//        assertEquals("Quando no estado Aprovado, tentar voltar para um estado anterior a ele, a cadeita não deve ser aceita e retornar false, informando que o estado não é o final",
//                false, pedido.getEstadoFinal());
//    }
//
//    @Test
//    public void testeDeCadeiaNaoAceitaEmTransportado(){
//        pedidoNovo.seguirFluxo(pedido);
//        pedidoNovo.printarStatus();
//
//        pagamentoRealizado.seguirFluxo(pedido);
//        pagamentoRealizado.printarStatus();
//
//        aprovado.seguirFluxo(pedido);
//        aprovado.printarStatus();
//
//        trasportado.voltarFluxo(pedido);
//        trasportado.printarStatus();
//
//        assertEquals("Quando no estado Transportado, tentar voltar para um estado anterior a ele, a cadeita não deve ser aceita e retornar false, informando que o estado não é o final",
//                false, pedido.getEstadoFinal());
//    }
//
//    @Test
//    public void testeDeCadeiaNaoAceitaEmEntregue(){
//        pedidoNovo.seguirFluxo(pedido);
//        pedidoNovo.printarStatus();
//
//        pagamentoRealizado.seguirFluxo(pedido);
//        pagamentoRealizado.printarStatus();
//
//        aprovado.seguirFluxo(pedido);
//        aprovado.printarStatus();
//
//        trasportado.seguirFluxo(pedido);
//        trasportado.printarStatus();
//
//        entregue.voltarFluxo(pedido);
//        entregue.printarStatus();
//
//        assertEquals("Quando no estado Entregue, tentar voltar para um estado anterior a ele, a cadeita não deve ser aceita e retornar false, informando que o estado não é o final",
//                false, pedido.getEstadoFinal());
//    }
//
//    @Test
//    public void testeDeCadeiaNaoAceitaEmFinalizado(){
//        pedidoNovo.seguirFluxo(pedido);
//        pedidoNovo.printarStatus();
//
//        pagamentoRealizado.seguirFluxo(pedido);
//        pagamentoRealizado.printarStatus();
//
//        aprovado.seguirFluxo(pedido);
//        aprovado.printarStatus();
//
//        trasportado.seguirFluxo(pedido);
//        trasportado.printarStatus();
//
//        entregue.seguirFluxo(pedido);
//        entregue.printarStatus();
//
//        finalizado.voltarFluxo(pedido);
//        finalizado.printarStatus();
//
//        assertEquals("Quando no estado Finalizado, tentar voltar para um estado anterior a ele, a cadeita foi aceita, deve retornar true, mas não pode voltar para outro estado.",
//                true, pedido.getEstadoFinal());
//    }
//
//    @Test
//    public void testeDeCadeiaNaoAceitaEmCancelado(){
//        pedidoNovo.seguirFluxo(pedido);
//        pedidoNovo.printarStatus();
//
//        pagamentoRealizado.seguirFluxo(pedido);
//        pagamentoRealizado.printarStatus();
//
//        aprovado.impedir(pedido);
//        aprovado.printarStatus();
//
//        impedido.seguirFluxo(pedido);
//        impedido.printarStatus();
//
//        cancelado.voltarFluxo(pedido);
//        cancelado.printarStatus();
//
//
//        assertEquals("Quando no estado Cancelado, tentar voltar para um estado anterior a ele, a cadeita foi aceita, deve retornar true, mas não pode voltar para outro estado.",
//                true, pedido.getEstadoFinal());
//    }
}
