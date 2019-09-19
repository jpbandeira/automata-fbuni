package projeto.padraostate.states;

import projeto.padraostate.pedido.Pedido;
import projeto.padraostate.state.State;
import projeto.padraostate.states.enuns.EstadoAnterior;

public class PedidoNovo implements State {

    public void seguirFluxo (Pedido ped) {
        ped.setState(new PagamentoRealizado());
    }
    
	public void voltarFluxo (Pedido ped) {
		System.out.println("Erro: Esse estado não possui estado anterior.");
	}
	
	public void impedir (Pedido ped) {
        ped.setState(new Impedido());
        ped.setEstadoAnterior(EstadoAnterior.PEDIDONOVO);
    }

    public void printarStatus () {
        System.out.println("Sucesso: Seu pedido foi iniciado!");
    }
    
}
