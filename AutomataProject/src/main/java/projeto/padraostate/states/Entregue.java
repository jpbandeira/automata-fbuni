package projeto.padraostate.states;

import projeto.padraostate.pedido.Pedido;
import projeto.padraostate.state.State;

public class Entregue implements State {

    public void next(Pedido ped) {
    	ped.setState(new Finalizado());
    }

    public void printStatus() {
    	System.out.println("Seu pedido foi entregue com sucesso");
    }
}
