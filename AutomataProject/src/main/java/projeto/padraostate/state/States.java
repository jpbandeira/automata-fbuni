package projeto.padraostate.state;

import projeto.padraostate.pedido.Pedido;

public interface States {

    String onPedidoNovo(Pedido pedido);
    String onPagamentoRealizado(Pedido pedido);
    String onAprovado(Pedido pedido);
    String onTransportado(Pedido pedido);
    String onEntregue(Pedido pedido);
    String onCancelado(Pedido pedido);
    String onFinalizado(Pedido pedido);
}
