package projeto.padraostate.states;

import projeto.padraostate.pedido.Pedido;
import projeto.padraostate.state.State;
import projeto.padraostate.states.enuns.EstadoAnterior;

public class PedidoNovo implements State {

    public void seguirFluxo (Pedido ped) {
        ped.setState(new PagamentoRealizado());
        this.printarStatus();
    }
    
	public void voltarFluxo (Pedido ped) {
		System.out.println("Erro: O estado PEDIDO NOVO não possui estado anterior.");
	}
	
	public void impedir (Pedido ped) {
        ped.setState(new Impedido());
        this.printarStatus();
        ped.setEstadoAnterior(EstadoAnterior.PEDIDONOVO);
    }

    public void printarStatus () {
        System.out.println("Sucesso: Seu pedido foi iniciado!");
    }
    
}
