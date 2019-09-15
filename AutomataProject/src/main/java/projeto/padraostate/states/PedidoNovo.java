package projeto.padraostate.states;


import projeto.padraostate.pedido.Pedido;
import projeto.padraostate.state.States;

public class PedidoNovo implements States {

    public String onPedidoNovo(Pedido pedido) {
        return null;
    }

    public String onPagamentoRealizado(Pedido pedido) {
        return null;
    }

    public String onAprovado(Pedido pedido) {
        return null;
    }

    public String onTransportado(Pedido pedido) {
        return null;
    }

    public String onEntregue(Pedido pedido) {
        return null;
    }

    public String onCancelado(Pedido pedido) {
        return null;
    }

    public String onFinalizado(Pedido pedido) {
        return null;
    }
}
