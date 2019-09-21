package projeto.padraostate.pedido;

import projeto.padraostate.state.State;
import projeto.padraostate.states.PedidoNovo;
import projeto.padraostate.states.enuns.EstadoAnterior;

public class Pedido{

    private State state = new PedidoNovo();
    private Integer id;
    private Integer estadoAnterior;
    private boolean estadoFinal;
	
    public Pedido () {	
    }    

    public void voltarFluxo() {
    	state.voltarFluxo(this);
		toString();
    }
    
    public void seguirFluxo() {
    	state.seguirFluxo(this);
    	state.printarStatus();
    }
    
    public void impedir () {
    	state.impedir(this);
    }
    
	public State getState () {
		return state;
	}
	
	public void setState (State state) {
		this.state = state;
	}
	
	public EstadoAnterior getEstadoAnterior () {
		return EstadoAnterior.toEnum(estadoAnterior);
	}
	
	public void setEstadoAnterior (EstadoAnterior estadoAnterior) {
		this.estadoAnterior = estadoAnterior.getCodigo();
	}

	public void setEstadoFinal (boolean estadoFinal) {
		this.estadoFinal = estadoFinal;
	}

	public boolean getEstadoFinal(){
        return estadoFinal;
    }

}
