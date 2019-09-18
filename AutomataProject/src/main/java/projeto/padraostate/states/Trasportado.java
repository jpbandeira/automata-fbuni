package projeto.padraostate.states;

import projeto.padraostate.pedido.Pedido;
import projeto.padraostate.state.State;

public class Trasportado implements State {

    public void next(Pedido ped) {
    	ped.setState(new Entregue());
    }

    public void printStatus() {
    	System.out.println("Seu pedido foi transportado com sucesso");
    }
}
