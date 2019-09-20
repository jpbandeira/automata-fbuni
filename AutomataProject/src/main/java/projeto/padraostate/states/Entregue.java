package projeto.padraostate.states;

import projeto.padraostate.pedido.Pedido;
import projeto.padraostate.state.State;

public class Entregue implements State {

    public void seguirFluxo (Pedido ped) {
    	ped.setState(new Finalizado());
    	ped.setEstadoFinal(true);
    }
    
	public void voltarFluxo (Pedido ped) {
		System.out.println("Erro: O estado ENTREGUE não possui estado anterior.");
	}
	
	public void impedir (Pedido ped) {
		System.out.println("Erro: Não é possível impedir esse pedido.");
	}

    public void printarStatus () {
    	System.out.println("Sucesso: Seu pedido foi entregue!");
    }
}
