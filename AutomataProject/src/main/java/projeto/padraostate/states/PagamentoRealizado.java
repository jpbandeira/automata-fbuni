package projeto.padraostate.states;

import projeto.padraostate.pedido.Pedido;
import projeto.padraostate.state.State;
import projeto.padraostate.states.enuns.EstadoAnterior;

public class PagamentoRealizado implements State {

    public void next(Pedido ped) {
        ped.setState(new Aprovado());
    }
    
    public void impedir(Pedido ped) {
    	ped.setState(new Impedido());
    	ped.setEstadoAnterior(EstadoAnterior.PAGAMENTOREALIZADO);
    }

    public void printStatus() {
        System.out.println("Seu pagagmento foi realizado com sucesso!!");

    }
}
