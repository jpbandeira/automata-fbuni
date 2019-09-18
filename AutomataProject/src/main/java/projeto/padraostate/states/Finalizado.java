package projeto.padraostate.states;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import projeto.padraostate.pedido.Pedido;
import projeto.padraostate.state.State;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Finalizado implements State {

    public void next(Pedido pedido) {
    	System.out.println("ERR: Seu pedido já foi finalizado");
    }
    
	public void previous(Pedido ped) {
		System.out.println("Esse estado não possui estado anterior");
	}
	
	public void impedir(Pedido ped) {
		System.out.println("Não é possível impedir esse pedido.");	
	}

    public void printStatus() {
    	System.out.println("Pedido finalizado");
    }
}
