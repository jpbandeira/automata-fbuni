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
public class Impedido implements State {

    public void next(Pedido ped) {
        if (ped.getStatusAnterior() == 1) {
            ped.setState(new PedidoNovo());
        } else if (ped.getStatusAnteriror() == 2) {
            ped.setState(new PagamentoRealizado());
        }
    }

    public void previos(Pedido pedido) {

    }

    public void printStatus() {

    }
}
