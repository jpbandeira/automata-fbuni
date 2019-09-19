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
    
    public Pedido (State state, Integer id, EstadoAnterior estadoAnterior) {
		super();
		this.state = state;
		this.id = id;
		this.estadoAnterior = estadoAnterior.getCodigo();
	}
    
    public void previousState () {
    	state.voltarFluxo(this);
    }
    
    public void nextState () {
    	state.seguirFluxo(this);
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
	
	public Integer getId () {
		return id;
	}
	
	public void setId (Integer id) {
		this.id = id;
	}
	
	public EstadoAnterior getEstadoAnterior () {
		return EstadoAnterior.toEnum(estadoAnterior);
	}
	
	public void setEstadoAnterior (EstadoAnterior estadoAnterior) {
		this.estadoAnterior = estadoAnterior.getCodigo();
	}

	public boolean isEstadoFinal () {
		return estadoFinal;
	}

	public void setEstadoFinal (boolean estadoFinal) {
		this.estadoFinal = estadoFinal;
	}

	public boolean getEstadoFinal(){
        return estadoFinal;
    }

}
