package projeto.padraostate.state;

import projeto.padraostate.pedido.Pedido;

public interface State {

    void next(Pedido ped);
    void previous(Pedido ped);
    void impedir(Pedido ped);
    void printStatus();
}
