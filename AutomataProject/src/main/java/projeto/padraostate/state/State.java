package projeto.padraostate.state;

import projeto.padraostate.pedido.Pedido;

public interface State {

    void seguirFluxo (Pedido ped);
    void voltarFluxo (Pedido ped);
    void impedir (Pedido ped);
    void printarStatus ();
}
