package projeto.padraostate.states;

import projeto.padraostate.pedido.Pedido;
import projeto.padraostate.state.State;

public class Finalizado implements State {

    public void seguirFluxo (Pedido pedido) {
    	System.out.println("Erro: Seu pedido já foi finalizado.");
    }
    
	public void voltarFluxo (Pedido ped) {
		System.out.println("Erro: O estado FINALIZADO não possui estado anterior.");
	}
	
	public void impedir (Pedido ped) {
		System.out.println("Erro: Não é possível impedir esse pedido.");
	}

    public void printarStatus () {
    	System.out.println("Sucesso: Pedido finalizado!");
    }
}
