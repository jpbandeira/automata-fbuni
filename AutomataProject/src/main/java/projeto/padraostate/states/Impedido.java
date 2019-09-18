package projeto.padraostate.states;

import projeto.padraostate.pedido.Pedido;
import projeto.padraostate.state.State;

public class Impedido implements State {

    public void next(Pedido ped) {
        ped.setState(new Cancelado());
        ped.setEstadoFinal(true);
    }

    public void previous(Pedido ped) {
    	if (ped.getEstadoAnterior().getCodigo() == 1) {
            ped.setState(new PedidoNovo());
            ped.setEstadoAnterior(null);
        } else if (ped.getEstadoAnterior().getCodigo() == 2) {
            ped.setState(new PagamentoRealizado());
            ped.setEstadoAnterior(null);
        }else if(ped.getEstadoAnterior().getCodigo() == 3) {
        	ped.setState(new Aprovado());
        	ped.setEstadoAnterior(null);
        }
    }

    public void printStatus() {
    	System.out.println("Seu pedido esta em estado pendente!!");
    }
}
