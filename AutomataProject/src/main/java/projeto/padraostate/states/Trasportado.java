package projeto.padraostate.states;

import projeto.padraostate.pedido.Pedido;
import projeto.padraostate.state.State;

public class Trasportado implements State {

    public void seguirFluxo (Pedido ped) {
    	ped.setState(new Entregue());
    }
    
	public void voltarFluxo (Pedido ped) {
		System.out.println("Erro: Erro: O estado TRANSPORTADO não possui estado anterior.");
	}
	
	public void impedir (Pedido ped) {
		System.out.println("Erro: Não é possível impedir esse pedido.");
	}

    public void printarStatus () {
    	System.out.println("Sucesso: Seu pedido foi transportado!");
    }
    
}
