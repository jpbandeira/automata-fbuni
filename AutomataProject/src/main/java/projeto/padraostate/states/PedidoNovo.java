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
public class PedidoNovo implements State {

    public void next (Pedido ped) {
        ped.setState(new PagamentoRealizado());
    }

    public void previos (Pedido ped) {
        System.out.println("Erro: Não é possível retornar o pedido nesse estado.");
    }

    public void impedir (Pedido ped) {
        ped.setState(new Impedido());
        ped.setStatusAnterior(1);
    }

    public void printStatus () {
        System.out.println("Sucesso: Seu pedido foi iniciado.");
    }
}
