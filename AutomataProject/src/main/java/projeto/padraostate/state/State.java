package projeto.padraostate.state;

import projeto.padraostate.pedido.Pedido;

public interface State {

    void next(Pedido pedido);
    void previos(Pedido pedido);
    void printStatus();
}
